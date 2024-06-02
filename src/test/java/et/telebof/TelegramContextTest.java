package et.telebof;

import et.telebof.types.Message;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.*;

public class TelegramContextTest {

    BotClient bot;
    long chatId;
    long userId;
    String invalidId;
    String TOKEN;


    @Before
    public void setUp() {
        TOKEN = System.getenv("TEST_TOKEN");
        bot = new BotClient(TOKEN);
        chatId = Long.parseLong(System.getenv("TEST_CHAT_ID"));
        userId = Long.parseLong(System.getenv("TEST_USER_ID"));
    }

    void sleep(int secs){
        try{
            Thread.sleep(1000L *secs);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void sendMessageTest(){
        Message message = bot.context.sendMessage(userId, "Hello, World").bind();
        assertNotNull(message);
        assertEquals(message.getText(), "Hello, World");
        sleep(1);
    }

    @Test
    public void sendPhotoTest(){
        File photo = new File("src/test/resources/telegram.png");
        Message message = bot.context.sendPhoto(userId, photo).caption("Hello, World").bind();
        assertNotNull(message);
        assertEquals("Hello, World", message.getCaption());
        sleep(1);
    }

    @Test
    public void forwardMessageTest(){
        Message message = bot.context.sendMessage(userId, "Trying to forward this message again").bind();
        Message msg = bot.context.forwardMessage(userId, userId, message.getMessageId()).bind();
        assertNotNull(msg);
        assertEquals(message.getText(), msg.getText());
    }

}