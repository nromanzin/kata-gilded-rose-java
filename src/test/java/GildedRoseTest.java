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

    @Test
    public void shouldDegradeStandardItem2PerDayWhenSellinDateHasPassed() {
        GildedRose tavern = initTavern(new Item("standard item", 0, 5));
        tavern.updateQuality();
        assertEquals("standard item", tavern.items[0].name);
        assertEquals(-1, tavern.items[0].sellIn);
        assertEquals(3, tavern.items[0].quality);
    }

    @Test
    public void qualityIsNeverNegative() {
        GildedRose tavern = initTavern(new Item("standard item", 10, 0));
        tavern.updateQuality();
        assertEquals("standard item", tavern.items[0].name);
        assertEquals(9, tavern.items[0].sellIn);
        assertEquals(0, tavern.items[0].quality);
    }

    @Test
    public void agedBrieIncreaseInQuality() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.AGED_BRIE, 10, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.AGED_BRIE, tavern.items[0].name);
        assertEquals(9, tavern.items[0].sellIn);
        assertEquals(11, tavern.items[0].quality);
    }

    @Test
    public void agedBrieIncreaseTwiceInQualityAfterSellinDate() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.AGED_BRIE, -10, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.AGED_BRIE, tavern.items[0].name);
        assertEquals(-11, tavern.items[0].sellIn);
        assertEquals(12, tavern.items[0].quality);
    }

    @Test
    public void qualityIsNeverAbove50() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.AGED_BRIE, 10, 50));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.AGED_BRIE, tavern.items[0].name);
        assertEquals(9, tavern.items[0].sellIn);
        assertEquals(50, tavern.items[0].quality);
    }

    @Test
    public void sulfurasIsLegendary() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.SULFURAS, 10, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.SULFURAS, tavern.items[0].name);
        assertEquals(10, tavern.items[0].sellIn);
        assertEquals(10, tavern.items[0].quality);
    }

    @Test
    public void backstagePassesIncreaseInQuality() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.BACKSTAGE_PASSES, 15, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.BACKSTAGE_PASSES, tavern.items[0].name);
        assertEquals(14, tavern.items[0].sellIn);
        assertEquals(11, tavern.items[0].quality);
    }

    @Test
    public void backstagePassesIncrease2InQualityWhen10DaysLeft() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.BACKSTAGE_PASSES, 10, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.BACKSTAGE_PASSES, tavern.items[0].name);
        assertEquals(9, tavern.items[0].sellIn);
        assertEquals(12, tavern.items[0].quality);
    }

    @Test
    public void backstagePassesIncrease3InQualityWhen5DaysLeft() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.BACKSTAGE_PASSES, 5, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.BACKSTAGE_PASSES, tavern.items[0].name);
        assertEquals(4, tavern.items[0].sellIn);
        assertEquals(13, tavern.items[0].quality);
    }

    @Test
    public void backstagePassesQualityIsZeroAfterConcert() {
        GildedRose tavern = initTavern(new Item(GildedRoseStore.BACKSTAGE_PASSES, 0, 10));
        tavern.updateQuality();
        assertEquals(GildedRoseStore.BACKSTAGE_PASSES, tavern.items[0].name);
        assertEquals(-1, tavern.items[0].sellIn);
        assertEquals(0, tavern.items[0].quality);
    }
}
