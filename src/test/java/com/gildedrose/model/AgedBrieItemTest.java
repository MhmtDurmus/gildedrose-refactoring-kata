package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieItemTest {

    Item agedBrieItem;
    AgedBrieItem sut;

    @BeforeEach
    void setUp() {
        agedBrieItem = new Item("Aged Brie", 10, 20);
        sut = new AgedBrieItem(agedBrieItem);
    }

    // if Item name is Aged Brie
    // if sellIn higher than 0, sellIn should be reduced by 1
    // quality should be increased by one
    @Test
    void agedBrieItemTest_WhenSellInHigherThanZero() {
        sut.updateQuality();
        assertEquals(9, agedBrieItem.getSellIn());
        assertEquals(21, agedBrieItem.getQuality());
    }

    // if Item name is Aged Brie
    // if sellIn is 0 or lower, sellIn should be reduced by 1
    // quality should be increased by two
    @Test
    void agedBrieItemTest_WhenSellInIsZero() {
        // Edge Case
        agedBrieItem.setSellIn(0);

        sut.updateQuality();

        assertEquals(-1, agedBrieItem.getSellIn());
        assertEquals(22, agedBrieItem.getQuality());
    }

    @Test
    void agedBrieItemTest_WhenSellInLowerThanZero() {
        agedBrieItem.setSellIn(-1);

        sut.updateQuality();

        assertEquals(-2, agedBrieItem.getSellIn());
        assertEquals(22, agedBrieItem.getQuality());
    }


    // if Item name is Aged Brie
    // Quality should be increased but never exceed 50
    @Test
    void agedBrieItemTest_QualityDoesNotExceed50() {
        agedBrieItem.setQuality(50);

        sut.updateQuality();
        assertEquals(9, agedBrieItem.getSellIn());
        assertEquals(50, agedBrieItem.getQuality());
    }

}
