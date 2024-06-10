package com.prog.easygeartrack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    // Parse JSON string into a list of GearItem objects
    public static List<GearItem> parseGearItemsJson(String json) {
        List<GearItem> gearItems = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String type = jsonObject.getString("type");
                String condition = jsonObject.getString("condition");
                gearItems.add(new GearItem(name, type, condition));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gearItems;
    }

    // Convert a list of GearItem objects into a JSON string
    public static String toJson(List<GearItem> gearItems) {
        JSONArray jsonArray = new JSONArray();
        try {
            for (GearItem gearItem : gearItems) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", gearItem.getName());
                jsonObject.put("type", gearItem.getCategory());
                jsonObject.put("condition", gearItem.getCondition());
                jsonArray.put(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray.toString();
    }
}
