package com.gildedrose.model;

public class NormalItem extends ItemType {

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        decreaseSellIn();
        if (item.getSellIn() < 0) {
            decreaseQuality();
        }
    }
}
