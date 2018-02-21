package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        if (json.isEmpty())
            return null;
        //Create new Sandwich object
        Sandwich sandwich = new Sandwich();
        JSONObject sandwichJson = new JSONObject(json);
        JSONObject nameJson = sandwichJson.getJSONObject("name");

        //Set mainName
        sandwich.setMainName(nameJson.getString("mainName"));
        //Get alsoKnownAsList
        JSONArray alsoKnownAsArray = nameJson.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = new ArrayList<>();
        if (alsoKnownAsArray.length() != 0) {
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i));
            }
        }
        //Set alsoKnownAs
        sandwich.setAlsoKnownAs(alsoKnownAsList);
        //Set description
        sandwich.setDescription(sandwichJson.getString("description"));
        //Set image
        sandwich.setImage(sandwichJson.getString("image"));

        //Get ingredientsList from JSON
        JSONArray ingredientsArray = sandwichJson.getJSONArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        if (ingredientsArray.length() != 0) {
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.getString(i));
            }
        }
        //Set ingredients
        sandwich.setIngredients(ingredientsList);
        //Set placeOfOrigins
        sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));
        return sandwich;
    }

}
