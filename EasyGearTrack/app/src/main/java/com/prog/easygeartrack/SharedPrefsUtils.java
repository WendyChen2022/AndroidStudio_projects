package com.prog.easygeartrack;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefsUtils {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_GEAR_LIST = "gear_list";

    public static void saveGearList(Context context, List<GearItem> gearList) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(gearList);
        editor.putString(KEY_GEAR_LIST, json);
        editor.apply();
    }

    public static List<GearItem> loadGearList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_GEAR_LIST, null);
        Type type = new TypeToken<ArrayList<GearItem>>() {}.getType();
        return gson.fromJson(json, type);
    }
}

