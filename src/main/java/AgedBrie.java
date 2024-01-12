 public class AgedBrie extends StoreItem {
    public AgedBrie(Item item) {
        super(item);
    }

     @Override
     void update() {
         decreaseSellIn();
         increaseQuality();
         if (getSellIn() < 0) {
             increaseQuality();
         }
     }

 }
