package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<String, MarketItem> ITEMS_FOR_TAGS = new HashMap<String, MarketItem>(){{
        put("A", new MarketItem("A", 50, 
                new MarketPriceSpecialOffer(3, 130),
                new MarketPriceSpecialOffer(5, 200)
        ));
        put("B", new MarketItem("B", 30, new MarketPriceSpecialOffer(2, 45)));
        put("C", new MarketItem("C", 20, MarketPriceSpecialOffer.emptyOffer()));
        put("D", new MarketItem("D", 15, MarketPriceSpecialOffer.emptyOffer()));
        put("E", new MarketItem("E", 40, new MarketItemFreeSpecialOffer(2, "B")));
        put("F", new MarketItem("F", 10, new MarketItemSameFreeSpecialOffer(2)));
        put("G", new MarketItem("G", 20, MarketPriceSpecialOffer.emptyOffer()));
        put("H", new MarketItem("H", 10, 
                new MarketPriceSpecialOffer(5, 45),
                new MarketPriceSpecialOffer(10, 80)
        ));
        put("I", new MarketItem("I", 35, MarketPriceSpecialOffer.emptyOffer()));
        put("J", new MarketItem("J", 60, MarketPriceSpecialOffer.emptyOffer()));
    }};
    
    /**
| J    | 60    |                        |
| K    | 80    | 2K for 150             |
| L    | 90    |                        |
| M    | 15    |                        |
| N    | 40    | 3N get one M free      |
| O    | 10    |                        |
| P    | 50    | 5P for 200             |
| Q    | 30    | 3Q for 80              |
| R    | 50    | 3R get one Q free      |
| S    | 30    |                        |
| T    | 20    |                        |
| U    | 40    | 3U get one U free      |
| V    | 50    | 2V for 90, 3V for 130  |
| W    | 20    |                        |
| X    | 90    |                        |
| Y    | 10    |                        |
| Z    | 50    |                        |
+------+-------+------------------------+
     */
    
    private Market market;
    
    public Integer checkout(String skus) {
        market = new Market();
        
        boolean itemsProcessed = processItems(skus);
        if(!itemsProcessed) {
            return -1;
        }
        
        return getMarketValue(); // for now
    }
    
    private boolean processItems(String skus) {
        for(int i = 0; i < skus.length(); i++) {
            if(processItem(skus.charAt(i) + "") == false) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean processItem(String itemTag) {
        if(ITEMS_FOR_TAGS.containsKey(itemTag) == false) {
            return false;
        }
        
        market.addItem(itemTag, ITEMS_FOR_TAGS.get(itemTag));
        return true;
    }
    
    private Integer getMarketValue() {
        return market.getMarketValue();
    }
}

