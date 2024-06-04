import et.telebof.BotClient;
import et.telebof.TelegramContext;
import et.telebof.types.Message;
import et.telebof.types.ReplyKeyboardMarkup;
import java.util.Map;

public class StateExampleBot {
    private BotClient bot;

    StateExampleBot(String token){
        bot = new BotClient(token);
        bot.onMessage(filter -> filter.commands("start"), this::start);
        bot.onMessage(filter -> filter.state("name") && filter.TEXT, this::getName);
        bot.onMessage(filter -> filter.state("age") && filter.TEXT, this::getAge);
        bot.onMessage(filter -> filter.state("gender") && filter.TEXT, this::getGender);
    }

    void start(TelegramContext ctx, Message msg){
        ctx.sendMessage("Hello, what is your name?").bind();
        ctx.setState(msg.getFrom().getId(), "name");
    }

    void getName(TelegramContext ctx, Message msg){
        ctx.reply("What about your age?").bind();
        ctx.setState(msg.getFrom().getId(), "age");
        Map<String, Object> data = ctx.getStateData(msg.getFrom().getId());
        data.put("name", msg.getText());
    }

    void getAge(TelegramContext ctx, Message msg){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup().resizeKeyboard(true);
        markup.add("Male", "Female");
        ctx.sendMessage("What is your gender?").replyMarkup(markup).bind();
        ctx.setState(msg.getFrom().getId(), "gender");
        Map<String, Object> data = ctx.getStateData(msg.getFrom().getId());
        data.put("age", msg.getText());
    }

    void getGender(TelegramContext ctx, Message msg){
        Map<String, Object> data = ctx.getStateData(msg.getFrom().getId());
        String name = String.valueOf(data.get("name"));
        String age = String.valueOf(data.get("age"));
        String gender = msg.getText();
        ctx.sendMessage(String.format("Name: %s\nAge: %s\nGender: %s", name, age, gender)).bind();
        ctx.clearState(msg.getFrom().getId());
    }

    void runBot(){
        bot.start();
    }

    public static void main(String[] args){
        String TOKEN = "YOUR BOT TOKEN";
        StateExampleBot stateExampleBot = new StateExampleBot(TOKEN);
        stateExampleBot.runBot();
    }
}
