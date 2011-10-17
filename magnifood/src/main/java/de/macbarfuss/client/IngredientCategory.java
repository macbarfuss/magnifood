package de.macbarfuss.client;

import java.util.ArrayList;
import java.util.List;


public final class IngredientCategory {
    private final String name;
    private final List<Ingredient> ingredients = new ArrayList<Ingredient>();

    public IngredientCategory(final String theName) {
        name = theName;
    }

    public Ingredient addIngredient(final Ingredient ingredient) {
        ingredients.add(ingredient);
        return ingredient;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
