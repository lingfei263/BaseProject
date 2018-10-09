package cn.ffb.utils;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author lingfei 2017-5-9
 */
public class JsonUtils {

    public static String toJson(Object o) {
        if (o == null) {
            return null;
        }
        try {
            return new Gson().toJson(o);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T toObject(String json, Class<T> classOfT) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            return new Gson().fromJson(json, classOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T toObject(String json, Type typeOfT) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            return new Gson().fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
