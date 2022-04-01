/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

/**
 *
 * @author teodor
 */
public class MarketPriceSpecialOffer extends MarketSpecialOffer{
    private final int priceOffer;

    public MarketPriceSpecialOffer(int numberOfItems, int priceOffer) {
        super(numberOfItems);
        this.priceOffer = priceOffer;
    }

    public int getPriceOffer() {
        return priceOffer;
    }
    
    public static MarketPriceSpecialOffer emptyOffer() {
        return new MarketPriceSpecialOffer(0, 0);
    }

    public MarketPriceSpecialOffer cloneOffer() {
        return new MarketPriceSpecialOffer(numberOfItems, priceOffer);
    }
    
}
