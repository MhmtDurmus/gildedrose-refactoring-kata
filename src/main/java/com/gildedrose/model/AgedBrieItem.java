package com.gildedrose.model;

public class AgedBrieItem extends ItemType {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        decreaseSellIn();
        if (item.getSellIn() < 0) {
            increaseQuality();
        }
    }
}
