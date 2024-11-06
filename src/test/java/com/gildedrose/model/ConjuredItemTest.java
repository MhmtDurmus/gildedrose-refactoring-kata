package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemTest {

    Item conjuredItem;
    ConjuredItem sut;

    @BeforeEach
    void setUp() {
        conjuredItem = new Item("Conjured Mana Cake", 10, 20);
        sut = new ConjuredItem(conjuredItem);
    }

    @Test
    void conjuredItemTest_DecreaseQuality() {
        sut.updateQuality();

        assertEquals("Conjured Mana Cake", conjuredItem.getName());
        assertEquals(9, conjuredItem.getSellIn());
        assertEquals(18, conjuredItem.getQuality());
    }
}
