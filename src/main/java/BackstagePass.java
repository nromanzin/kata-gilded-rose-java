public class BackstagePass extends StoreItem {
    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    void update() {
        decreaseSellIn();
        increaseQuality();
        if (getSellIn() < 10) {
            increaseQuality();
        }
        if (getSellIn() < 5) {
            increaseQuality();
        }
        if (getSellIn() < 0) {
            qualityToZero();
        }
    }
}
