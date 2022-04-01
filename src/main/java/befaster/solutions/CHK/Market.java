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
    
    public Market() {
        
    }
    
    private class MarketItemBucket {
        private MarketItem marketItem;
        private int number;
    }
}
