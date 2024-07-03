# <p align="center">Telebo<i>f</i></p>
<p align="center">Easy and modern Java Telegram bot API</p>


## <p align="center">Supported Bot API version: 7.0</p>


## Contents
* [Setup Environment](#installation)
* [Your First Echo Bot](#your-first-echo-bot)
* [Available Types](#available-types) 
* [Available Methods](#available-methods)
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
    <version>1.5.0</version>
</dependecy>

```


### Your First Echo Bot

```java
import et.telebof.BotClient;

public class MyFirstEchoBot {
  static final String TOKEN = "YOUR BOT TOKEN HERE";

  public static void main(String[] args) {
    final BotClient bot = new BotClient(TOKEN);

    // Listening for /start command
    bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
        context.reply("Welcome!").exec();
    });

    // Listening for any text
    bot.onMessage(filter -> filter.TEXT, (context, message) -> {
        context.reply(message.text).exec();
    });

    bot.start(); // finally run the bot
  }
}
```
**Do not worry if you do not understand what the above code mean, it will be explained in the next chapter.** 

## Available Types
All Telegram types are defined in `et.telebof.types`. And they are completely the same as Telegram types.

## Available Methods
All Telegram methods are defined in `et.telebof.request` and implemented in `et.telebof.BotContext` class.

These methods can be used in 2 ways: Inside handler using `context` parameter and Outside handler using `bot.context` instance.

##### Inside handler
No need to pass `chat_id` or `user_id` to the methods need it as argument 

##### Outside handler
`chat_id` or `user_id` must be passed to the methods need it as argument 

```java
/* Inside Handler */

// send message
context.sendMessage("Hello, World").exec(); // or
context.sendMessage(message.chat.id, "Hello, World").exec();

// send Photo
context.sendPhoto(new File("photo.png")).exec(); // or
context.sendPhoto(message.chat.id, new File("photo.png")).exec();


/* Outside Handler */

bot.context.sendMessage(123456789L, "Hello, World").exec();
bot.context.sendPhoto(123456789L, new File("photo.png")).exec();
```
**Assume that in our examples it is inside handler**

## Listening Updates
### Update
Update is an event that bot receives like incoming messages, pressing button.

Updates are handled by [registering one or more callback classes](#types-of-handlers). 

Each update has its own handler. These handlers take two parameters as argument: filter class 
and callback class. The filter class is a lambda class of `et.telebof.filter.FilterExecutor` takes `et.telebof.filter.Filter`
as an argument and returns `Boolean`, so that if the condition of this filter 
matches with the update sent from telegram, the callback class will be called and its body gets execute.

The callback class takes two parameters: `BotContext` class and type of class of an update which is being handled

Let's back to the first `echo bot` example.

```java
import et.telebof.BotClient;

public class MyFirstEchoBot {
  static final String TOKEN = "YOUR BOT TOKEN HERE";

  public static void main(String[] args) {
    final BotClient bot = new BotClient(TOKEN);

    bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
      context.reply("Welcome!").exec();
    });

    bot.onMessage(filter -> filter.TEXT, (context, message) -> {
      context.reply(message.text).exec();
    });

    bot.start();
  }
}
```
We have two handlers: `/start` command handler and `text` handler.

- The first handler handles `/start` command and send back a text `Welcome!`.
- The second handler handles any incoming **text** and echoes the text.
- The `reply` method is a shortage of `sendMessage` and replies message to the `chat_id`.

- `exec()` meaning `execute` is an enclosing and request sender method. This means before ending and sending request, you can pass 
optional parameters and then send a request to telegram. For example `sendMessage` method has optional parameters like: 
`parse_mode`, `reply_markup`. So you can pass their value for these parameters and send request to telegram.

```java
import et.telebof.enums.ParseMode;

context.sendMessage("*Hello, World*").parseMode(ParseMode.MARKDOWN).exec();
```
Lastly we start our bot by using `start()` which does not take any parameter and run our bot via **long polling.** 

**IMPORTANT: All handlers are handled in the order in which they were registered.**

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
- `filter.VIDEO_NOTE` - filter field `message.video_note` is not null
- `filter.CONTACT` - filter field `message.contact` is not null
- `filter.LOCATION` - filter field `message.loaction` is not null
- `filter.GAME` - filter field `message.game` is not null
- `filter.VENUE` - filter field `message.venue` is not null
- `filter.STICKER` - filter field `message.sticker` is not null
- `filter.DICE` - filter field `message.dice` is not null
- `filter.MEDIA` - filter one of filed of media(photo, video, audio) is not null.
- `filter.PASSPORT_DATA` - filter field `message.photo` is not null
- `filter.INVOICE` - filter field `message.invoice` is not null
- `filter.NEW_CHAT_MEMBER` - filter field `message.new_chat_members` is not null
- `filter.LEFT_CHAT_MEMBER` - filter field `message.lef_chat_member` is not null
- `filter.NEW_CHAT_PHOTO` - filter field `message.new_chat_photo` is not null
- `filter.NEW_CHAT_TITLE` - filter field `message.new_chat_title` is not null
- `filter.GROUP_CHAT_CREATED` - filter field `message.group_chat_created` is not null
- `filter.SUPERGROUP_CHAT_CREATED` - filter field `message.supergroup_chat_created` is not null
- `filter.CHANNEL_CHAT_CREATED` - filter field `message.channel_chat_created` is not null
- `filter.MESSAGE_AUTO_DELETE_TIMER_CHANGED` - filter field `message.message_auto_timer_changed` is not null
- `filter.MIGRATED` - filter field `message.migrate_from_chat_id` or `message.migrate_to_chat_id` is not null
- `filter.PINNED_MESSAGE` - filter field `message.pinned_message` is not null
- `filter.SUCCESFULL_PAYMENT` - filter field `message.successfull_payment` is not null
- `filter.CONNNECTED_WEBSITE` - filter field `message.connected_website` is not null
- `filter.PROXIMITY_ALERT_TRIGGERED` - filter field `message.proximity_alert_trigged` is not null
- `filter.FORUM_TOPIC_CREATED` - filter field `message.forum_topic_created` is not null
- `filter.FORUM_TOPIC_CLOSED` - filter field `message.forum_topic_closed` is not null
- `filter.FORUM_TOPIC_EDITED` - filter field `message.forum_topic_edited` is not null
- `filter.FORUM_TOPIC_REOPNED` - filter field `message.forum_topic_reopened` is not null
- `filter.WEB_APP_DATA` - filter field `message.web_pp_data` is not null
- `filter.VIDEO_CHAT_STARTED` - filter field `message.video_chat_started` is not null
- `filter.VIDEO_CHAT_ENDED` - filter field `message.video_ehat_ended` is not null
- `filter.VIDEO_CHAT_PARTICIPANT_INVITED` - filter field `message.video_chat_participant_invited` is not null
- `filter.VIDEO_CHAT_SCHEDULED` - filter field `message.video_chat_scheduled` is not null
- `filter.FORWARDED` - filter field `message.forward_origin` is not null
- `filter.REPLIED` - filter field `message.reply_to_message` is not null
- `filter.BOT` - filter user is bot or filed `message.from.is_bot` is `true`
- `filter.ZERO_INLINE_QUERY` - filter filed `inline_query.query` is empty or has no value
- `filter.PRIVATE` - filter chat type is `private`
- `filter.GROUP` - filter chat type is `group`
- `filter.SUPERGROUP` - filter chat type is `supergroup`
- `filter.CHANNEL` - filter chat type is `channel`
- `filter.commands(String ... cmds)` - filter commands like `/start`, `/help`.
- `filter.callbackData(String ... cds)` - filter of inline buttons or filed `callback_query.data`
- `filter.inlineQuery(String... iqs)` - filter inline query or field `inline_query.query`
- `filter.customFilter()` - filter given filter
- `filter.state(String ... names)` - filter current state.

```java
// handles incoming texts
bot.onMessage(filter -> filter.TEXT, (context, message) -> {});

// handles incoming photos
bot.onMessage(filter -> filter.PHOTO, (context, message) -> {});


// handles incoming videos
bot.onMessage(filter -> filter.VIDEO, (context, message) -> {});
```
### Combining filters
You may want to handle `text` and `photo` in one handler or a `text` in different chats. To do so use logical operators 
(&&, ||, !) and combine them together. 

Here are some examples

```java
// handles incoming text in private chat
bot.onMessage(filter -> filter.TEXT && filter.PRIVATE, (context, message) -> {});

// handles an incoming text or photo
bot.onMessage(filter -> filter.TEXT || filter.PHOTO, (context, message) -> {});

// handles incoming text in supergroup chat 
bot.onMessage(filter -> filter.TEXT && filter.SUPERGROUP, (context, message) -> {});

// handles incoming audio or video in private chat
bot.onMessage(filter -> filter.PRIVATE && (filter.AUDIO || filter.VIDEO), (context, message) -> {});

```
### Writing your own filter
You can write your own filter using `filter.customFilter`.

This example will show you how you can write filters using `et.telebof.filters.CustomFilter` and `filter.customFilter`.

```java
import et.telebof.BotContext;
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

class FilterBot {

  static void numberFilter(BotContext context, Message message){
      context.sendMessage("It is number").exec();
  }

  public static void main(String[] args) {
      // ...
      bot.onMessage(filter -> filter.TEXT && filter.customFilter(new IsNumberFilter()),
              FilterBot::numberFilter);
  }
}
```

### Advanced Filters

There are some advanced filters for handling incoming `command` from user, `pressing button`(callback data), `inline query`. These are 
`filter.commands`, `filter.callbackData` and `filter.inlineQuery` respectively.

Example for handling commands using `filter.commands`

```java
// handles /start command
bot.onMessage(filter -> filter.commands("start"), (context, message) -> {});

// handles /help command
bot.onMessage(filter -> filter.commands("help"), (context, message) -> {});
```

Example for handling inline button through its callback data using `filter.callbackData`

```java
// handles inline button which its callback data equals with "a"
bot.onCallback(filter -> filter.callbackData("a"), (context, callback) -> {
    context.answer("You pressed A button!").exec();
});
```

Example for handling inline query using `filter.inlineQuery`
```java
// handles an inline query which its query equals with a word "hello"
bot.onInline(filter -> filter.inlineQuery("hello"), (context, query) -> {});
```

### State Filter
There is another special filter to make conversations with bot called `state filter`.
```java
bot.onMessage(filter -> filter.commands("start"), (context, message) -> {
    context.sendMessage("What is your name?").exec();
    bot.setState(message.from.id, "name"); // set our state to `name`. You can set whatever
});

bot.onMessage(filter -> filter.state("name") && filter.TEXT, (context, message) -> {     
    context.sendMessage(String.format("Your name is %s", message.text)).exec();
    context.clearState(message.from.id);
});
```

## Types of Handlers
There are 18 types of updates to be handled

#### Message Handler
```java
bot.onMessage((context, message) -> {}); 
```
#### CallbackQuery handler
```java
bot.onCallback((context, callback) -> {});
```
#### InlineQuery Handler
```java
bot.onInline((context, query) -> {} );
```
#### Poll Handler
```java
bot.onPoll((context, poll) -> {});
```
#### PollAnswer Handler
```java
bot.onPoll((context, poll_answer) -> {});
```
#### ShippingQuery Handler
```java
bot.onShipping((context, shipping) -> {});
```
#### ChannelPost Handler
```java
bot.onChannelPost((context, channel_post) -> {});
```
#### PreCheckoutQuery Handler
```java
bot.onPreCheckout((context, pre_checkout) -> {});
```
#### EditedMessage Handler
```java
bot.onEditedMessage((context, edited_message) -> {});
```
#### EditedChannelPost Handler
```java
bot.onEditedChannelPost((context, edited_c) -> {});
```
#### MyChatMember Handler
```java
bot.onMychatMember((context, my_chat) -> {});
```
#### ChatMember Handler
```java
bot.onChatMember((context, chat_member) -> {});
```
#### ChosenInlineResult Handler
```java
bot.onChosenInlineResult((context, chosen) -> {});
```
#### MessageReaction Handler
```java
bot.onReaction((context, reaction) -> {});
```
#### MessageReactionCount Handler
```java
bot.onReactionCount((context, reaction_count) -> {});
```
#### ChatBoost Handler
```java
bot.onChatBoost((context, chat_boost) -> {});
```
#### RemovedChatBoost Handler
```java
bot.onRemovedChatBoost((context, removed_chat_boost) -> {});
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

context.sendMssage("Hello, World!").replyMarkup(markup).exec();
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
);

context.sendMessage("Press one button").replyMarkup(inlineMarkup).exec();
```

### ForceReply
```java
context.sendMessage("Can you tell me your name please?")
        .replyMarkup(new ForceReply())
        .exec();
```

### RemoveReplyKeyboard
```java
context.sendMessage("There is no reply keyboard now")
        .replyMarkup(new RemoveReplyKeybaord())
        .exec(); 
```

## Inline Bot

```java
import et.telebof.types.InlineQueryResult;
import et.telebof.types.InlineQueryResultArticle;
import et.telebof.types.InputTextMessageContent;

public class InlineBot {
  public static void main(String[] args) {
    //...

    bot.onInline(filter -> filter.ZERO_INLINE_QUERY, (context, query) -> {
      InlineQueryResultArticle article = new InlineQueryResultArticle("1")
              .title("Write something")
              .description("click here")
              .inputTextMessageContent(new InputTextMessageContent("Please write something"));

      context.answerInline(new InlineQueryResult[]{article}).exec();
    });

  }
}
```

## Using Webhook

```java
import et.telebof.Webhook;
import java.io.File;

class MyWebhookBot {
  public static void main(String[] args) {
    Webhook webhook = new Webhook("www.example.com", "/bot");  // URL and path respectively
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
BotClient bot = new BotClient.Builder(TOKEN)
        .localBotApiUrl(url)
        .build();
```
**You have to log out your bot from the Telegram server before switching to your local API server using `bot.context.logOut().exec()`**

### Logging
log current status of the bot.
```java
import et.telebof.BotClient;

BotClient bot = new BotClient.Builder(TOKEN)
        .log(true)
        .build();
```

### Proxy

```java
import et.telebof.BotClient;

import java.net.InetSocketAddress;
import java.net.Proxy;

InetSocketAddress address = new InetSocketAddress(80, "127.97.91"); // port and hostname respectively 

Proxy proxy = new Proxy(Proxy.Type.SOCKS, address);
BotClient bot = new BotClient
        .Builder(TOKEN)
        .proxy(proxy)
        .build();
```

```java
import et.telebof.BotClient;
import et.telebof.enums.ParseMode;
import et.telebof.enums.Updates;

BotClient bot = new BotClient.Builder(TOKEN)
        .log(true) // Log current status
        .skipOldUpdates(false) // Receive updates sent last 24 hours 
        .parseMode(ParseMode.HTML) // Default parse mode passed to sendXyz methods
        .limit(10) // Limiting how many updates should be received at maximum per request 
        .useTestServer(false) // Using test server
        .timeout(30) // timeout
        .offset(-1) // offset
        .allowedUpdates(Updates.ALL) // Allowed updates
        .proxy(null) // proxy
        .build(); // build our client
```

## Error Handling

```java
import et.telebof.TelegramApiException;

try{     
    context.sendMessage("Hello, World").exec();    
} catch(TelegramApiException apiException){
    System.out.println(apiException.description);
}
```