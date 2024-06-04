# <p align="center">Telebo<i>f</i></p>
<p align="center">Easy and modern Telegram bot API for java.</p>


## <p align="center">Supported Bot API version: 6.7</p>


## Contents
* [Setup Environment](#installation)
* [Your First Echo Bot](#your-first-echo-bot)
* [Available Types](#available-types) 
* [Listening Updates](handling-updates)
* [Filtering Updates](#filtering-updates)
* [Types of Handlers](#types-of-handlers)
* [Markup](#markup)
    * [Reply Keyboard Markup](#replymarkup)
    * [Inline Keyboard Markup](#inlinekeyboardmarkup)
    * [Remove Reply Keyboard](#removereplykeyboard)
    * [Force Reply](#forcereply)
* [Inline Bot](#inline-bot)
* [Advanced Usages](advanced-usages)
  * [Local Bot API Server](#local-bot-api-server)
  * [Logging](#logging)
  * [Proxy](#proxy)
* [Error Handling](#error-handling)
  

## Installation

* Installation using maven 

```xml
<dependecy>
    <groupId>et.telebof</groupId>
    <artifactId>telegrambot</artifactId>
    <version>1.1.1</version>
</dependecy>

```


### Your First Echo Bot

```java
import et.telebof.BotClient;

public class MyFirstBot {
  static final String TOKEN = "YOUR BOT TOKEN HERE";

  public static void main(String[] args) {
    final BotClient bot = new BotClient(TOKEN);

    // Listening for /start command
    bot.onMessage(filter -> filter.commands("start"), (ctx, msg) -> {
      ctx.reply("Hello, welcome to your first bot!").bind();
    });

    // Listening for any text
    bot.onMessage(filter -> filter.TEXT, (ctx, msg) -> {
      ctx.reply(msg.getText()).bind();
    });

    bot.start(); // finally run the bot
  }

}
```
**Do not worry if you do not understand what the above code mean, it will be explained in the next chapter.** 

## Available Types
All Telegram types are defined in `et.telebof.types`. And they are completely the same as Telegram types.

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

class MyBot {
  public static void main(String[] args) {

    final String TOKEN = "Replace with your own bot token";

    BotClient bot = new BotClient(TOKEN);

    bot.onMessage(filter -> filter.commands("start"), (ctx, msg) -> {
        ctx.reply("Hello, welcome to your first bot!").bind();
    });

    bot.onMessage(filter -> filter.TEXT, (ctx, msg) -> {
      ctx.reply(msg.getText()).bind();
    });

    bot.start();
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

**IMPORTANT: All handlers are handled in the order in which they were registered.**

- The `reply` method is a shortage method of `sendMessage` and replies message to specified `chat_id` with `reply_to_message_id` argument.

- `bind()` is an enclosing and request sender method. This means that before ending and sending request, you can pass 
optional parameters and then send a request to telegram. For example `sendMessage` method has optional parameters like: 
`parseMode`, `replyMarkup`. So you can pass their value for these parameters and send request to telegram.

```java
ctx.sendMessage("*Hello, World*").parseMode(ParseMode.MARKDOWN).bind();
```

Finally we start our bot by using `start()` which does not take any parameter and run our bot via **long polling.** 

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
// handles incoming texts
bot.onMessage(filter -> filter.TEXT, (ctx, msg) -> {});

// handles incoming photos
bot.onMessage(filter -> filter.PHOTO, (ctx, msg) -> {});


// handles incoming videos
bot.onMessage(filter -> filter.VIDEO, (ctx, msg) -> {});
```
### Combining filters
You may want to handle `text` and `photo` in one handler or a `text` in different chats. To do so use logical operators 
(&&, ||, !) and combine them together. 

Here are some examples

```java
// handles incoming text in private chat
bot.onMessage(filter -> filter.TEXT && filter.PRIVATE, (ctx, msg) -> {});

// handles an incoming text or photo
bot.onMessage(filter -> filter.TEXT || filter.PHOTO, (ctx, msg) -> {});

// handles incoming text in supergroup chat 
bot.onMessage(filter -> filter.TEXT && filter.SUPERGROUP, (ctx, msg) -> {});

// handles incoming audio or video in private chat
bot.onMessage(filter -> filter.PRIVATE && (filter.AUDIO || filter.VIDEO), (ctx, msg) -> {});

```
### Writing your own filter
You can write your own filter using `filter.customFilter`.

This example will show you how you can write filters using `et.telebof.filters.CustomFilter` and `filter.customFilter`.

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
    Message message = update.getMessage();
    try {
      int number = Integer.parseInt(message.getText());
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
    bot.onMessage(filter -> filter.TEXT && filter.customFilter(new IsNumberFilter()), (ctx, msg) -> {
        ctx.sendMessage("It is number").bind();
    });
  }
}
```

### Advanced Filters

There are some advanced filters for handling incoming `command` from user, `pressing button`(callback data), `inline query`. These are 
`filter.commands`, `filter.callbackData` and `filter.inlineQuery` respectively.

Example for handling commands using `filter.commands`

```java

// handles /start command
bot.onMessage(filter -> filter.commands("start"), (ctx, msg) -> {});

// handles /help command
bot.onMessage(filter -> filter.commands("help"), (ctx, msg) -> {});
```

Example for handling inline button through its callback data using `filter.callbackData`

```java
// handles inline button which its callback data equals with "a"
bot.onCallback(filter -> filter.callbackData("a"), (ctx, cq) -> {
        ctx.answerCallbackQuery("You pressed A button!").bind();
});
```

Example for handling inline query using `filter.inlineQuery`
```java
// handles an inline query which its query equals with a word "hello"
bot.onInline(filter -> filter.inlineQuery("hello"), (ctx, query) -> {});
```

### State Filter
There is another special filter to make conversations with a bot called `state filter`.
```java
bot.onMessage(filter -> filter.commands("start"), (ctx, msg) -> {
    ctx.sendMessage("What is your name?").bind();
    ctx.setState(msg.getFrom().getId(), "name"); // set our state to `name`. You can set whatever
});

bot.onMessage(filter -> filter.state("name") && filter.TEXT, (ctx, msg) -> {
    ctx.sendMessage(String.format("Your name is %s", msg.getText())).bind();
    ctx.clearState(msg.getFrom().getId());
  }
});
```

## Types of Handlers
There are 14 types of handlers to be handled

#### Message Handler

```java
bot.onMessage(filter -> true, (ctx, msg) -> {}); 
```
#### CallbackQuery handler
```java
bot.onCallback(filter -> true, (ctx, cq) -> {});
```
#### Inline Handler
```java
bot.onInline(fileter -> true, (ctx, query) -> {} );
```
#### Poll Handler
```java
bot.onPoll(filter -> true, (ctx, poll) -> {});
```

#### PollAnswer Handler
```java
bot.onPoll(filter -> true, (ctx, pa) -> {});
```
#### Shipping Handler
```java
bot.onShipping(filter -> true, (ctx, shipping) -> {});
```

#### ChannelPost Handler
```java
bot.onChannelPost(filter -> true, (ctx, cp) -> {});
```

#### PreCheckoutQuery Handler
```java
bot.onPreCheckout(filter -> true, (ctx, pcq) -> {});
```

#### EditedMessage Handler
```java
bot.onEditedMessage(filter -> true, (ctx, em) -> {});
```

#### EditedChannelPost Handler
```java
bot.onEditedChannelPost(filter -> true, (ctx, ecp) -> {});
```

#### MyChatMember Handler
```java
bot.onMychatMember(filter -> true, (ctx, mcm) -> {});
```

#### ChatMember Handler
```java
bot.onChatMember(filter -> true, (ctx, cm) -> {});
```

#### ChosenInlineResult Handler
```java
bot.onChosenInlineResult(filter -> true, (ctx, cir) -> {});
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

ctx.sendMssage("Hello, World!").replyMarkup(markup).bind();
```

### InlineKeyboardMarkup
example for using InlineKeyboardMarkup

```java
InlineKeybaordMarkup inlineMarkup = new InlineKeybaordMarkup();

inlineMarkup.addKeybaord(
  new InlineKeybaordButton("A").callbackData("a"), 
  new InlineKeybaordButton("C").callbackData("b"), 
  new InlineKeybaordButton("Url").url("www.example.com")
); // 3 keyboards on a row 

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

## Inline Bot

```java
import et.telebof.BotClient;

public class InlineBot {
  public static void main(String[] args) {
    //...
    
    bot.onInline(filter -> filter.ZERO_INLINE_QUERY, (ctx, query) -> {
      InlineQueryResult result = new InlineQueryResultArticle("123")
              .title("Write something")
              .description("click here")
              .inputMessageContent(new InputMessageContent().messageText("Please write something"));

      ctx.answerInlineQuery(query.getId(), new InlineQueryResult[]{result}).bind();
    });
    
  }
}
```

## Using Webhook
```java
import et.telebof.Webhook;

class MyWebhookBot{
    public static void main(String[] args){
        Webhook webhook = new Webhook("www.example.com", "/bot"); // URL and path respectively
        webhook.certificate(new File(""));
        //...
        bot.setWebhook(webhook); // set webhook

        //... 
        bot.start(); // start our bot using webhook

    }
}
```

## Advanced Usage

### Local Bot API Server

```java
import et.telebof.BotClient;

String url = "https://example.com/bot%s/%s";
BotClient bot = new BotClient.Builder("<TOKEN>")
        .localBotApiUrl(url)
        .build();
```
**You have to log out your bot from the Telegram server before switching to your local API server using `ctx.logOut().bind()`**

### Logging
log current status of the bot.
```java
import et.telebof.BotClient;

BotClient bot = new BotClient.Builder("<TOKEN>")
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
BotClient bot = new BotClient
        .Builder("<TOKEN>")
        .proxy(proxy)
        .build();
```

```java
import et.telebof.BotClient;
import et.telebof.enums.ParseMode;
import et.telebof.enums.Updates;

BotClient bot = new BotClient.Builder("<TOKEN>")
        .log(true) // Log current status
        .skipOldUpdates(false) // Receive updates sent last 24 hours 
        .defaultParseMode(ParseMode.HTML) // Default parse mode applied to all sendXyz methods
        .limit(10) // Limiting how many updates should be received at maximum per request 
        .useTestServer(false) // Using test server
        .timeout(30) // timeout
        .offset(-1) // offset
        .allowedUpdates(new Updates[]{Updates.MESSAGE, Updates.CALLBACK_QUERY}) // Specifying which update should be received 
        .proxy(null) // proxy
        .build(); // build our client
```

## Error Handling

```java

try{     
    ctx.sendMessage("Hello, World").bind();    
} catch(TelegramApiException apiException){
    System.out.println(apiException.getDescription());
}
```