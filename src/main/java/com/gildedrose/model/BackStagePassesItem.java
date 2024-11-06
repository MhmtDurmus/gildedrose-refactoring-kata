package com.gildedrose.model;

public class BackStagePassesItem extends ItemType {

    public BackStagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.getSellIn() > 10) {
            increaseQuality();
        } else if (item.getSellIn() > 5) {
            increaseQuality();
            increaseQuality();
        } else if (item.getSellIn() > 0) {
            increaseQuality();
            increaseQuality();
            increaseQuality();
        } else {
            item.setQuality(0); // Quality drops to 0
        }
        decreaseSellIn();
    }
}
