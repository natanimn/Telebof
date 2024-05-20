package et.telebof;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class Parser {
    static Gson gson = new Gson();

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
            tList.add(Parser.parse(gson.toJson(r), res));
        });

        return tList;
    }

}
