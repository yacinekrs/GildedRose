package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items ) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")){
                return;
            }
            switch (item.name) {
                case"Aged Brie":
                    item.quality ++;
                    if (item.sellIn < 0) {
                        item.quality ++;
                    }   
                    break;
                case"Backstage passes to a TAFKAL80ETC concert":
                    item.quality ++ ;
                    if (item.sellIn < 10) {
                        item.quality ++ ;
                    }
                    if (item.sellIn < 5) {
                        item.quality ++ ;
                    }
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }   
                    break;
            
                default:
                    item.quality--;
                    if (item.sellIn < 0) {
                        item.quality--;
                    }
                    break;
            }
            if (item.quality > 50){
                item.quality = 50;
            }
            if (item.quality < 0){
                item.quality = 0;
            }
    }
}
}