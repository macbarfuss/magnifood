package de.macbarfuss.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;



/**
 * The model that defines the nodes in the tree.
 */
public final class IngredientTreeMockUpModel implements TreeViewModel {

    private final List<IngredientCategory> categories;
    private final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();

    public IngredientTreeMockUpModel() {
        // Create a database of information.
        categories = new ArrayList<IngredientCategory>();

        final IngredientCategory fruits = new IngredientCategory("fruits");
        final IngredientCategory veggies = new IngredientCategory("vegetables");

        categories.add(fruits);
        categories.add(veggies);

        final Ingredient apple = fruits.addIngredient(new Ingredient("apple"));
        apple.addVariant("Boskopp");
        apple.addVariant("Delicious");
        apple.addVariant("Gala");

        final Ingredient himbeeren = fruits.addIngredient(new Ingredient("Himbeeren"));
        himbeeren.addVariant("frisch, süß");
        himbeeren.addVariant("frisch, säuerlich");
        himbeeren.addVariant("gefroren (Aldi)");
        himbeeren.addVariant("gefroren (Globus)");

        final Ingredient blumenkohl = veggies.addIngredient(new Ingredient("Blumenkohl"));
        blumenkohl.addVariant("normal");

        final Ingredient gurke = veggies.addIngredient(new Ingredient("Gurken"));
        gurke.addVariant("Salatgurke");
        gurke.addVariant("Essiggurke (Kühne Schlemmertopf)");
        gurke.addVariant("Cornichons (Kühne)");
    }

    /**
     * Get the {@link NodeInfo} that provides the children of the specified
     * value.
     */
    public <T> NodeInfo<?> getNodeInfo(final T value) {
        NodeInfo<?> result;

        if (value == null) {
            result = selectCategories();
        } else if (value instanceof IngredientCategory) {
            result = selectIngredients((IngredientCategory) value);
        } else if (value instanceof Ingredient) {
            result = selectVariants((Ingredient) value);
        } else {
            result = null;
        }
        return result;
    }

    private NodeInfo<IngredientCategory> selectCategories() {
        final ListDataProvider<IngredientCategory> dataProvider =
                new ListDataProvider<IngredientCategory>(categories);

        final Cell<IngredientCategory> cell = new AbstractCell<IngredientCategory>() {
            @Override
            public void render(final Context context, final IngredientCategory value, final SafeHtmlBuilder sb) {
                if (value != null) {
                    sb.appendEscaped(value.getName());
                }
            }
        };

        return new DefaultNodeInfo<IngredientCategory>(dataProvider, cell);
    }

    private <T> NodeInfo<?> selectIngredients(final IngredientCategory category) {
        final ListDataProvider<Ingredient> dataProvider =
                new ListDataProvider<Ingredient>(category.getIngredients());

        final Cell<Ingredient> cell = new AbstractCell<Ingredient>() {
            @Override
            public void render(final Context context, final Ingredient ingredient, final SafeHtmlBuilder sb) {
                if (ingredient != null) {
                    sb.appendEscaped(ingredient.getName());
                }
            }
        };

        return new DefaultNodeInfo<Ingredient>(dataProvider, cell);
    }

    private <T> NodeInfo<?> selectVariants(final Ingredient ingredient) {
        final ListDataProvider<String> dataProvider = new ListDataProvider<String>(ingredient.getVariants());

        // Use the shared selection model.
        return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
    }

    /**
     * Check if the specified value represents a leaf node. Leaf nodes
     * cannot be opened.
     */
    public boolean isLeaf(final Object value) {
        // The leaf nodes are the songs, which are Strings.
        if (value instanceof String) {
            return true;
        }
        return false;
    }

}
