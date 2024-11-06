package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemTest {

    Item normalItem;
    NormalItem sut;

    @BeforeEach
    void setUp() {
        normalItem = new Item("normalItem", 10, 20);
        sut = new NormalItem(normalItem);
    }

    // if Item name is not specific one and SellIn higher than 0
    // reducing sellIn and quality by one
    @Test
    void normalItemTest_WhenSellInHigherThanZero() {
        sut.updateQuality();

        assertEquals("normalItem", normalItem.getName());
        assertEquals(9, normalItem.getSellIn());
        assertEquals(19, normalItem.getQuality());
    }

    // if Item name is not specific one and SellIn 0 or lower than 0
    // reducing sellIn by one and quality by two
    @Test
    void normalItemTest_WhenSellInIsZero() {
        normalItem.setSellIn(0);
        sut.updateQuality();

        assertEquals("normalItem", normalItem.getName());
        assertEquals(-1, normalItem.getSellIn());
        assertEquals(18, normalItem.getQuality());
    }

    @Test
    void normalItemTest_WhenSellInLowerThanZero() {
        normalItem.setSellIn(-1);
        sut.updateQuality();

        assertEquals("normalItem", normalItem.getName());
        assertEquals(-2, normalItem.getSellIn());
        assertEquals(18, normalItem.getQuality());
    }

    // if Item name is not specific one
    // quality should never go negative
    @Test
    void normalItemTest_QualityNeverNegative() {
        normalItem.setQuality(0);
        sut.updateQuality();

        assertEquals("normalItem", normalItem.getName());
        assertEquals(9, normalItem.getSellIn());
        assertEquals(0, normalItem.getQuality());
    }

}
