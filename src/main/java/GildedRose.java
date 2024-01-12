public class GildedRose {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : this.items) {
            GildedRoseStore.get(item).update();
        }
    }
}