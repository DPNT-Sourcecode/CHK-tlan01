/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teodor
 */
public class Market {
    private final List<MarketItemBucket> itemBuckets = new ArrayList<>();
    
    public Market() { }
    
    public boolean itemExists(String itemTag) {
        return itemBuckets.stream()
                .anyMatch(ib -> ib.marketItem.getTag().equals(itemTag));
    }
    
    public void addToExistingItem(String itemTag) {
        
    }
    
    public void registerNewItem(MarketItem newMarketItem) {
        itemBuckets.add(new MarketItemBucket(newMarketItem));
    }
    
    private class MarketItemBucket {
        private MarketItem marketItem;
        private int number;
        
        private MarketItemBucket(MarketItem item) {
            this.marketItem = item;
            this.number = 1; // a new bucket with a single item inside, at first
        }
        
        
    }
}

