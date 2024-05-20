package et.telebof.helpers;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.LongSerializationPolicy;
import et.telebof.ApiResponse;
import et.telebof.BotLog;
import et.telebof.types.*;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract public class Util {
    public static boolean isCommand(String text){
        return text.startsWith("/");
    }

    public static String extractCommand(String text){
        if (isCommand(text)) {
            try {
                String command;
                if (text.contains("@")) {
                    command = text.split("@")[0].split("/")[1];
                } else {
                    command = text.split("/")[1];
                }
                return command.split(" ")[0];

            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String extractText(String text) {
        if (isCommand(text)) {
            String[] smart = text.split(" ");
            int len = smart.length;
            if (len == 1) return null;
            List<String> smarts = Arrays.stream(smart).collect(Collectors.toList());
            return String.join(" ", smarts.subList(1, len));
        }
        return null;
    }

    public static String escapeHtml(String text){
        if (text == null)
            return null;
        else return text
                .replace(">", "&gt;")
                .replace("<", "&lt;")
                .replace("&", "&amp;");
    }

    public static class Parser {
        static Gson gson = new Gson().newBuilder().setLongSerializationPolicy(LongSerializationPolicy.DEFAULT)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        public static Message messageParser(String reader) {
            return gson.fromJson(reader, Message.class);
        }

        public static Message messageParser(Reader reader) {
            return gson.fromJson(reader, Message.class);
        }

        public static Message messageParser(Map reader) {
            return gson.fromJson(gson.toJson(reader, Message.class), Message.class);
        }

        public static Update parseUpdate(Reader reader) {
            return gson.fromJson(reader, Update.class);
        }

        public static ApiResponse parseApiResponse(String o) {
            return gson.fromJson(o, ApiResponse.class);
        }

        public static <T> T parse(Object jsonString, Class<T> res) {
            try {
                return gson.fromJson((String) jsonString, res);
            } catch (Exception e) {
                return gson.fromJson(gson.toJson(jsonString), res);
            }
        }

        public static <T> List<T> parseList(List<Object> objectList, Class<T> res) {
            List<T> tList = new ArrayList<>();
            objectList.forEach(r -> {
                tList.add(et.telebof.Parser.parse(gson.toJson(r), res));
            });

            return tList;
        }
    }

    public List<List<Map<String, Object>>> addInlineKeyboard(InlineKeyboardButton[] keyboardButton, int rowWidth){
        if (rowWidth > 8) {
            BotLog.warn("Currently telegram supports 8 inline keyboard rowWidth at maximum");
            rowWidth = 8;
        }

        List<List<Map<String, Object>>> keyboards = new ArrayList<>();

        List<InlineKeyboardButton> inlineButtons = List.of(keyboardButton);

        for (int i =0; i < keyboardButton.length; i+=rowWidth) {
            List<Map<String, Object>> temp = new ArrayList<>();
            for (int j = i; j < i + rowWidth; j++) {
                try {
                    temp.add(inlineButtons.get(j).getJson());
                } catch (ArrayIndexOutOfBoundsException ignored) {
                    break;
                }
            }
            keyboards.add(temp);
        }
        return keyboards;
    }

}
