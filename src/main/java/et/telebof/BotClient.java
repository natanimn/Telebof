package et.telebof;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import et.telebof.enums.ChatAction;
import et.telebof.errors.ConnectionError;
import et.telebof.errors.TelegramError;
import et.telebof.enums.ParseMode;
import et.telebof.enums.Updates;
import et.telebof.handlers.*;
import et.telebof.requests.*;
import et.telebof.states.StateMemoryStorage;
import et.telebof.types.BotCommand;
import et.telebof.types.ChatPermission;
import et.telebof.types.InlineQueryResult;
import et.telebof.types.InputMedia;
import et.telebof.types.InputSticker;
import et.telebof.types.LabeledPrice;
import et.telebof.types.MaskPosition;
import et.telebof.types.Message;
import et.telebof.types.PassportElementError;
import et.telebof.types.Update;
import et.telebof.types.User;
import et.telebof.types.WebhookInfo;
import et.telebof.filters.Filter;
import et.telebof.filters.FilterExecutor;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

/**<h1>BotClient</h1>
 * @apiNote The main class of the library for interacting with telegram.
 *
 * <p>Using this class you can do: create Handlers, send message, delete webhook and other actions bot can do.
 @author Natanim Negash
 @version 1.3.0
 */


@SuppressWarnings("unused")
final public class BotClient {
    private Integer offset;
    private Webhook webhook;
    private final AtomicBoolean stopPolling = new AtomicBoolean(false);
    private final ParseMode parseMode;
    private boolean skipOldUpdates;
    private final RequestSender requestSender;
    private final ConcurrentLinkedQueue<Update> updatesQueue = new ConcurrentLinkedQueue<>();
    private final LinkedHashMap<FilterExecutor, MessageHandler> messageHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, CallbackHandler> callbackQueryHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, InlineHandler> inlineQueryHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, ChannelPostHandler> channelPostHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, MyChatMemberHandler> myChatMemberHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, EditedMessageHandler> editedMessages = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, PollHandler> pollHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, PollAnswerHandler> pollAnswerHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, ChatMemberHandler> chatMemberHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, ChatJoinRequestHandler> chatJoinRequestHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, PreCheckoutHandler> preCheckoutHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, EditedChannelPostHandler> editedChannelPostHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, ChosenInlineResultHandler> chosenInlineResultHandlers = new LinkedHashMap<>();
    private final LinkedHashMap<FilterExecutor, ShippingHandler> shippingHandlers = new LinkedHashMap<>();
    private Filter filter;
    private final GetUpdates getUpdates;
    private User bot;
    private final StateMemoryStorage storage;
    private Update update;
    private FilterExecutor filterExecutor;

    /**
     * @param botToken obtained from <a href="https://t.me/botfather">BotFather</a>
     *
     * @param parseMode default parseMode
     */
    private BotClient(String botToken, boolean log, boolean skipOldUpdates, int limit, Integer offset,
                      int timeout, Updates[] allowedUpdates, ParseMode parseMode, Proxy proxy, String localBotApiUrl,
                      boolean useTestServer) {
        this.skipOldUpdates = skipOldUpdates;
        this.parseMode = parseMode;
        
        this.requestSender = new RequestSender(botToken, useTestServer, proxy, localBotApiUrl);
        this.offset = offset;
        this.getUpdates = new GetUpdates(requestSender)
                    .allowedUpdates(allowedUpdates)
                    .limit(limit)
                    .timeout(timeout);
        this.storage = new StateMemoryStorage();
        this.update = null;

        if (log) BotLog.logger.setLevel(Level.FINE);
        else BotLog.logger.setLevel(Level.OFF);

        BotLog.info("BotClient initialized");
    }

    public BotClient(String botToken){
        this(botToken, false, true, 100, null, 20, null, null, null, null, false);
    }

    public static class Builder {
        /**
         * A builder of <b>BotClient</b> class.
         * Through this class, you create a new object of <b>BotClient</b> class.
         * @apiNote This class is builder of the main class.
         *
         */

        private final String botToken;
        private ParseMode parseMode;
        private String localBotApiUrl;
        private boolean skipOldUpdates;
        private Proxy proxy;
        private boolean log;
        private int limit;
        private Integer offset;
        private int timeout;
        private Updates[] allowedUpdates;
        private boolean useTestServer;
        public Builder(String botToken){
            this.botToken = botToken;
            this.timeout = 20;
            this.localBotApiUrl = null;
            this.skipOldUpdates = true;
            this.log = false;
            this.limit = 100;
            this.allowedUpdates = null;
            this.offset = null;
            this.parseMode = null;
            this.proxy = null;
            this.useTestServer = false;
        }


        public Builder defaultParseMode(ParseMode parseMode){
            this.parseMode = parseMode;
            return this;
        }

        public Builder localBotApiUrl(String localBotApiUrl){
            this.localBotApiUrl = localBotApiUrl;
            return this;
        }

        public Builder skipOldUpdates(boolean skip){
            this.skipOldUpdates = skip;
            return this;
        }


        public Builder proxy(Proxy proxy){
            this.proxy = proxy;
            return this;
        }

        public Builder log(boolean log){
            this.log = log;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder allowedUpdates(Updates[] allowedUpdates) {
            this.allowedUpdates = allowedUpdates;
            return this;
        }

        public Builder useTestServer(boolean useTestServer){
            this.useTestServer = useTestServer;
            return this;
        }

        public BotClient build(){
            return new BotClient(botToken, log, skipOldUpdates, limit, offset, timeout, allowedUpdates,
                    parseMode, proxy, localBotApiUrl, useTestServer);
        }

    }

    public void onMessage(FilterExecutor filterExecutor, MessageHandler messageHandler){
        messageHandlers.put(filterExecutor, messageHandler);
    }

    public void onCallback(FilterExecutor filterExecutor, CallbackHandler callbackHandler){
        callbackQueryHandlers.put(filterExecutor, callbackHandler);
    }

    public void onInline(FilterExecutor filterExecutor, InlineHandler inlineHandler){
        inlineQueryHandlers.put(filterExecutor, inlineHandler);
    }

    public void onPoll(FilterExecutor filterExecutor, PollHandler pollHandler){
        pollHandlers.put(filterExecutor, pollHandler);
    }

    public void onMyChatMember(FilterExecutor filterExecutor, MyChatMemberHandler myChatMemberHandler){
        myChatMemberHandlers.put(filterExecutor, myChatMemberHandler);
    }

    public void onPollAnswer(FilterExecutor filterExecutor, PollAnswerHandler pollAnswerHandler){
        pollAnswerHandlers.put(filterExecutor, pollAnswerHandler);
    }

    public void onPreCheckout(FilterExecutor filterExecutor, PreCheckoutHandler preCheckoutHandler){
        preCheckoutHandlers.put(filterExecutor, preCheckoutHandler);
    }

    public void onChatMember(FilterExecutor filterExecutor, ChatMemberHandler chatMemberHandler){
        chatMemberHandlers.put(filterExecutor, chatMemberHandler);
    }

    public void onEditedMessage(FilterExecutor filterExecutor, EditedMessageHandler editedMessageHandler){
        editedMessages.put(filterExecutor, editedMessageHandler);
    }

    public void onChannelPost(FilterExecutor filterExecutor, ChannelPostHandler channelPostHandler){
        channelPostHandlers.put(filterExecutor, channelPostHandler);
    }

    public void onEditedChannelPost(FilterExecutor filterExecutor, EditedChannelPostHandler editedChannelPostHandler) {
        editedChannelPostHandlers.put(filterExecutor, editedChannelPostHandler);
    }

    public void onChatJoinRequest(FilterExecutor filterExecutor, ChatJoinRequestHandler chatJoinRequestHandler){
        chatJoinRequestHandlers.put(filterExecutor, chatJoinRequestHandler);
    }

    public void onChosenInlineResult(FilterExecutor filterExecutor, ChosenInlineResultHandler chosenInlineResult){
        chosenInlineResultHandlers.put(filterExecutor, chosenInlineResult);
    }

    public void onShipping(FilterExecutor filterExecutor, ShippingHandler shippingHandler){
        shippingHandlers.put(filterExecutor, shippingHandler);
    }

    /**
     * <p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever
     * there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a
     * JSON-serialized Update. In case of an unsuccessful request, we will give up after a reasonable</p>
     *
     * <p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the
     * parameter secretToken. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token”
     * with the secret token as content.</p>
     * @apiNote <p> 1. You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.</p>
     * <p>2. To use a self-signed certificate, you need to upload your public key certificate using
     * certificate parameter. Please upload as InputFile, sending a String will not work.</p>
     * <p>3. Ports currently supported for webhooks: 443, 80, 88, 8443.</p>
     * If you're having any trouble setting up webhooks, please check out this <a href="https://core.telegram.org/bots/webhooks">amazing guide to  webhooks.</a>
     * @param webhook holds parameters for webhook.
     * @see <a href="https://core.telegram.org/bots/api#setwebhook">Telegram Documetation</a>
     */
    public void setWebhook(Webhook webhook){
        this.webhook = webhook;
    }

    public WebhookInfo getWebhookInfo(){
        return new GetWebhookInfo(requestSender).exec();
    }

    /**
     * Use this method to remove webhook integration if you decide to back getUpdates.
     *
     * @see <a href="https://core.telegram.org/bots/api#deletewebhook">Delete Webhook</a>
     */

    public void deleteWebhook(){
        new DeleteWebhook(requestSender).exec();
    }


    @SuppressWarnings("unchecked")
    private void processWebhook(){
        try {
            String path = webhook.getPath();
            HttpServer server = HttpServer.create(new InetSocketAddress(webhook.getPort()), 0);
            server.createContext(path, httpExchange -> {
                if (httpExchange.getRequestMethod().equals("POST")){
                    String response = getString(httpExchange);
                    ApiResponse apiResponse = Util.parseApiResponse(response);
                    List<Object> objects = Util.parse(apiResponse.result, List.class);
                    List<Update> updates = Util.parseList(objects, Update.class);
                    httpExchange.sendResponseHeaders(200, response.length());
                    OutputStream outputStream = httpExchange.getResponseBody();
                    outputStream.write("!".getBytes());
                    outputStream.close();
                    updates.forEach(this::notifyUpdate);
                }
            });

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static String getString(HttpExchange httpExchange) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(httpExchange.getRequestBody(), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder requestBody = new StringBuilder();

        while(bufferedReader.readLine() != null){
            requestBody.append(bufferedReader.readLine());
        }

        bufferedReader.close();
        return requestBody.toString();
    }


    private void retrieveUpdates(){
        if (skipOldUpdates) {
            getUpdates.offset(-1).exec();
            skipOldUpdates = false;
        }

        List<Update> updates = getUpdates.offset(offset).exec();
        int count = updates.size();
        BotLog.info(String.format("Received %d updates", count));
        if (!updates.isEmpty()) {
            updatesQueue.addAll(updates);
            this.offset = updates.get(count - 1).update_id + 1;
        }
    }

    public void stop(){
        stopPolling.set(false);
    }

     /** This method notifies each of arrived updates.
     *
     * @param update Update class
     */
    public void notifyUpdate(Update update){
        this.update = update;
        this.filter = new Filter(update, storage);
        if (update.message != null) processMessages(update);
        else if (update.callback_query != null) processCallbackQuery(update);
        else if (update.inline_query != null) processInlineQuery(update);
        else if (update.channel_post != null) processChannelPost(update);
        else if (update.my_chat_member != null) processMyChatMember(update);
        else if (update.edited_message != null) processEditedMessages(update);
        else if (update.edited_channel_post != null) processEditedChannelPost(update);
        else if (update.poll != null) processPoll(update);
        else if (update.chat_member != null) processChatMember(update);
        else if (update.pre_checkout_query != null) processPreCheckoutQuery(update);
        else if (update.shipping_query != null) processShippingQuery(update);
        else if (update.chat_join_request != null) processChatJoinRequest(update);
        else if (update.chosen_inline_result != null) processChosenInlineResult(update);
        else if (update.poll_answer != null) processPollAnswer(update);
    }

    private void processMessages(Update update) {
        for (Map.Entry<FilterExecutor, MessageHandler> entry: messageHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            MessageHandler messageHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                messageHandler.handle(update.message);
                break;
            }
        }
    }

    private void processEditedMessages(Update update) {

        for (Map.Entry<FilterExecutor, EditedMessageHandler> entry: editedMessages.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            EditedMessageHandler editedMessageHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                editedMessageHandler.handle(update.edited_message);
                break;
            }
        }
    }

    private void processChannelPost(Update update) {
        for (Map.Entry<FilterExecutor, ChannelPostHandler> entry: channelPostHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            ChannelPostHandler channelPostHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                channelPostHandler.handle(update.channel_post);
                break;
            }
        }
    }

    private void processEditedChannelPost(Update update) {
        for (Map.Entry<FilterExecutor, EditedChannelPostHandler> entry: editedChannelPostHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            EditedChannelPostHandler editedChannelPostHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                editedChannelPostHandler.handle(update.edited_channel_post);
                break;
            }
        }
    }

    private void processInlineQuery(Update update) {
        for (Map.Entry<FilterExecutor, InlineHandler> entry: inlineQueryHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            InlineHandler inlineHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                inlineHandler.handle(update.inline_query);
                break;
            }
        }
    }

    private void processCallbackQuery(Update update) {
        for (Map.Entry<FilterExecutor, CallbackHandler> entry: callbackQueryHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            CallbackHandler callbackHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                callbackHandler.handle(update.callback_query);
                break;
            }
        }
    }

    private void processChosenInlineResult(Update update) {
        for (Map.Entry<FilterExecutor, ChosenInlineResultHandler> entry: chosenInlineResultHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            ChosenInlineResultHandler chosenInlineResultHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                chosenInlineResultHandler.handle(update.chosen_inline_result);
                break;
            }
        }
    }

    private void processShippingQuery(Update update) {
        for (Map.Entry<FilterExecutor, ShippingHandler> entry: shippingHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            ShippingHandler shippingHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                shippingHandler.handle(update.shipping_query);
                break;
            }
        }
    }

    private void processPreCheckoutQuery(Update update) {
        for (Map.Entry<FilterExecutor, PreCheckoutHandler> entry: preCheckoutHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            PreCheckoutHandler preCheckoutHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                preCheckoutHandler.handle(update.pre_checkout_query);
                break;
            }
        }
    }

    private void processPoll(Update update){
        for (Map.Entry<FilterExecutor, PollHandler> entry: pollHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            PollHandler pollHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                pollHandler.handle(update.poll);
                break;
            }
        }
    }

    private void processPollAnswer(Update update) {
        for (Map.Entry<FilterExecutor, PollAnswerHandler> entry: pollAnswerHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            PollAnswerHandler pollAnswerHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                pollAnswerHandler.handle(update.poll_answer);
                break;
            }
        }
    }

    private void processMyChatMember(Update update) {
        for (Map.Entry<FilterExecutor, MyChatMemberHandler> entry: myChatMemberHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            MyChatMemberHandler myChatMemberHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                myChatMemberHandler.handle(update.my_chat_member);
                break;
            }
        }
    }

    private void processChatMember(Update update) {
        for (Map.Entry<FilterExecutor, ChatMemberHandler> entry: chatMemberHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            ChatMemberHandler chatMemberHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                chatMemberHandler.handle(update.chat_member);
                break;
            }
        }
    }

    private void processChatJoinRequest(Update update) {
        for (Map.Entry<FilterExecutor, ChatJoinRequestHandler> entry: chatJoinRequestHandlers.entrySet()){
            FilterExecutor filterExecutor = entry.getKey();
            ChatJoinRequestHandler chatJoinRequestHandler = entry.getValue();
            boolean executed = filterExecutor.execute(filter);
            if (executed){
                chatJoinRequestHandler.handle(update.chat_join_request);
                break;
            }
        }
    }

    private void startPolling(){

        while (!stopPolling.get()){
            try{
                retrieveUpdates();
                if (!updatesQueue.isEmpty()) updatesQueue.forEach(this::notifyUpdate);
            } catch (TelegramError var1) {
                throw var1;
            } catch (TelegramApiException apiException){
                if (apiException.parameters !=null){
                    int delay = ((Double) (apiException.parameters.get("retry_after"))).intValue();
                    BotLog.error(String.format("Waiting for %d seconds", delay));
                    if (BotLog.logger.getLevel() == Level.OFF)
                        apiException.printStackTrace();
                    else BotLog.error(apiException.description);
                    BotClient.this.sleep(delay);
                } else {
                    if (BotLog.logger.getLevel() == Level.OFF)
                        apiException.printStackTrace();
                    else BotLog.error(apiException.description);
                }
            } catch (ConnectionError connectionError){
                if (BotLog.logger.getLevel() == Level.OFF)
                    connectionError.printStackTrace();
                else BotLog.error(connectionError.getMessage());
                BotClient.this.sleep(3);
            } catch (RuntimeException exception) {
                if (BotLog.logger.getLevel() == Level.OFF)
                    exception.printStackTrace();
                else BotLog.error(exception.getMessage());

            } finally {
                updatesQueue.clear();
            }
        }
       BotLog.info("Polling stopped");
    }


    private void sleep(int seconds){
        try{
            Thread.sleep(1000L * seconds);
        } catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }

    public void start(){
        if (webhook != null){
            BotLog.info("Bot started running via webhook");
            deleteWebhook();
            setWebhook(webhook);
            processWebhook();
        } else {
            BotLog.info("Bot started running via longPolling");
            deleteWebhook();
            startPolling();
        }
    }

    /* Telegram Methods */

    public GetMe getMe() {
        return new GetMe(this.requestSender);
    }

    public LogOut logOut() {
        return new LogOut(this.requestSender);
    }

    public Close close() {
        return new Close(this.requestSender);
    }

    public SendMessage sendMessage(Object chatId, String text) {
        return new SendMessage(chatId, text, this.requestSender).parseMode(parseMode);
    }

    public SendMessage sendMessage(String text) {
        return new SendMessage(getChatId(), text, this.requestSender).parseMode(parseMode);
    }

    public byte[] downloadFile(String filePath) {
        return requestSender.downloadFile(filePath);
    }

    public SendMessage reply(String text) {
        return new SendMessage(getChatId(), text, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public ForwardMessage forwardMessage(Object chatId, Object fromChatId, int messageId) {
        return new ForwardMessage(chatId, fromChatId, messageId, this.requestSender);
    }

    public ForwardMessage forwardMessage(Object toChatId, int messageId) {
        return new ForwardMessage(toChatId, getChatId(), messageId, this.requestSender);
    }

    public CopyMessage copyMessage(Object chatId, Object fromChatId, int messageId) {
        return new CopyMessage(chatId, fromChatId, messageId, this.requestSender).parseMode(parseMode);
    }

    public SendPhoto sendPhoto(Object chatId, String photo) {
        return new SendPhoto(chatId, photo, this.requestSender).parseMode(parseMode);
    }

    public SendPhoto sendPhoto(String photo) {
        return new SendPhoto(getChatId(), photo, this.requestSender).parseMode(parseMode);
    }

    public SendPhoto sendPhoto(File photo) {
        return new SendPhoto(getChatId(), photo, this.requestSender).parseMode(parseMode);
    }

    public SendPhoto replyPhoto(String photo) {
        return new SendPhoto(getChatId(), photo, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendPhoto sendPhoto(Object chatId, File photo) {
        return new SendPhoto(chatId, photo, this.requestSender).parseMode(parseMode);
    }

    public SendPhoto replyPhoto(File photo) {
        return new SendPhoto(getChatId(), photo, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendPhoto replyPhoto(Message message, String photo) {
        return new SendPhoto(message.chat.id, photo, this.requestSender).replyToMessageId(message.message_id).parseMode(parseMode);
    }

    public SendPhoto replyPhoto(Message message, File photo) {
        return new SendPhoto(message.chat.id, photo, this.requestSender).replyToMessageId(message.message_id).parseMode(parseMode);
    }

    public SendAudio sendAudio(Object chatId, String audio) {
        return new SendAudio(chatId, audio, this.requestSender).parseMode(parseMode);
    }

    public SendAudio sendAudio(String audio) {
        return new SendAudio(getChatId(), audio, this.requestSender).parseMode(parseMode);
    }

    public SendAudio sendAudio(Object chatId, File audio) {
        return new SendAudio(chatId, audio, this.requestSender).parseMode(parseMode);
    }

    public SendAudio sendAudio(File audio) {
        return new SendAudio(getChatId(), audio, this.requestSender).parseMode(parseMode);
    }

    public SendAudio replyAudio(Message message, String audio) {
        return new SendAudio(message, audio, this.requestSender).replyToMessageId(message.message_id).parseMode(parseMode);
    }

    public SendAudio replyAudio(Message message, File audio) {
        return new SendAudio(message, audio, this.requestSender).messageThreadId(message.message_id).parseMode(parseMode);
    }

    public SendDocument sendDocument(Object chatId, String document) {
        return new SendDocument(chatId, document, this.requestSender).parseMode(parseMode);
    }

    public SendDocument sendDocument(String document) {
        return new SendDocument(getChatId(), document, this.requestSender).parseMode(parseMode);
    }

    public SendDocument sendDocument(Object chatId, File document) {
        return new SendDocument(chatId, document, this.requestSender).parseMode(parseMode);
    }

    public SendDocument sendDocument(File document) {
        return new SendDocument(getChatId(), document, this.requestSender).parseMode(parseMode);
    }

    public SendDocument replyDocument(String document) {
        return new SendDocument(getChatId(), document, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendDocument replyDocument(File document) {
        return new SendDocument(getChatId(), document, this.requestSender).parseMode(parseMode);
    }

    public SendVideo sendVideo(Object chatId, String video) {
        return new SendVideo(chatId, video, this.requestSender).parseMode(parseMode);
    }

    public SendVideo sendVideo(String video) {
        return new SendVideo(getChatId(), video, this.requestSender).parseMode(parseMode);
    }

    public SendVideo sendVideo(Object chatId, File video) {
        return new SendVideo(chatId, video, this.requestSender).parseMode(parseMode);
    }

    public SendVideo sendVideo(File video) {
        return new SendVideo(getChatId(), video, this.requestSender).parseMode(parseMode);
    }

    public SendVideo replyVideo(String video) {
        return new SendVideo(getChatId(), video, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendVideo replyVideo(File video) {
        return new SendVideo(getChatId(), video, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendAnimation sendAnimation(Object chatId, String animation) {
        return new SendAnimation(chatId, animation, this.requestSender).parseMode(parseMode);
    }

    public SendAnimation sendAnimation(String animation) {
        return new SendAnimation(getChatId(), animation, this.requestSender).parseMode(parseMode);
    }

    public SendAnimation sendAnimation(Object chatId, File animation) {
        return new SendAnimation(chatId, animation, this.requestSender).parseMode(parseMode);
    }

    public SendAnimation sendAnimation(File animation) {
        return new SendAnimation(getChatId(), animation, this.requestSender).parseMode(parseMode);
    }

    public SendAnimation replyAnimation(String animation) {
        return new SendAnimation(getChatId(), animation, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendAnimation replyAnimation(File animation) {
        return new SendAnimation(getChatId(), animation, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendVoice sendVoice(Object chatId, String voice) {
        return new SendVoice(chatId, voice, this.requestSender).parseMode(parseMode);
    }

    public SendVoice sendVoice(String voice) {
        return new SendVoice(getChatId(), voice, this.requestSender).parseMode(parseMode);
    }

    public SendVoice sendVoice(Object chatId, File voice) {
        return new SendVoice(chatId, voice, this.requestSender).parseMode(parseMode);
    }

    public SendVoice sendVoice(File voice) {
        return new SendVoice(getChatId(), voice, this.requestSender).parseMode(parseMode);
    }

    public SendVoice replyVoice(String voice) {
        return new SendVoice(getChatId(), voice, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendVoice replyVoice(File voice) {
        return new SendVoice(getChatId(), voice, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendVideoNote sendVideoNote(Object chatId, String video_note) {
        return new SendVideoNote(chatId, video_note, this.requestSender).parseMode(parseMode);
    }

    public SendVideoNote sendVideoNote(Object chatId, File video_note) {
        return new SendVideoNote(chatId, video_note, this.requestSender).parseMode(parseMode);
    }

    public SendVideoNote replyVideoNote(String videoNote) {
        return new SendVideoNote(getChatId(), videoNote, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendVideoNote replyVideoNote(File videoNote) {
        return new SendVideoNote(getChatId(), videoNote, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public <T extends InputMedia> SendMediaGroup sendMediaGroup(Object chatId, T[] medias) {
        return new SendMediaGroup(chatId, medias, this.requestSender).parseMode(parseMode);
    }

    public <T extends InputMedia> SendMediaGroup sendMediaGroup(T[] medias) {
        return new SendMediaGroup(getChatId(), medias, this.requestSender).parseMode(parseMode);
    }

    public <T extends InputMedia> SendMediaGroup replyMediaGroup(T[] medias) {
        return new SendMediaGroup(getChatId(), medias, this.requestSender).replyToMessageId(getMessageId()).parseMode(parseMode);
    }

    public SendLocation sendLocation(Object chatId, float latitude, float longitude) {
        return new SendLocation(chatId, latitude, longitude, this.requestSender);
    }

    public SendLocation sendLocation(float latitude, float longitude) {
        return new SendLocation(getChatId(), latitude, longitude, this.requestSender);
    }

    public SendLocation replyLocation(float latitude, float longitude) {
        return new SendLocation(getChatId(), latitude, longitude, this.requestSender).replyToMessageId(getMessageId());
    }

    public EditMessageLiveLocation editMessageLiveLocation(Object chatId, float latitude, float longitude, int messageId) {
        return new EditMessageLiveLocation(chatId, latitude, longitude, messageId, this.requestSender);
    }

    public EditMessageLiveLocation editMessageLiveLocation(float latitude, float longitude, int messageId) {
        return new EditMessageLiveLocation(getChatId(), latitude, longitude, messageId, this.requestSender);
    }

    public EditMessageLiveLocation editMessageLiveLocation(String inlineMessageId, float latitude, float longitude) {
        return new EditMessageLiveLocation(inlineMessageId, latitude, longitude, this.requestSender);
    }

    public StopMessageLiveLocation stopMessageLiveLocation(Object chatId, int messageId) {
        return new StopMessageLiveLocation(chatId, messageId, this.requestSender);
    }

    public StopMessageLiveLocation stopMessageLiveLocation(int messageId) {
        return new StopMessageLiveLocation(getChatId(), messageId, this.requestSender);
    }

    public StopMessageLiveLocation stopMessageLiveLocation() {
        return new StopMessageLiveLocation(getChatId(), getMessageId(), this.requestSender);
    }

    public StopMessageLiveLocation stopMessageLiveLocation(String inlineMessageId) {
        return new StopMessageLiveLocation(inlineMessageId, this.requestSender);
    }

    public SendVenue sendVenue(Object chatId, float latitude, float longitude, String title, String address) {
        return new SendVenue(chatId, latitude, longitude, title, address, this.requestSender);
    }

    public SendVenue sendVenue(float latitude, float longitude, String title, String address) {
        return new SendVenue(getChatId(), latitude, longitude, title, address, this.requestSender);
    }

    public SendVenue replyVenue(float latitude, float longitude, String title, String address) {
        return new SendVenue(getChatId(), latitude, longitude, title, address, this.requestSender).replyToMessageId(getMessageId());
    }

    public SendContact sendContact(Object chatId, String phoneNumber, String firstName) {
        return new SendContact(chatId, phoneNumber, firstName, this.requestSender);
    }

    public SendContact sendContact(String phoneNumber, String firstName) {
        return new SendContact(getChatId(), phoneNumber, firstName, this.requestSender);
    }

    public SendContact replyContact(String phoneNumber, String firstName) {
        return new SendContact(getChatId(), phoneNumber, firstName, this.requestSender).replyToMessageId(getMessageId());
    }

    public SendPoll sendPoll(Object chatId, String question, String[] options) {
        return new SendPoll(chatId, question, options, this.requestSender);
    }

    public SendPoll sendPoll(String question, String[] options) {
        return new SendPoll(getChatId(), question, options, this.requestSender);
    }

    public SendPoll sendPoll(String question, List<String> options) {
        return new SendPoll(getChatId(), question, options.toArray(new String[0]), this.requestSender);
    }
    public SendPoll replyPoll(String question, String[] options) {
        return new SendPoll(getChatId(), question, options, this.requestSender).replyToMessageId(getMessageId());
    }

    public SendDice sendDice(Object chatId) {
        return new SendDice(chatId, this.requestSender);
    }

    public SendDice sendDice() {
        return new SendDice(getChatId(), this.requestSender);
    }

    public SendDice replyDice() {
        return new SendDice(getChatId(), this.requestSender).replyToMessageId(getMessageId());
    }

    public SendChatAction sendChatAction(Object chatId, ChatAction chatAction) {
        return new SendChatAction(chatId, chatAction, this.requestSender);
    }

    public SendChatAction sendChatAction(ChatAction chatAction) {
        return new SendChatAction(getChatId(), chatAction, this.requestSender);
    }

    public GetUserProfilePhotos getUserProfilePhotos(long userId) {
        return new GetUserProfilePhotos(userId, this.requestSender);
    }

    public GetFile getFile(String fileId) {
        return new GetFile(fileId, this.requestSender);
    }

    public BanChatMember banChatMember(Object chatId, long userId) {
        return new BanChatMember(chatId, userId, this.requestSender);
    }

    public BanChatMember banChatMember(long userId) {
        return new BanChatMember(getChatId(), userId, this.requestSender);
    }

    public UnbanChatMember unbanChatMember(Object chatId, long userId) {
        return new UnbanChatMember(chatId, userId, this.requestSender);
    }

    public UnbanChatMember unbanChatMember(long userId) {
        return new UnbanChatMember(getChatId(), userId, this.requestSender);
    }

    public RestrictChatMember restrictChatMember(Object chatId, ChatPermission permissions, long userId) {
        return new RestrictChatMember(chatId, userId, permissions, this.requestSender);
    }

    public RestrictChatMember restrictChatMember(ChatPermission permissions, long userId) {
        return new RestrictChatMember(getChatId(), userId, permissions, this.requestSender);
    }

    public PromoteChatMember promoteChatMember(Object chatId, long userId) {
        return new PromoteChatMember(chatId, userId, this.requestSender);
    }

    public PromoteChatMember promoteChatMember(long userId) {
        return new PromoteChatMember(getChatId(), userId, this.requestSender);
    }

    public SetChatAdministratorCustomTitle setChatAdministratorCustomTitle(Object chatId, long userId, String customTitle) {
        return new SetChatAdministratorCustomTitle(chatId, userId, customTitle, this.requestSender);
    }

    public SetChatAdministratorCustomTitle setChatAdministratorCustomTitle(long userId, String customTitle) {
        return new SetChatAdministratorCustomTitle(getChatId(), userId, customTitle, this.requestSender);
    }

    public BanChatSenderChat banChatSenderChat(Object chatId, long senderChatId) {
        return new BanChatSenderChat(chatId, senderChatId, this.requestSender);
    }

    public BanChatSenderChat banChatSenderChat(long senderChatId) {
        return new BanChatSenderChat(getChatId(), senderChatId, this.requestSender);
    }

    public SetChatPermissions setChatPermissions(Object chatId, ChatPermission permissions) {
        return new SetChatPermissions(chatId, permissions, this.requestSender);
    }

    public SetChatPermissions setChatPermissions(ChatPermission permissions) {
        return new SetChatPermissions(getChatId(), permissions, this.requestSender);
    }

    public ExportChatInviteLink exportChatInviteLink(Object chatId) {
        return new ExportChatInviteLink(chatId, this.requestSender);
    }

    public ExportChatInviteLink exportChatInviteLink() {
        return new ExportChatInviteLink(getChatId(), this.requestSender);
    }

    public CreateChatInviteLink createChatInviteLink(Object chatId) {
        return new CreateChatInviteLink(chatId, this.requestSender);
    }

    public CreateChatInviteLink createChatInviteLink() {
        return new CreateChatInviteLink(getChatId(), this.requestSender);
    }

    public EditChatInviteLink editChatInviteLink(Object chatId, String inviteLink) {
        return new EditChatInviteLink(chatId, inviteLink, this.requestSender);
    }

    public EditChatInviteLink editChatInviteLink(String inviteLink) {
        return new EditChatInviteLink(getChatId(), inviteLink, this.requestSender);
    }

    public RevokeChatInviteLink revokeChatInviteLink(Object chatId, String inviteLink) {
        return new RevokeChatInviteLink(chatId, inviteLink, this.requestSender);
    }

    public RevokeChatInviteLink revokeChatInviteLink(String inviteLink) {
        return new RevokeChatInviteLink(getChatId(), inviteLink, this.requestSender);
    }

    public ApproveChatJoinRequest approveChatJoinRequest(Object chatId, long userId) {
        return new ApproveChatJoinRequest(chatId, userId, this.requestSender);
    }

    public ApproveChatJoinRequest approveChatJoinRequest(long userId) {
        return new ApproveChatJoinRequest(getChatId(), userId, this.requestSender);
    }

    public DeclineChatJoinRequest declineChatJoinRequest(Object chatId, long userId) {
        return new DeclineChatJoinRequest(chatId, userId, this.requestSender);
    }

    public DeclineChatJoinRequest declineChatJoinRequest(long userId) {
        return new DeclineChatJoinRequest(getChatId(), userId, this.requestSender);
    }

    public SetChatPhoto setChatPhoto(Object chatId, File photo) {
        return new SetChatPhoto(chatId, photo, this.requestSender);
    }

    public SetChatPhoto setChatPhoto(File photo) {
        return new SetChatPhoto(getChatId(), photo, this.requestSender);
    }

    public DeleteChatPhoto deleteChatPhoto(Object chatId) {
        return new DeleteChatPhoto(chatId, this.requestSender);
    }

    public DeleteChatPhoto deleteChatPhoto() {
        return new DeleteChatPhoto(getChatId(), this.requestSender);
    }

    public SetChatTitle setChatTitle(Object chatId, String title) {
        return new SetChatTitle(chatId, title, this.requestSender);
    }

    public SetChatTitle setChatTitle(String title) {
        return new SetChatTitle(getChatId(), title, this.requestSender);
    }

    public SetChatDescription setChatDescription(Object chatId, String description) {
        return new SetChatDescription(chatId, description, this.requestSender);
    }

    public SetChatDescription setChatDescription(String description) {
        return new SetChatDescription(getChatId(), description, this.requestSender);
    }

    public PinChatMessage pinChatMessage(Object chatId, int messageId) {
        return new PinChatMessage(chatId, messageId, this.requestSender);
    }

    public PinChatMessage pinChatMessage(int messageId) {
        return new PinChatMessage(getChatId(), messageId, this.requestSender);
    }

    public UnpinChatMessage unpinChatMessage(Object chatId) {
        return new UnpinChatMessage(chatId, this.requestSender);
    }

    public UnpinChatMessage unpinChatMessage() {
        return new UnpinChatMessage(getChatId(), this.requestSender);
    }

    public UnpinAllChatMessages unpinAllChatMessages(Object chatId) {
        return new UnpinAllChatMessages(chatId, this.requestSender);
    }

    public UnpinAllChatMessages unpinAllChatMessages() {
        return new UnpinAllChatMessages(getChatId(), this.requestSender);
    }

    public LeaveChat leaveChat(Object chatId) {
        return new LeaveChat(chatId, this.requestSender);
    }

    public LeaveChat leaveChat() {
        return new LeaveChat(getChatId(), this.requestSender);
    }

    public GetChat getChat(Object chatId) {
        return new GetChat(chatId, this.requestSender);
    }

    public GetChatAdministrators getChatAdministrators(Object chatId) {
        return new GetChatAdministrators(chatId, this.requestSender);
    }

    public GetChatAdministrators getChatAdministrators() {
        return new GetChatAdministrators(getChatId(), this.requestSender);
    }

    public GetChatMemberCount getChatMemberCount(Object chatId) {
        return new GetChatMemberCount(chatId, this.requestSender);
    }

    public GetChatMemberCount getChatMemberCount() {
        return new GetChatMemberCount(getChatId(), this.requestSender);
    }

    public GetChatMember getChatMember(Object chatId, long userId) {
        return new GetChatMember(chatId, userId, this.requestSender);
    }

    public SetChatStickerSet setChatStickerSet(Object chatId, String stickerSetName) {
        return new SetChatStickerSet(chatId, stickerSetName, this.requestSender);
    }

    public SetChatStickerSet setChatStickerSet(String stickerSetName) {
        return new SetChatStickerSet(getChatId(), stickerSetName, this.requestSender);
    }

    public DeleteChatStickerSet deleteChatStickerSet(Object chatId) {
        return new DeleteChatStickerSet(chatId, this.requestSender);
    }

    public DeleteChatStickerSet deleteChatStickerSet() {
        return new DeleteChatStickerSet(getChatId(), this.requestSender);
    }

    public GetForumTopicIconStickers getForumTopicIconStickers() {
        return new GetForumTopicIconStickers(this.requestSender);
    }

    public CreateForumTopic createForumTopic(Object chatId, String name) {
        return new CreateForumTopic(chatId, name, this.requestSender);
    }

    public CreateForumTopic createForumTopic(String name) {
        return new CreateForumTopic(getChatId(), name, this.requestSender);
    }

    public EditForumTopic editForumTopic(Object chatId, int messageThreadId) {
        return new EditForumTopic(chatId, messageThreadId, this.requestSender);
    }

    public EditForumTopic editForumTopic(int messageThreadId) {
        return new EditForumTopic(getChatId(), messageThreadId, this.requestSender);
    }

    public ReopenForumTopic reopenForumTopic(Object chatId, int messageThreadId) {
        return new ReopenForumTopic(chatId, messageThreadId, this.requestSender);
    }

    public ReopenForumTopic reopenForumTopic(int messageThreadId) {
        return new ReopenForumTopic(getChatId(), messageThreadId, this.requestSender);
    }

    public DeleteForumTopic deleteForumTopic(Object chatId, int messageThreadId) {
        return new DeleteForumTopic(chatId, messageThreadId, this.requestSender);
    }

    public DeleteForumTopic deleteForumTopic(int messageThreadId) {
        return new DeleteForumTopic(getChatId(), messageThreadId, this.requestSender);
    }

    public UnpinAllForumTopicMessages unpinAllForumTopicMessages(Object chatId, int messageThreadId) {
        return new UnpinAllForumTopicMessages(chatId, messageThreadId, this.requestSender);
    }

    public UnpinAllForumTopicMessages unpinAllForumTopicMessages(int messageThreadId) {
        return new UnpinAllForumTopicMessages(getChatId(), messageThreadId, this.requestSender);
    }

    public EditGeneralForumTopic editGeneralForumTopic(Object chatId, String name) {
        return new EditGeneralForumTopic(chatId, name, this.requestSender);
    }

    public EditGeneralForumTopic editGeneralForumTopic(String name) {
        return new EditGeneralForumTopic(getChatId(), name, this.requestSender);
    }

    public CloseGeneralForumTopic closeGeneralForumTopic(Object chatId) {
        return new CloseGeneralForumTopic(chatId, this.requestSender);
    }

    public CloseGeneralForumTopic closeGeneralForumTopic() {
        return new CloseGeneralForumTopic(getChatId(), this.requestSender);
    }

    public ReopenGeneralForumTopic reopenForumTopic(Object chatId) {
        return new ReopenGeneralForumTopic(chatId, this.requestSender);
    }

    public ReopenGeneralForumTopic reopenForumTopic() {
        return new ReopenGeneralForumTopic(getChatId(), this.requestSender);
    }

    public HideGeneralForumTopic hideGeneralForumTopic(Object chatId) {
        return new HideGeneralForumTopic(chatId, this.requestSender);
    }

    public HideGeneralForumTopic hideGeneralForumTopic() {
        return new HideGeneralForumTopic(getChatId(), this.requestSender);
    }

    public UnHideGeneralForumTopic unHideGeneralForumTopic(Object chatId) {
        return new UnHideGeneralForumTopic(chatId, this.requestSender);
    }

    public UnHideGeneralForumTopic unHideGeneralForumTopic() {
        return new UnHideGeneralForumTopic(getChatId(), this.requestSender);
    }

    public UnpinAllGeneralForumTopicMessages unpinAllGeneralForumTopicMessages(Object chat_id){
        return new UnpinAllGeneralForumTopicMessages(chat_id, this.requestSender);
    }

    public UnpinAllGeneralForumTopicMessages unpinAllGeneralForumTopicMessages(){
        return new UnpinAllGeneralForumTopicMessages(getChatId(), this.requestSender);
    }

    public AnswerCallbackQuery answer() {
        return new AnswerCallbackQuery(update.callback_query.id, this.requestSender);
    }

    public AnswerCallbackQuery answer(String text) {
        return new AnswerCallbackQuery(update.callback_query.id, this.requestSender).text(text);
    }

    public AnswerCallbackQuery answerCallbackQuery(String callbackQueryId) {
        return new AnswerCallbackQuery(callbackQueryId, this.requestSender);
    }

    public SetMyCommands setMyCommands(BotCommand[] commands) {
        return new SetMyCommands(commands, this.requestSender);
    }

    public DeleteMyCommands deleteMyCommands() {
        return new DeleteMyCommands(this.requestSender);
    }

    public GetMyCommands getMyCommands() {
        return new GetMyCommands(this.requestSender);
    }

    public SetChatMenuButton setChatMenuButton() {
        return new SetChatMenuButton(this.requestSender);
    }

    public GetChatMenuButton getChatMenuButton() {
        return new GetChatMenuButton(this.requestSender);
    }

    public SetMyDefaultAdministratorRights setMyDefaultAdministratorRights() {
        return new SetMyDefaultAdministratorRights(this.requestSender);
    }

    public GetMyDefaultAdministratorRights getMyDefaultAdministratorRights() {
        return new GetMyDefaultAdministratorRights(this.requestSender);
    }

    public EditMessageText editMessageText(String text, Object chatId, int messageId) {
        return new EditMessageText(text, chatId, messageId, this.requestSender).parseMode(parseMode);
    }

    public EditMessageText editMessageText(String text) {
        return new EditMessageText(text, getChatId(), getMessageId(), this.requestSender).parseMode(parseMode);
    }

    public EditMessageText editMessageText(String text, String inlineMessageId) {
        return new EditMessageText(text, inlineMessageId, this.requestSender).parseMode(parseMode);
    }

    public EditMessageCaption editMessageCaption(Object chatId, int messageId) {
        return new EditMessageCaption(chatId, messageId, this.requestSender).parseMode(parseMode);
    }

    public EditMessageCaption editMessageCaption() {
        return new EditMessageCaption(getChatId(), getMessageId(), this.requestSender).parseMode(parseMode);
    }

    public EditMessageCaption editMessageCaption(String inlineMessageId) {
        return new EditMessageCaption(inlineMessageId, this.requestSender).parseMode(parseMode);
    }

    public EditMessageMedia editMessageMedia(File media, Object chatId, int messageId) {
        return new EditMessageMedia(media, chatId, messageId, this.requestSender);
    }

    public EditMessageMedia editMessageMedia(File media) {
        return new EditMessageMedia(media, getChatId(), getMessageId(), this.requestSender);
    }

    public EditMessageMedia editMessageMedia(File media, String inlineMessageId) {
        return new EditMessageMedia(media, inlineMessageId, this.requestSender);
    }

    public EditMessageReplyMarkup editMessageReplyMarkup(Object chatId, int messageId) {
        return new EditMessageReplyMarkup(chatId, messageId, this.requestSender);
    }

    public EditMessageReplyMarkup editMessageReplyMarkup() {
        return new EditMessageReplyMarkup(getChatId(), getMessageId(), this.requestSender);
    }

    public EditMessageReplyMarkup editMessageReplyMarkup(String inlineMessageId) {
        return new EditMessageReplyMarkup(inlineMessageId, this.requestSender);
    }

    public StopPoll stopPoll(Object chatId, int messageId) {
        return new StopPoll(chatId, messageId, this.requestSender);
    }

    public StopPoll stopPoll() {
        return new StopPoll(getChatId(), getMessageId(), this.requestSender);
    }

    public DeleteMessage deleteMessage(Object chatId, int messageId) {
        return new DeleteMessage(chatId, messageId, this.requestSender);
    }

    public DeleteMessage deleteMessage() {
        return new DeleteMessage(getChatId(), getMessageId(), this.requestSender);
    }

    public SendSticker sendSticker(Object chatId, File sticker) {
        return new SendSticker(chatId, sticker, this.requestSender);
    }

    public SendSticker sendSticker(File sticker) {
        return new SendSticker(getChatId(), sticker, this.requestSender);
    }

    public SendSticker sendSticker(Object chatId, String sticker) {
        return new SendSticker(chatId, sticker, this.requestSender);
    }

    public SendSticker sendSticker(String sticker) {
        return new SendSticker(getChatId(), sticker, this.requestSender);
    }

    public GetStickerSet getStickerSet(String name) {
        return new GetStickerSet(name, this.requestSender);
    }

    public GetCustomEmojiStickers getCustomEmojiStickers(String[] customEmojiIds) {
        return new GetCustomEmojiStickers(customEmojiIds, this.requestSender);
    }

    public UploadStickerFile uploadStickerFile(long userId, File sticker, String stickerFormat) {
        return new UploadStickerFile(userId, sticker, stickerFormat, this.requestSender);
    }

    public CreateNewStickerSet createNewStickerSet(long userId, String name, String title, InputSticker[] stickers,
                                                   String stickerFormat) {
        return new CreateNewStickerSet(userId, name, title, stickers, stickerFormat, this.requestSender);
    }

    public AddStickerToSet addStickerToSet(long userId, String name, File sticker) {
        return new AddStickerToSet(userId, name, sticker, this.requestSender);
    }

    public SetStickerPositionInSet setStickerPositionInSet(String sticker, int position) {
        return new SetStickerPositionInSet(sticker, position, this.requestSender);
    }

    public DeleteStickerFromSet deleteStickerFromSet(String sticker) {
        return new DeleteStickerFromSet(sticker, this.requestSender);
    }

    public SetStickerEmojiList setStickerEmojiList(String sticker, String[] emojiList) {
        return new SetStickerEmojiList(sticker, emojiList, this.requestSender);
    }

    public SetStickerKeywords setStickerKeywords(String sticker, String[] keywords) {
        return new SetStickerKeywords(sticker, keywords, this.requestSender);
    }

    public SetStickerMaskPosition setStickerMaskPosition(String sticker, MaskPosition maskPosition) {
        return new SetStickerMaskPosition(sticker, maskPosition, this.requestSender);
    }

    public SetStickerSetTitle setStickerSetTitle(String sticker, String title) {
        return new SetStickerSetTitle(sticker, title, this.requestSender);
    }

    public SetStickerSetThumbnail setStickerSetThumbnail(String name, long userId, File thumbnail) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, this.requestSender);
    }

    public SetStickerSetThumbnail setStickerSetThumbnail(String name, long userId, String thumbnail) {
        return new SetStickerSetThumbnail(name, userId, thumbnail, this.requestSender);
    }

    public SetCustomEmojiStickerSetThumbnail setCustomEmojiStickerSetThumbnail(String name, String customEmojiId) {
        return new SetCustomEmojiStickerSetThumbnail(name, customEmojiId, this.requestSender);
    }

    public DeleteStickerSet deleteStickerSet(String name) {
        return new DeleteStickerSet(name, this.requestSender);
    }

    public AnswerInlineQuery answerInlineQuery(String inlineQueryId, InlineQueryResult[] results) {
        return new AnswerInlineQuery(inlineQueryId, results, this.requestSender);
    }

    public AnswerInlineQuery answerInlineQuery(InlineQueryResult[] results) {
        return new AnswerInlineQuery(update.inline_query.id, results, this.requestSender);
    }

    public AnswerWebAppQuery answerWebAppQuery(String webAppQueryId, InlineQueryResult result) {
        return new AnswerWebAppQuery(webAppQueryId, result, this.requestSender);
    }

    public SendInvoice sendInvoice(Object chatId, String title, String description, String payload, String providerToken,
                                   String currency, LabeledPrice[] prices) {
        return new SendInvoice(chatId, title, description, payload, providerToken, currency, prices, this.requestSender)
                .parseMode(parseMode);
    }

    public SendInvoice sendInvoice(String title, String description, String payload, String providerToken,
                                   String currency, LabeledPrice[] prices) {
        return new SendInvoice(getChatId(), title, description, payload, providerToken, currency, prices, this.requestSender)
                .parseMode(parseMode);
    }

    public SendInvoice replyInvoice(String title, String description, String payload, String providerToken,
                                    String currency, LabeledPrice[] prices) {
        return new SendInvoice(getChatId(), title, description, payload, providerToken, currency, prices, this.requestSender)
                .parseMode(parseMode).replyToMessageId(getMessageId());
    }

    public CreateInvoiceLink createInvoiceLink(Object chatId, String title, String description, String payload, String providerToken,
                                               String currency, LabeledPrice[] prices) {
        return new CreateInvoiceLink(chatId, title, description, payload, providerToken, currency, prices, this.requestSender);
    }

    public CreateInvoiceLink createInvoiceLink(String title, String description, String payload, String providerToken,
                                               String currency, LabeledPrice[] prices) {
        return new CreateInvoiceLink(getChatId(), title, description, payload, providerToken, currency, prices, this.requestSender);
    }

    public AnswerShippingQuery answerShippingQuery(String shippingQueryId, boolean ok) {
        return new AnswerShippingQuery(shippingQueryId, ok, this.requestSender);
    }

    public AnswerShippingQuery answerShipping(boolean ok) {
        return new AnswerShippingQuery(update.shipping_query.id, ok, this.requestSender);
    }

    public AnswerPreCheckoutQuery answerPreCheckoutQuery(String preCheckoutQueryId, Boolean ok) {
        return new AnswerPreCheckoutQuery(preCheckoutQueryId, ok, this.requestSender);
    }

    public AnswerPreCheckoutQuery answerPreCheckout(boolean ok) {
        return new AnswerPreCheckoutQuery(update.pre_checkout_query.id, ok, this.requestSender);
    }

    public SetPassportDataErrors setPassportDataErrors(long userId, PassportElementError[] errors) {
        return new SetPassportDataErrors(userId, errors, this.requestSender);
    }

    public SendGame sendGame(long chatId, String gameShortName) {
        return new SendGame(chatId, gameShortName, this.requestSender).parseMode(parseMode);
    }

    public SetGameScore setGameScore(long chatId, long userId, int score, int messageId) {
        return new SetGameScore(chatId, userId, score, messageId, this.requestSender);
    }

    public GetMyName getMyName(){
        return new GetMyName(this.requestSender);
    }

    public SetMyName setMyName(){
        return new SetMyName(this.requestSender);
    }

    public SetGameScore setGameScore(String inlineMessageId, long userId, int score) {
        return new SetGameScore(inlineMessageId, userId, score, this.requestSender);
    }

    public GetGameHighScores getGameHighScores(long chatId, long userId, int messageId) {
        return new GetGameHighScores(chatId, userId, messageId, this.requestSender);
    }

    public GetGameHighScores getGameHighScores(long userId, int messageId) {
        return new GetGameHighScores(getChatId(), userId, messageId, this.requestSender);
    }

    public GetGameHighScores getGameHighScores(String inlineMessageId, long userId) {
        return new GetGameHighScores(inlineMessageId, userId, this.requestSender);
    }

    public void setState(long chatId, long userId, String name){
        storage.save(chatId, userId, name);
    }

    public void setState(long userId, String name){
        storage.save(userId, name);
    }

    public void clearState(long chatId, long userId){
        storage.clear(chatId, userId);
    }

    public void clearState(long userId){
        storage.clear(userId);
    }

    public Map<String, Object> getStateData(long chatId, long userId){
        return storage.getData(chatId, userId);
    }

    public Map<String, Object> getStateData(long userId){
        return storage.getData(userId);
    }

    public GetUpdates getUpdates(){
        return new GetUpdates(requestSender);
    }

    private Long getChatId(){
        if (update.message != null) return update.message.chat.id;
        if (update.callback_query != null) return update.callback_query.message.chat.id;
        if (update.edited_message != null) return update.edited_message.chat.id;
        if (update.channel_post != null) return update.channel_post.chat.id;
        if (update.edited_channel_post != null) return update.edited_channel_post.chat.id;
        if (update.chat_member != null) return update.chat_member.chat.id;
        if (update.chat_join_request != null) return update.chat_join_request.chat.id;
        if (update.my_chat_member != null) return update.my_chat_member.chat.id;
        return 0L;
    }

    private int getMessageId(){
        if (update.message != null) return update.message.message_id;
        if (update.callback_query != null) return update.callback_query.message.message_id;
        if (update.edited_message != null) return update.edited_message.message_id;
        if (update.channel_post != null) return update.channel_post.message_id;
        if (update.edited_channel_post != null) return update.edited_channel_post.message_id;
        return 0;
    }
}
