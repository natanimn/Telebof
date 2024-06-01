package et.telebof;


import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

abstract public class Util {
    static Gson gson = new Gson();

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
                .replace("&", "&amp;")
                .replace(">", "&gt;")
                .replace("<", "&lt;");

    }
    
    public static ApiResponse parseApiResponse(String o){
        return gson.fromJson(o, ApiResponse.class);
    }

    public static <T> T parse(Object jsonString, Class<T> res) {
        try{
            return gson.fromJson((String) jsonString, res);
        } catch (Exception e){
            return gson.fromJson(gson.toJson(jsonString), res);
        }
    }

    public static <T> List<T> parseList(List<Object> objectList, Class<T> res) {
        List<T> tList = new ArrayList<>();
        objectList.forEach(r->{
            tList.add(Util.parse(gson.toJson(r), res));
        });

        return tList;
    }
    
}
