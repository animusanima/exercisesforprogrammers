package utils;

import java.util.HashMap;
import java.util.Map;

public class UserDataUtils {
    public static Map<String, String> withInformation(String first, String last, String position, String separationDate) {
        Map<String, String> user = new HashMap<>();
        user.put("first", first);
        user.put("last", last);
        user.put("position", position);
        user.put("separationDate", separationDate == null ? "" : separationDate);
        return user;
    }
}