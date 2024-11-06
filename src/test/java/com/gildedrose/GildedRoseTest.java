package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void gildedRoseTest_WithMultipleItems() {

        // Given
        Item[] items = new Item[]{
            new Item("Normal Item", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        GildedRose sut = new GildedRose(items);

        // When
        sut.updateQuality();

        // Then

        // Normal Item
        assertEquals(9, items[0].getSellIn());
        assertEquals(19, items[0].getQuality());

        // Aged Brie Item
        assertEquals(1, items[1].getSellIn());
        assertEquals(1, items[1].getQuality());

        // Sulfuras Item
        assertEquals(0, items[2].getSellIn());
        assertEquals(80, items[2].getQuality());

        // Backstage Pass Item
        assertEquals(14, items[3].getSellIn());
        assertEquals(21, items[3].getQuality());
    }

    @Test
    void gildedRoseQualityAndSellInTest_WithDifferentItemTypes() {
        // Given
        Item[] items = new Item[]{
            new Item("Normal Item", 0, 10),
            new Item("Aged Brie", 0, 48),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45),
        };
        GildedRose sut = new GildedRose(items);

        // When

        sut.updateQuality();

        // Then

        // Normal item quality degrades twice when sellIn 0 or below
        assertEquals(-1, items[0].getSellIn());
        assertEquals(8, items[0].getQuality());

        // Aged Brie quality increases by 2 when sellIn 0 or below
        assertEquals(-1, items[1].getSellIn());
        assertEquals(50, items[1].getQuality());

        // Backstage passes quality increases by 3 when sellIn 5 or less
        assertEquals(4, items[2].getSellIn());
        assertEquals(48, items[2].getQuality());
    }
}
