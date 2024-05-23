# <p align="center">Telebo<i>f</i></p>
<p align="center">Level up your telegram bot development with java 🔥</p>

## <p align="center">Supported Bot API version: <a href="https://core.telegram.org/bots/api#march-9-2023">6.6</a>
<hr>

## Contents
* [Setup Environment](#installation)
* [Your First Echo Bot](#your-first-echo-bot)
* [Available Types](#available-types) 
* [Listening Updates](handling-updates)
* [Filtering Updates](#filtering-updates)
* [Markup](#markup)
    * [Reply Keyboard Markup](#replymarkup)
    * [Inline Keyboard Markup](#inlinekeyboardmarkup)
    * [Remove Reply Keyboard](#removereplykeyboard)
    * [Force Reply](#forcereply)
* [Advanced Usages](advanced-usages)
  * [Local Bot API Server](#local-bot-api-server)
  * [Logging](#logging)
  * [Proxy](#proxy)
* [Types of Handlers](#types-of-handlers)
  

## Installation

* Installation using maven 

```xml
<dependecy>
    <groupId>et.telebof</groupId>
    <artifactId>telegrambot</artifactId>
    <version>1.0.0</version>
</dependecy>

```

### Your First Echo Bot

```java
import et.telebof.BotClient;
import et.telebof.TelegramContext;
import et.telebof.handlers.MessageHandler;
import et.telebof.types.Message;

public class MyFirstBot {
  static final String TOKEN = "YOUR BOT TOKEN HERE";

  public static void main(String[] args) {
    final BotClient client = new BotClient(TOKEN);

    // Listening for /start command
    client.onMessage(filter -> filter.commands("start"), new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
        ctx.sendMessage("Hello, welcome to your first bot!").bind();
      }
    });

    // Listening for any text
    client.onMessage(filter -> filter.TEXT, new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
        ctx.sendMessage(message.getText()).bind();
      }
    });

    client.start(); // finally run the bot
  }

}
```
**Do not worry if you do not understand what the above code mean, it will be explained in the next chapter.** 

## Available Types
All Telegram types are defined in `et.telebof.types`. They are the same as Telegram types.

## Listening Updates
### Update
Update is an event that bot receives from user like incoming messages, pressing button or in group, supergroup and channels like:
new member joins, left etc.

There are 14 updates type that a bot can receive. These updates are handled
by registering one or more callback classes. 

Each update has its own handler. These handlers take two parameters as argument: filter class 
and callback class. The filter class is a lambda class of `et.telebof.filter.FilterExecutor` takes `et.telebof.filter.Filter`
as an argument and returns `Boolean`, so that if the condition of this filter 
matches with the update sent from telegram, the callback class will be called and its body gets execute.

As an example let's try to handle `Message` update using `onMessage` method.

```java

import et.telebof.BotClient;
import et.telebof.TelegramContext;
import et.telebof.handlers.MessageHandler;
import et.telebof.types.Message;

class MyBot {
  public static void main(String[] args) {

    final String TOKEN = "Replace with your own bot token";

    BotClient client = new BotClient(TOKEN);

    client.onMessage(filter -> filter.commands("start"), new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
        ctx.sendMessage("Hello, welcome to your first bot!").bind();
      }
    });

    client.onMessage(filter -> filter.TEXT, new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
        ctx.sendMessage(message.getText()).bind();
      }
    });

    client.start();
  }
}
```
We have two handlers: `/start` command handler and `text` handler.

The first handler handles `/start` command and send back a text `Hello, welcome to your first bot!`.
The second handler handles any incoming text and echoes this text.

Our callback classes take two arguments: `et.telebof.TelegramContext` class and a class of an update which is being handled respectively.
Now we are handling `Message` so our second parameter should be `et.telebof.types.Message`.

`et.telebof.TelegramContext` class contains all telegram methods and their shortage methods except `setWebhook`, `deleteWebhook` and `getInfoWebhook`.
Through this class you can send messages, answer callback queries, answer inline queries and perform other telegram actions. And `et.telebof.types.Message` class is an object
of telegram `Message` update.

**Note**: All handlers are handled in the order in which they were registered.

- The method `sendMessage` sends message to specified `chat_id`.
- `chat_id` is an optional parameter, which means that you can pass its value or its value will be passed from `Message`
object which was received from telegram.
```java
ctx.sendMessage(message.getChat().getId(), "Hello, World!").bind();

// You can also specify yours
ctx.sendMessage(123456789L, "Hello, World!").bind();
ctx.sendMessage("@chatUsername", "Hello, World!").bind();

// Or it's chat_id is passed from the message update received from telegram
ctx.sendMessage("Hello, World!").bind();
```
- `bind()` is an enclosing and request sender method. This means that before ending and sending request, you can pass 
optional parameters and then send a request to telegram. For example `sendMessage` method has optional parameters like: 
`parseMode`, `replyMarkup`. So you can pass their value for these parameters and send request to telegram.

```java
ctx.sendMessage("*Hello, World*").parseMode(ParseMode.MARKDOWN).bind();
```

Finally we start our bot by using `start()` which does not take any parameter and run our bot via **long polling.** 


### Using Handlers

Handlers are found in `et.telebof.Handlers`. They can be implemented through anonymous class:

```java
import et.telebof.BotClient;
import et.telebof.TelegramContext;
import et.telebof.handlers.MessageHandler;
import et.telebof.handlers.MessageHandler;
import et.telebof.types.Message;

public class MyBot {
  public static void main(String[] args) {
    BotClient client = new BotClient.Builder("TOKEN").build();

    client.onMessage(filter -> filter.commands("start"), new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
      }
    });
  }
}
```

Or using class:

```java
import et.telebof.BotClient;
import et.telebof.TelegramContext;
import et.telebof.handlers.MessageHandler;
import et.telebof.types.Message;

class StartCommand implements MessageHandler {
  @Override
  public void handle(TelegramContext ctx, Message message) {
    // ...
  }
}

public class MyBot {
  public static void main(String[] args) {
    BotClient client = new BotClient.Builder("TOKEN").build();

    client.onMessage(filter -> filter.commands("start"), new StartCommand());
  }
}
```

## Filtering Updates

In previous topic we have seen how to create handlers and how they work. In this section we will talk about how filters 
work and how we use them.

As previously discussed, all handlers take two parameters: filter class and callback class. 
These filter classes are used for filtering content of updates and separate the same update by content they hold. 

### Predefined Filters 
- `filter.TEXT` - filter filed `message.text`  
- `filer.PHOTO` - filter field `message.photo` is not null 
- `filter.VIDEO` - filter field `message.video` is not null
- `filter.VOICE` - filter field `message.voice` is not null
- `filter.AUDIO` - filter field `message.audio` is not null
- `filter.ANIMATION` - filter field `message.animaion` is not null
- `filter.DOCUMENT` - filter field `message.document` is not null
- `filter.VIDEO_NOTE` - filter field `message.videoNote` is not null
- `filter.CONTACT` - filter field `message.contact` is not null
- `filter.LOCATION` - filter field `message.loaction` is not null
- `filter.GAME` - filter field `message.game` is not null
- `filter.VENUE` - filter field `message.venue` is not null
- `filter.STICKER` - filter field `message.sticker` is not null
- `filter.DICE` - filter field `message.dice` is not null
- `filter.MEDIA` - filter one of filed of media(photo, video, audio) is not null.
- `filter.PASSPORT_DATA` - filter field `message.photo` is not null
- `filter.INVOICE` - filter field `message.invoice` is not null
- `filter.NEW_CHAT_MEMBER` - filter field `message.newChatMembers` is not null
- `filter.LEFT_CHAT_MEMBER` - filter field `message.leftChatMember` is not null
- `filter.NEW_CHAT_PHOTO` - filter field `message.newChatPhoto` is not null
- `filter.NEW_CHAT_TITLE` - filter field `message.newChatTitle` is not null
- `filter.GROUP_CHAT_CREATED` - filter field `message.groupChatCreated` is not null
- `filter.SUPERGROUP_CHAT_CREATED` - filter field `message.supergroupChatCreated` is not null
- `filter.CHANNEL_CHAT_CREATED` - filter field `message.channelChatCreated` is not null
- `filter.MESSAGE_AUTO_DELETE_TIMER_CHANGED` - filter field `message.messageAutoTimerChanged` is not null
- `filter.MIGRATED` - filter field `message.migrateFromChatId` or `message.migrateToChatId` is not null
- `filter.PINNED_MESSAGE` - filter field `message.pinnedMessage` is not null
- `filter.SUCCESFULL_PAYMENT` - filter field `message.successfullPayment` is not null
- `filter.CONNNECTED_WEBSITE` - filter field `message.connectedWebsite` is not null
- `filter.PROXIMITY_ALERT_TRIGGERED` - filter field `message.proximityAlertTrigged` is not null
- `filter.FORUM_TOPIC_CREATED` - filter field `message.forumTopicCreated` is not null
- `filter.FORUM_TOPIC_CLOSED` - filter field `message.forumTopicClosed` is not null
- `filter.FORUM_TOPIC_EDITED` - filter field `message.forumTopicEdited` is not null
- `filter.FORUM_TOPIC_REOPNED` - filter field `message.forumTopicReopened` is not null
- `filter.WEB_APP_DATA` - filter field `message.webAppData` is not null
- `filter.VIDEO_CHAT_STARTED` - filter field `message.videoChatStarted` is not null
- `filter.VIDEO_CHAT_ENDED` - filter field `message.videoChatEnded` is not null
- `filter.VIDEO_CHAT_PARTICIPANT_INVITED` - filter field `message.videoChatParticipantInvited` is not null
- `filter.VIDEO_CHAT_SCHEDULED` - filter field `message.videoChatScheduled` is not null
- `filter.FORWARDED` - filter field `message.forwardFrom` or `message.forwardFromChat` is not null
- `filter.REPLIED` - filter field `message.replyToMessage` is not null
- `filter.BOT` - filter user is bot or filed `message.from.isBot` is `true`
- `filter.ZERO_INLINE_QUERY` - filter filed `inlineQuery.query` is empty or has no value
- `filter.PRIVATE` - filter chat type is `private`
- `filter.GROUP` - filter chat type is `group`
- `filter.SUPERGROUP` - filter chat type is `supergroup`
- `filter.CHANNEL` - filter chat type is `channel`
- `filter.commands(String ... cmds)` - filter commands like `/start`, `/help`.
- `filter.callbackData(String ... cds)` - filter of inline buttons or filed `callbackQuery.data`
- `filter.inlineQuery(String... iqs)` - filter inline query or field `inlineQuery.query`
- `filter.customFilter()` - filter given filter
- `filter.state(String ... names)` - filter current state.

```java

// handling incoming texts
client.onMessage(filter -> filter.TEXT, new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message){

    }
});

// handling incoming photos
client.onMessage(filter -> filter.PHOTO, new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message){

    }
});


// handling incoming videos
client.onMessage(filter -> filter.VIDEO, new MessageHandler() {
  @Override
  public void handle(TelegramContext ctx, Message message){

  }
});
```
### Two or more filters at once
You may want to handle `text` and `photo` in one handler or a `text` in different chats. To do so use logical operators 
(&&, ||, !) and combine them together. 

Here are some examples

```java

// handles an incoming text or photo
client.onMessage(filter -> filter.TEXT || filter.PHOTO, new MessageHandler(){
    @Override
    public void handle(TelegramContext ctx, Message message){
        
    }
});

// handles incoming text in private chat
client.onMessage(filter -> filter.TEXT && filter.PRIVATE, new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message){

    }
});

// handles incoming text in supergroup chat 
client.onMessage(filter -> filter.TEXT && filter.SUPERGROUP, new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message){

    }
});

// handles incoming audio or video in private chat
client.onMessage(filter -> filter.PRIVATE && (filter.AUDIO || filter.VIDEO), new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message){

    }
});

```
### Defining your own filter
You can define your own filter using `filter.customFilter`.

This example will show you how you can define filters using `et.telebof.filters.CustomFilter` and `filter.customFilter`.

```java
import et.telebof.TelegramContext;
import et.telebof.filters.CustomFilter;
import et.telebof.handlers.MessageHandler;
import et.telebof.types.Message;
import et.telebof.types.Update;


// Filter whether the incoming message text is number or not.

class IsNumberFilter implements CustomFilter {
  @Override
  public boolean check(Update update) {
    Message message = update.message;
    try {
      int number = Integer.parseInt(message.text);
      return true; // If it is parsed without any error, then it is number
    } catch (NumberFormatException e) {
      // If the text is not number
      return false;
    }
  }
}

class NumberFilterBot {
  public static void main(String[] args) {
    // ...
    client.onMessage(filter -> filter.TEXT && filter.customFilter(new IsNumberFilter()), new MessageHandler() {
      @Override
      public void handle(TelegramContext ctx, Message message) {
        ctx.sendMessage("It is number").bind();
      }
    });
  }
}
```

### Other Filters

There are some advanced filters for handling incoming `command` from user, `pressing button`(callback data), `inline query`. These are 
`filter.commands`, `filter.callbackData` and `filter.inlineQuery` respectively.

Example for handling commands using `filter.commands`

```java

// handles /start command
client.onMessage(filter -> filter.commands("start"), new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message) {
        // ...
    }
});

// handles /help command
client.onMessage(filter -> filter.commands("help"), new MessageHandler() {
    @Override
    public void handle(TelegramContext ctx, Message message) {
        //...
    }
})
```

Example for handling inline button through its callback data using `filter.callbackData`

```java
// handles inline button which its callback data equals with "A"
client.onCallback(filter -> filter.callbackData("A"), new CallbackHandler() {
    @Override
    public void handle(TelegramContext ctx, CallbackQuery callbackQuery) {
        ctx.answerCallbackQuery("You pressed A button!").bind();
    }
});
```

Example for handling inline query using `filter.inlineQuery`
```java
// handles an inline query which its query equals with a word "hello"
client.onInline(filter -> filter.inlineQuery("hello"), new InlineHandler() {
    @Override
    public void handle(TelegramContext ctx, InlineQuery inlineQuery) {
        // ...
    }
});
```

### Conversational Filter
There is another special filter to make conversations with bot called `filter.state`.

```java
client.onMessage(filter -> filter.commands("start"), new MessageHandler() {
  @Override
  public void handle(TelegramContext ctx, Message message) {
    ctx.sendMessage("What is your name?").bind();
    ctx.setState("name"); // set our state to `name`. You can set whatever
  }
});

client.onMessage(filter -> filter.state("name") && filter.TEXT, new MessageHandler() {
  @Override
  public void handle(TelegramContext ctx, Message message) {
    ctx.sendMessage(String.format("Your name is %s", message.getText()));
    ctx.clearState();
  }
});
```

## Markups
### ReplyMarkup
Example for using reply markup

```java
ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup()
        .resizeKeyboard(true) // resize keyboard
        
markup.add("A", "B", "C"); // You can add String or 
markup.add("D", "E"); 
markup.add(new KeyboardButton("F")); // KeybaordButton class

client.sendMssage("Hello, World!").replyMarkup(markup).bind();
```

### InlineKeyboardMarkup
example for using InlineKeyboardMarkup

```java
InlineKeybaordMarkup inlineMarkup = new InlineKeybaordMarkup();

// You can specify rowWidth, default is 3
markup.rowWidth(2); // row width set to 2

inlineMarkup.addKeybaord(
  new InlineKeybaordButton("A").callbackData("a"), 
  new InlineKeybaordButton("C").callbackData("b"), 
  new InlineKeybaordButton("Url").url("www.example.com")
); // at 3 rowWidth 

// also  possible
InlineKeybaordMarkup inlineMarkup = new InlineKeybaordMarkup(new InlineKeybaordButton[]{
  new InlineKeybaordButton("A").callbackData("a"), 
  new InlineKeybaordButton("B").callbackData("b")
}, 1); // 1 rowWidth

// also possible
InlineKeybaordMarkup inlineMarkup = new InlineKeybaordMarkup(new InlineKeybaordButton[][]{
    new InlineKeybaordButton[]{
      new InlineKeybaordButton("A").callbackData("a"), 
      new InlineKeybaordButton("B").callbackData("b")
    }, // 2 rows
    new InlineKeyboardButton[]{
      new InlineKeyboardButton("Url").url("www.example.com")
    } // 1 row
  } 
)

ctx.sendMessage("Press one button").replyMarkup(inlineMarkup).bind();
```

### ForceReply
```java
ctx.sendMessage("Can you tell me your name please?").replyMarkup(new ForceReply()).bind(); // ForceReply markup
```

### RemoveReplyKeyboard
```java
ctx.sendMessage("There is no reply keyboard now").replyMarkup(new RemoveReplyKeybaord()).bind(); 
```


## Using Webhook
```java
import et.telebof.Webhook;

class MyWebhookBot{
    public static void main(String[] args){
        Webhook webhook = new Webhook("www.example.com", "/bot"); // URL and path respectively
        webhook.certificate(new File(""));
        //...
        client.setWebhook(webhook); // set webhook

        //... 
        client.start(); // start our bot using webhook

    }
}
```

## Advanced Usage

### Local Bot API Server

```java
import et.telebof.BotClient;

String url = "https://example.com/";
BotClient client = new BotClient.Builder("<TOKEN>")
        .localBotApiUrl(url)
        .build();
```
**You have to log out your bot from the Telegram server before switching to your local API server using `ctx.logOut().bind()`**

### Logging
log current status of the bot.
```java
import et.telebof.BotClient;

BotClient client = new BotClient.Builder("<TOKEN>")
        .log(true)
        .build();
```

### Proxy

```java
import et.telebof.BotClient;

import java.net.InetSocketAddress;
import java.net.Proxy;

InetSocketAddress address = new InetSocketAddress(80, "127.97.91"); /* This is just an example; you can replace with your
own port and hostname respectively*/ 

Proxy proxy = new Proxy(Proxy.Type.SOCKS, address);
BotClient client = new BotClient
        .Builder("<TOKEN>")
        .proxy(proxy)
        .build();
```

```java
import et.telebof.BotClient;
import et.telebof.enums.ParseMode;
import et.telebof.enums.Updates;

BotClient client = new BotClient.Builder("<TOKEN>")
        .log(true) // Log current status
        .skipOldUpdates(false) // Receive updates sent last 24 hours 
        .defaultParseMode(ParseMode.HTML) // Default parse mode applied to all sendXyz methods
        .limit(10) // Limiting how many updates should be received at maximum per request 
        .useTestServer(false) // Using test server
        .timeout(30) // timeout
        .offset(0) // offset
        .allowedUpdates(new Updates[]{Updates.MESSAGE, Updates.CALLBACK_QUERY}) // Specifying which update should be received 
        .proxy(null) // proxy
        .build(); // build our client
```

## Types of Handlers
There are 14 types of handlers

#### Message Handler

```java
import et.telebof.handlers.MessageHandler;
client.onMessage(filter -> true, new MessageHandler() {
  @Override
  public void handle(TelegramContext ctx, Message message) {
    // ...
  }
}); 
```

#### CallbackQuery handler
```java
import et.telebof.handlers.CallbackHandler;

client.onCallback(filter -> true, new CallbackHandler() {
  @Override
  public void handle(TelegramContext ctx, CallbackQuery callbackQuery) {

  }
});
```

#### Inline Handler
```java
import et.telebof.handlers.InlineHandler;

client.onInline(filter -> true, new InlineHandler() {
  @Override
  public void handle(TelegramContext ctx, InlineQuery inlineQuery) {
  
    }
});
```

#### Poll Handler

```java
import et.telebof.handlers.InlineHandler;

client.onPoll(filter -> true, new PollHandler() {
  @Override
  public void handle(TelegramContext ctx, Poll poll) {

  }
});
```

#### PollAnswer Handler
```java
import et.telebof.handlers.PollAnswerHandler;

client.onPollAnswer(filter -> true, new PollAnswerHandler() {
  @Override
  public void handle(TelegramContext ctx, PollAnswer pollAnswer) {

  }
});
```

#### Shipping Handler
```java
import et.telebof.handlers.ShippingHandler;

client.onShipping(filter -> true, new ShippingHandler() {
  @Override
  public boolean handle(TelegramContext ctx, ShippingQuery shippingQuery) {

  }
});
```

#### ChannelPost Handler
```java
import et.telebof.handlers.ChannelPostHandler;

client.onChannelPost(filter -> true, new ChannelPostHandler() {
  @Override
  public void handle(TelegramContext ctx, Message message) {

  }
});
```

#### PreCheckoutQuery Handler
```java
import et.telebof.handlers.PreCheckoutHandler;

client.onPreCheckout(filter -> true, new PreCheckoutHandler() {
    @Override
    public void handle(TelegramContext ctx, PreCheckoutQuery preCheckoutQuery) {

    }
  });

```

#### EditedMessage Handler
```java
import et.telebof.handlers.EditedMessageHandler;

client.onEditedMessage(filter -> true, new EditedMessageHandler() {
  @Override
  public void handle(TelegramContext ctx, Message editedMessage) {

  }
});
```

#### EditedChannelPost Handler
```java
import et.telebof.handlers.EditedChannelPostHandler;

client.onEditedChannelPost(filter -> true, new EditedChannelPostHandler() {
  @Override
  public void handle(TelegramContext ctx, Message editedChannelPost) {
    
  }
});
```

#### MyChatMember Handler
```java
import et.telebof.handlers.MyChatMemberHandler;

client.onMyChatMember(filter -> true, new MyChatMemberHandler() {
  @Override
  public void handle(TelegramContext ctx, ChatMemberUpdated chatMemberUpdated) {

  }
});
```

#### ChatMember Handler
```java
import et.telebof.handlers.ChatMemberHandler;

client.onChatMember(filter -> true, new ChatMemberHandler() {
  @Override
  public void handle(TelegramContext ctx, ChatMemberUpdated chatMemberUpdated) {

  }
});
```

#### ChosenInlineResult Handler
```java
import et.telebof.handlers.ChosenInlineResultHandler;

client.onChosenInlineResult(filter -> true, new ChosenInlineResultHandler() {
  @Override
  public void handle(TelegramContext ctx, ChosenInlineResult chosenInlineResult) {

  }
});
```
