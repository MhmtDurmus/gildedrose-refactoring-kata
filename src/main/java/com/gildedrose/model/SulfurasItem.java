package com.gildedrose.model;

public class SulfurasItem extends ItemType {
    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        // "Sulfuras" quality and sellIn do not change
    }
}
