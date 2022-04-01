/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author teodor
 */
public class MarketItem {
    private final String tag;
    private final int price;
    private final List<MarketSpecialOffer> specialOffers;
    
    public MarketItem(String tag, int price, MarketSpecialOffer... specialOffers) {
        this(tag, price, Arrays.asList(specialOffers));
    }
    
    public MarketItem(String tag, int price, List<MarketSpecialOffer> specialOffers) {
        this.tag = tag;
        this.price = price;
        this.specialOffers = specialOffers;
    }

    public String getTag() {
        return tag;
    }

    public int getPrice() {
        return price;
    }

    public List<MarketSpecialOffer> getSpecialOffer() {
        return specialOffers;
    }

}



