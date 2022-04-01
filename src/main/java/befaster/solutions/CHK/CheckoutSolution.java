package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<String, MarketItem> ITEMS_FOR_TAGS = new HashMap<String, MarketItem>(){{
        put("A", new MarketItem("A", 50, 
                new MarketSpecialOffer(3, 130),
                new MarketSpecialOffer(5, 200)
        ));
        put("B", new MarketItem("B", 30, new MarketSpecialOffer(2, 45)));
        put("C", new MarketItem("C", 20, MarketSpecialOffer.emptyOffer()));
        put("D", new MarketItem("D", 15, MarketSpecialOffer.emptyOffer()));
        put("E", new MarketItem("E", 40, new MarketSpecialOffer(2, -30))); // one B for free
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
        
        market.addItem(itemTag, ITEMS_FOR_TAGS.get(itemTag).cloneItem());
        return true;
    }
    
    private Integer getMarketValue() {
        return market.getMarketValue();
    }
}

