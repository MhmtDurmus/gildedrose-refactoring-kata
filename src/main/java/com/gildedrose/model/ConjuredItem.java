package com.gildedrose.model;

public class ConjuredItem extends ItemType {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        decreaseQuality();
        decreaseSellIn();
        if (item.getSellIn() < 0) {
            decreaseQuality();
            decreaseQuality();
        }
    }
}
