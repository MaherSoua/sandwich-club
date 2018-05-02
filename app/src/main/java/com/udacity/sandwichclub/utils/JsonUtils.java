package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private final static String TAG = "JsonUtils";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");
            String name = nameObject.getString("mainName");
            List<String> knownAs = setArray(nameObject.getJSONArray("alsoKnownAs"));

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            List<String> ingredients = setArray(jsonObject.getJSONArray("ingredients"));
            return new Sandwich(name, knownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException error) {
            Log.e(TAG, error.getMessage());
            return null;
        }

    }

    private static List<String> setArray(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        if (jsonArray != null) {
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getString(i));
                }
            } catch (JSONException error) {
                Log.e(TAG, error.getMessage());

            }
        }
        return list;
    }
}
