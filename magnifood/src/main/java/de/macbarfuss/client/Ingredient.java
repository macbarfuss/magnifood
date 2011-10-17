package de.macbarfuss.client;

import java.util.ArrayList;
import java.util.List;



/**
 * A list of songs.
 */
public final class Ingredient {
    private final String name;
    private final List<String> variants = new ArrayList<String>();

    public Ingredient(final String theName) {
        name = theName;
    }

    public String getName() {
        return name;
    }

    public void addVariant(final String variantName) {
        variants.add(variantName);
    }

    public List<String> getVariants() {
        return variants;
    }
}
