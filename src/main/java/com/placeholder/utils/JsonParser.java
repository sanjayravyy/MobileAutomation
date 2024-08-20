package com.placeholder.utils;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JsonParser {

    private final String filePath;

    /**
     * @param filePath the path to the JSON file
     */
    public JsonParser(String filePath) {
        this.filePath = filePath;
    }

    public static HashMap<String, Object> toMap(JSONObject jsonobj) {
        HashMap<String, Object> map = new HashMap<>();
        Iterator<String> keys = jsonobj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, toMap((JSONObject) value));
        }
        return map;
    }

    /**
     * @param array the array
     * @return the list
     * @return the list
     */
    private static List<Object> toList(JSONArray array) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }

        return list;
    }

    public JSONObject getObjectFromJSON() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String jsonContent = IOUtils.toString(bufferedReader);
            return new JSONObject(jsonContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
