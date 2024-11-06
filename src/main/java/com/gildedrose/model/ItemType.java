package com.gildedrose.model;

public abstract class ItemType {

    protected Item item;

    ItemType(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    protected void decreaseSellIn() {
        item.setSellIn(item.getSellIn() - 1);
    }

    protected void increaseQuality() {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    protected void decreaseQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
