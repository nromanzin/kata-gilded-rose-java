public class StandardItem extends StoreItem {
    public StandardItem(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseSellIn();
        decreaseQuality();
        if (getSellIn() < 0) {
            decreaseQuality();
        }
    }
}
