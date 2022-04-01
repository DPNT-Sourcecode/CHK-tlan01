package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<String, MarketItem> itemForTags = new HashMap<String, MarketItem>(){{
        put("A", new MarketItem("A", 50, new MarketSpecialOffer(3, 130)));
        put("B", new MarketItem("B", 30, new MarketSpecialOffer(2, 45)));
        put("C", new MarketItem("C", 20, null));
        put("D", new MarketItem("D", 15, null));
    }};
    
    private final Market market = new Market();
    
    public Integer checkout(String skus) {
        return -1;
    }

}
