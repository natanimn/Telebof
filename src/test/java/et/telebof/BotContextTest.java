package et.telebof;

import et.telebof.types.Message;
import et.telebof.types.MessageId;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.*;

public class BotContextTest {

    BotClient bot;
    long userId;
    String TOKEN;

    @Before
    public void setUp() {
        TOKEN = System.getenv("TEST_TOKEN");
        bot = new BotClient(TOKEN);
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
        Message message = bot.context.sendMessage(userId, "Hello, World").exec();
        assertNotNull(message);
        assertEquals(message.text, "Hello, World");
        sleep(1);
    }

    @Test
    public void sendPhotoTest(){
        File photo = new File("src/test/resources/telegram.png");
        Message message = bot.context.sendPhoto(userId, photo).caption("Hello, World").exec();
        assertNotNull(message);
        assertEquals("Hello, World", message.caption);
        sleep(1);
    }

    @Test
    public void forwardMessageTest(){
        Message message = bot.context.sendMessage(userId, "Trying to forward this message again").exec();
        Message msg = bot.context.forward(userId, userId, message.message_id).exec();
        assertNotNull(msg);
        assertEquals(message.text, msg.text);
        sleep(1);
    }

    @Test
    public void copyMessage(){
        Message message = bot.context.sendMessage(userId, "I will copy this message again").exec();
        MessageId msg = bot.context.copy(userId, userId, message.message_id).exec();
        assertNotEquals(msg.message_id, message.message_id);
        sleep(1);
    }

}