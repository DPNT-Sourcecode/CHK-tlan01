package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<String, MarketItem> ITEMS_FOR_TAGS = new HashMap<String, MarketItem>(){{
        put("A", new MarketItem("A", 50, new MarketSpecialOffer(3, 130)));
        put("B", new MarketItem("B", 30, new MarketSpecialOffer(2, 45)));
        put("C", new MarketItem("C", 20, null));
        put("D", new MarketItem("D", 15, null));
    }};
    
    private final Market market = new Market();
    
    public Integer checkout(String skus) {
        boolean itemsProcessed = processItems(skus);
        if(!itemsProcessed) {
            return -1;
        }
        
        // TO DO - price calculation
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
}


