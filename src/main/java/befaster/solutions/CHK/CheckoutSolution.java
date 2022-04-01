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
        put("K", new MarketItem("K", 80, new MarketPriceSpecialOffer(2, 150)));
        put("L", new MarketItem("L", 90, MarketPriceSpecialOffer.emptyOffer()));
        put("M", new MarketItem("M", 15, MarketPriceSpecialOffer.emptyOffer()));
        put("N", new MarketItem("N", 40, new MarketItemFreeSpecialOffer(2, "M")));
        put("O", new MarketItem("O", 10, MarketPriceSpecialOffer.emptyOffer()));
        put("P", new MarketItem("P", 50, new MarketPriceSpecialOffer(5, 200)));
        put("Q", new MarketItem("Q", 30, new MarketPriceSpecialOffer(3, 80)));
        put("R", new MarketItem("R", 50, new MarketItemFreeSpecialOffer(3, "Q")));
        put("S", new MarketItem("S", 30, MarketPriceSpecialOffer.emptyOffer()));
        put("T", new MarketItem("T", 20, MarketPriceSpecialOffer.emptyOffer()));
        put("U", new MarketItem("U", 40, new MarketItemSameFreeSpecialOffer(3)));
        put("V", new MarketItem("V", 50, 
                new MarketPriceSpecialOffer(2, 90),
                new MarketPriceSpecialOffer(3, 130)
        ));
        put("W", new MarketItem("W", 20, MarketPriceSpecialOffer.emptyOffer()));
        put("X", new MarketItem("X", 90, MarketPriceSpecialOffer.emptyOffer()));
        put("Y", new MarketItem("Y", 10, MarketPriceSpecialOffer.emptyOffer()));
        put("Z", new MarketItem("Z", 50, MarketPriceSpecialOffer.emptyOffer()));
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
