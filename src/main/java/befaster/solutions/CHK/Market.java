/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
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
        applyFreeItemOffers();
        applyFreeSameItemOffers();
        return itemBuckets.keySet().stream()
                .map(it -> getItemTotalValue(it))
                .reduce(0, (v1,v2) -> v1 + v2);
    }
    
    private void applyFreeSameItemOffers() {
        for(String itemTag : itemBuckets.keySet()) {
            MarketItemBucket itemBucket = itemBuckets.get(itemTag);
            List<MarketItemSameFreeSpecialOffer> itemFreeOffers = getSameItemFreeOffers(itemBucket);
            
            itemFreeOffers.forEach(ifo -> {
                int offerItemNumber = ifo.getNumberOfItems();
                int freeReduction = itemBucket.numberOfItems % (offerItemNumber + 1);
                itemBucket.substractItems(freeReduction);
            });
        }
    }
    
    private void applyFreeItemOffers() {
        for(String itemTag : itemBuckets.keySet()) {
            MarketItemBucket itemBucket = itemBuckets.get(itemTag);
            List<MarketItemFreeSpecialOffer> itemFreeOffers = getItemFreeOffers(itemBucket);
            
            itemFreeOffers.forEach(ifo -> {
                int offerItemNumber = ifo.getNumberOfItems();
                String itemFreeTag = ifo.getItemTag();
                
                if(itemBuckets.containsKey(itemFreeTag) == false) {
                    return;
                }
                
                MarketItemBucket reductionItemBucket = itemBuckets.get(itemFreeTag);
                int freeReduction = itemBucket.numberOfItems / offerItemNumber;
                reductionItemBucket.substractItems(freeReduction);
            });
        }
    }
    
    private Integer getItemTotalValue(String itemTag) {
        MarketItemBucket itemBucket = itemBuckets.get(itemTag);
        int numberOfItems = itemBucket.numberOfItems;
        int itemPrice = itemBucket.marketItem.getPrice();
        
        List<MarketPriceSpecialOffer> specialOffers = getPriceOffers(itemBucket);
        specialOffers.sort((so1, so2) -> so2.getNumberOfItems() - so1.getNumberOfItems());
        
        int totalSpecialOfferValue = 0;
        int remainingItems = numberOfItems;
        for(MarketPriceSpecialOffer specialOffer : specialOffers) {
            int specialOfferValue = 0;
            if(specialOffer.getNumberOfItems() != 0 && remainingItems >= specialOffer.getNumberOfItems()) {
                specialOfferValue = remainingItems / specialOffer.getNumberOfItems() * specialOffer.getPriceOffer();
                remainingItems = remainingItems % specialOffer.getNumberOfItems();
            }
            
            totalSpecialOfferValue += specialOfferValue;
        }
        
        int singleItemsValue = remainingItems * itemPrice;
        return totalSpecialOfferValue + singleItemsValue;
    }
    
    private List<MarketPriceSpecialOffer> getPriceOffers(MarketItemBucket itemBucket) {
        return itemBucket.marketItem.getSpecialOffer().stream()
                .filter(o -> o instanceof MarketPriceSpecialOffer)
                .map(o -> (MarketPriceSpecialOffer) o)
                .collect(Collectors.toList());
    }
    
    private List<MarketItemFreeSpecialOffer> getItemFreeOffers(MarketItemBucket itemBucket) {
        return itemBucket.marketItem.getSpecialOffer().stream()
                .filter(o -> o instanceof MarketItemFreeSpecialOffer)
                .map(o -> (MarketItemFreeSpecialOffer) o)
                .collect(Collectors.toList());
    }
    
    private List<MarketItemSameFreeSpecialOffer> getSameItemFreeOffers(MarketItemBucket itemBucket) {
        return itemBucket.marketItem.getSpecialOffer().stream()
                .filter(o -> o instanceof MarketItemSameFreeSpecialOffer)
                .map(o -> (MarketItemSameFreeSpecialOffer) o)
                .collect(Collectors.toList());
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
        
        private void substractItems(int value) {
            numberOfItems -= value;
        }
        
        @Override
        public String toString() {
            return String.format("[%s, %s]", numberOfItems, marketItem);
        }
    }
}

