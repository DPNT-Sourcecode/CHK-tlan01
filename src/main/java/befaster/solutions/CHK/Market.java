/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.ArrayList;
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
        return itemBuckets.keySet().stream()
                .map(it -> getItemTotalValue(it))
                .reduce(0, (v1,v2) -> v1 + v2);
    }
    
    private Integer getItemTotalValue(String itemTag) {
        MarketItemBucket itemBucket = itemBuckets.get(itemTag);
        int numberOfItems = itemBucket.numberOfItems;
        int itemPrice = itemBucket.marketItem.getPrice();
        
        List<MarketSpecialOffer> specialOffers = new ArrayList<>(itemBucket.marketItem.getSpecialOffer());
        
        
        int singleItemsValue = remainingItems * itemPrice;
        return totalSpecialOfferValue + singleItemsValue;
    }
    
    private PriceOfferComputationValue computeSpecialOfferPriceValue(List<MarketPriceSpecialOffer> priceOffers, int numberOfItems) {
        priceOffers.sort((so1, so2) -> so2.getNumberOfItems() - so1.getNumberOfItems());
        
        int totalSpecialOfferValue = 0;
        int remainingItems = numberOfItems;
        for(MarketPriceSpecialOffer priceOffer : priceOffers) {
            int specialOfferValue = 0;
            if(priceOffer.getNumberOfItems() != 0 && remainingItems >= priceOffer.getNumberOfItems()) {
                specialOfferValue = remainingItems / priceOffer.getNumberOfItems() * priceOffer.getPriceOffer();
                remainingItems = remainingItems % priceOffer.getNumberOfItems();
            }
            
            totalSpecialOfferValue += specialOfferValue;
        }
        
        return new PriceOfferComputationValue(remainingItems, totalSpecialOfferValue);
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
    
    private class PriceOfferComputationValue {
        private final int remainingItems;
        private final int offerValue;

        public PriceOfferComputationValue(int remainingItems, int offerValue) {
            this.remainingItems = remainingItems;
            this.offerValue = offerValue;
        }
    }
}






