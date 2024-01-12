import java.util.Optional;

public abstract class StoreItem {

    private final Item item;
    public StoreItem(Item item) {
        this.item = item;
    }

    protected void increaseQuality() {
        item.quality = Math.min(item.quality + 1, GildedRose.MAX_QUALITY);
    }

    protected int getSellIn() {
        return item.sellIn;
    }

    protected void qualityToZero() {
        item.quality = 0;
    }

    protected void decreaseSellIn() {
        item.sellIn -= 1;
    }

    protected void decreaseQuality() {
        item.quality = Math.max(GildedRose.MIN_QUALITY, item.quality - 1);
    }

    abstract void update();
}
