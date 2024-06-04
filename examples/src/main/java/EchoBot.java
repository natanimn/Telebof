import et.telebof.BotClient;

class EchoBot {
    static final String TOKEN = System.getenv("TOKEN");

    public static void main(String[] args) {
        final BotClient bot = new BotClient.Builder(TOKEN).log(true).build();

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
