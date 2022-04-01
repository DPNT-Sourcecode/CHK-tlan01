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
public class MarketReductionSpecialOffer {
    private final int numberOfItems;
    private final int priceOffer;

    public MarketReductionSpecialOffer(int numberOfItems, int priceOffer) {
        this.numberOfItems = numberOfItems;
        this.priceOffer = priceOffer;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getPriceOffer() {
        return priceOffer;
    }
    
    public static MarketReductionSpecialOffer emptyOffer() {
        return new MarketReductionSpecialOffer(0, 0);
    }

    public MarketReductionSpecialOffer cloneOffer() {
        return new MarketReductionSpecialOffer(numberOfItems, priceOffer);
    }
    
}
