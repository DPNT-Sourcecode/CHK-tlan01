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
public class MarketSpecialOffer {
    private final int numberOfItems;
    private final int priceOffer;

    public MarketSpecialOffer(int numberOfItems, int priceOffer) {
        this.numberOfItems = numberOfItems;
        this.priceOffer = priceOffer;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getPriceOffer() {
        return priceOffer;
    }
    
    public static MarketSpecialOffer emptyOffer() {
        return new MarketSpecialOffer(0, 0);
    }

    public MarketSpecialOffer cloneOffer() {
        return new MarketSpecialOffer(numberOfItems, priceOffer);
    }
    
}

