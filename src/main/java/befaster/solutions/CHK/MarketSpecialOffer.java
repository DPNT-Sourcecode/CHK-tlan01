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
    private final MarketItem item;
    private final int numberOfItems;
    private final int priceOffer;

    public MarketSpecialOffer(MarketItem item, int numberOfItems, int priceOffer) {
        this.item = item;
        this.numberOfItems = numberOfItems;
        this.priceOffer = priceOffer;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getPriceOffer() {
        return priceOffer;
    }
    
}
