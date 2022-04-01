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
        put("F", new MarketItem("F", 10, new MarketItemFreeSpecialOffer(2, "F")));
    }};
    
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

