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
public class MarketItem {
    private final String tag;
    private final int price;
    private final MarketSpecialOffer specialOffer;
    
    public MarketItem(String tag, int price, MarketSpecialOffer specialOffer) {
        this.tag = tag;
        this.price = price;
        this.specialOffer = specialOffer;
    }

    public String getTag() {
        return tag;
    }

    public int getPrice() {
        return price;
    }

    public MarketSpecialOffer getSpecialOffer() {
        return specialOffer;
    }
    
    @Override
    public String toString() {
        return String.format("{%s, %d, %d, %d}", 
                tag, price, specialOffer.getNumberOfItems(), specialOffer.getPriceOffer()
        );
    }

    public MarketItem cloneItem() {
        return new MarketItem(tag, price, specialOffer.cloneOffer());
    }
}
