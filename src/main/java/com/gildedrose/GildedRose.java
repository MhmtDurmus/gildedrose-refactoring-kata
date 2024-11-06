package com.gildedrose;

import com.gildedrose.model.AgedBrieItem;
import com.gildedrose.model.BackStagePassesItem;
import com.gildedrose.model.Item;
import com.gildedrose.model.ItemType;
import com.gildedrose.model.NormalItem;
import com.gildedrose.model.SulfurasItem;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemType itemType = createItemType(item);
            itemType.updateQuality();
        }
    }

    private ItemType createItemType(Item item) {
        switch (item.getName()) {
            case AGED_BRIE:
                return new AgedBrieItem(item);
            case SULFURAS_HAND_OF_RAGNAROS:
                return new SulfurasItem(item);
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                return new BackStagePassesItem(item);
            default:
                return new NormalItem(item);
        }
    }
}
