package com.gildedrose.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemTest {


    // if Item name is Sulfuras, Hand of Ragnaros
    // Quality and SellIn is constant, never changes quality always 80
    @Test
    void sulfurasItemTest_NeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 20);
        SulfurasItem sut = new SulfurasItem(item);

        sut.updateQuality();
        assertEquals(10, item.getSellIn());
        assertEquals(80, item.getQuality());
    }
}
