package et.telebof;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BotClientTest {
    BotClient bot;
    String TOKEN;

    @Before
    public void setUp(){
        TOKEN = System.getenv("TOKEN");
        bot = new BotClient(TOKEN);
//        bot.start();
    }

    @Test
    public void onMessage() {
        bot.onMessage(filter -> filter.commands("start"), (ctx, msg) -> {
            assertEquals("/start", msg.getText());
            assertNotNull(msg.getChat());
            bot.stop();
        });

        bot.start();
    }

    @Test
    public void onCallback() {
    }

    @Test
    public void onInline() {
    }

    @Test
    public void onPoll() {
    }

    @Test
    public void onMyChatMember() {
    }

    @Test
    public void onPollAnswer() {
    }

    @Test
    public void onPreCheckout() {
    }

    @Test
    public void onChatMember() {
    }

    @Test
    public void onEditedMessage() {
    }

    @Test
    public void onChannelPost() {
    }

    @Test
    public void onEditedChannelPost() {
    }

    @Test
    public void onChatJoinRequest() {
    }

    @Test
    public void onChosenInlineResult() {
    }

    @Test
    public void onShipping() {
    }

    @Test
    public void setWebhook() {
    }

    @Test
    public void stop() {
    }

    @Test
    public void getBot() {
    }
}