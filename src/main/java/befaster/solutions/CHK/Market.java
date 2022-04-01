/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author teodor
 */
public class Market {
    private final Map<String, MarketItemBucket> itemBuckets = new HashMap<>();
    
    public Market() { }
    
    public boolean itemExists(String itemTag) {
        return itemBuckets.containsKey(itemTag);
    }
    
    public void addToExistingItem(String itemTag) {
        if(itemBuckets.containsKey(itemTag)) {
            itemBuckets.get(itemTag).incrementNumberOfItems();
        }
    }
    
    public void addItem(String itemTag, MarketItem newMarketItem) {
        if(itemBuckets.containsKey(itemTag)) {
            itemBuckets.get(itemTag).incrementNumberOfItems();
        } else {
            itemBuckets.put(itemTag, new MarketItemBucket(newMarketItem));
        }
    }
    
    public Integer getMarketValue() {
        return itemBuckets.keySet().stream()
                .map(it -> getItemTotalValue(it))
                .reduce(0, (v1,v2) -> v1 + v2);
    }
    
    private Integer getItemTotalValue(String itemTag) {
        MarketItemBucket itemBucket = itemBuckets.get(itemTag);
        int numberOfItems = itemBucket.numberOfItems;
        int itemsForSpecialOffer = itemBucket.marketItem.getSpecialOffer().getNumberOfItems();
        int itemPrice = itemBucket.marketItem.getPrice();
        int speciafOfferPrice = itemBucket.marketItem.getSpecialOffer().getPriceOffer();
        
        if(numberOfItems < itemsForSpecialOffer || itemsForSpecialOffer == 0) {
            return numberOfItems * itemPrice;
        }
        
        if(numberOfItems == itemsForSpecialOffer) {
            return speciafOfferPrice;
        }
        
        int specialOfferValue = (numberOfItems / itemsForSpecialOffer) * speciafOfferPrice;
        int singleItemsValue = (numberOfItems % itemsForSpecialOffer) * itemPrice;
        
        return specialOfferValue + singleItemsValue;
    }
    
    @Override
    public String toString() {
        return itemBuckets.keySet().stream()
                .map(it -> String.format(
                                "%s -> %s", 
                                it, itemBuckets.get(it).toString())
                ).collect(Collectors.joining("\n"));
    }
    
    private class MarketItemBucket {
        private final MarketItem marketItem;
        private int numberOfItems;
        
        private MarketItemBucket(MarketItem item) {
            this.marketItem = item;
            this.numberOfItems = 1; // a new bucket with a single item inside, at first
        }
        
        private void incrementNumberOfItems() {
            numberOfItems++;
        }
        
        @Override
        public String toString() {
            return String.format("[%s, %s]", numberOfItems, marketItem);
        }
    }
}



