package com.oglcnarbc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Ogulcan Arabaci
 */
public class GsonUtil {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}
