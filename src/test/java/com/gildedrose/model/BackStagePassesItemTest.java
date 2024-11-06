package com.gildedrose.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackStagePassesItemTest {

    Item backStagePassesItem;
    BackStagePassesItem sut;

    @BeforeEach
    void setUp() {
        backStagePassesItem = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        sut = new BackStagePassesItem(backStagePassesItem);
    }

    // if Item name is Backstage passes to a TAFKAL80ETC concert
    // SellIn higher than 10
    // Quality increased by 1
    @Test
    void backstagePassesItemTest_WhenSellInHigherThan10() {

        sut.updateQuality();

        assertEquals(14, backStagePassesItem.getSellIn());
        assertEquals(21, backStagePassesItem.getQuality());
    }

    // if Item name is Backstage passes to a TAFKAL80ETC concert
    // SellIn is 10 or Less
    // Quality increased by 2
    @Test
    void backstagePassesItemTest_WhenSellIn10orLess() {
        backStagePassesItem.setSellIn(10);
        sut.updateQuality();

        assertEquals(9, backStagePassesItem.getSellIn());
        assertEquals(22, backStagePassesItem.getQuality());
    }

    // if Item name is Backstage passes to a TAFKAL80ETC concert
    // SellIn is 5 or Less
    // Quality increased by 3
    @Test
    void backstagePassesItemTest_WhenSellIn5orLess() {
        backStagePassesItem.setSellIn(5);
        sut.updateQuality();

        assertEquals(4, backStagePassesItem.getSellIn());
        assertEquals(23, backStagePassesItem.getQuality());
    }


    // if Item name is Backstage passes to a TAFKAL80ETC concert
    // SellIn is 0 or Less
    // Quality is 0
    @Test
    void backstagePassesItemTest_WhenSellInZeroOrLess() {
        backStagePassesItem.setSellIn(0);
        sut.updateQuality();

        assertEquals(-1, backStagePassesItem.getSellIn());
        assertEquals(0, backStagePassesItem.getQuality());
    }

    @Test
    void backstagePassesItemTest_QualityNeverAbove50() {
        backStagePassesItem.setQuality(50);
        backStagePassesItem.setSellIn(5);
        sut.updateQuality();

        assertEquals(4, backStagePassesItem.getSellIn());
        assertEquals(50, backStagePassesItem.getQuality());
    }
}
