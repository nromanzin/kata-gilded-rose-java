import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    private GildedRose initTavern(Item... items) {
        return new GildedRose(items);
    }

    @Test
    public void shouldDegradeStandardItem1PerDay() {
        GildedRose tavern = initTavern(new Item("standard item", 10, 5));
        tavern.updateQuality();
        assertEquals("standard item", tavern.items[0].name);
        assertEquals(9, tavern.items[0].sellIn);
        assertEquals(4, tavern.items[0].quality);
    }
}
