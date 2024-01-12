import java.util.Map;
import java.util.function.Function;

public class GildedRoseStore {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final Map<String, Function<Item, StoreItem>> ITEMS_FACTORIES = buildFactories();

    public static StoreItem get(Item item) {
        return ITEMS_FACTORIES.getOrDefault(item.name, StandardItem::new)
                .apply(item);
    }

    private static Map<String, Function<Item, StoreItem>> buildFactories() {
        return Map.of(
                SULFURAS, Sulfuras::new,
                AGED_BRIE, AgedBrie::new,
                BACKSTAGE_PASSES, BackstagePass::new);
    }

}
