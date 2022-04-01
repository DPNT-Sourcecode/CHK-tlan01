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
public class MarketItemSameFreeSpecialOffer extends MarketSpecialOffer{
    private final String itemTag;
    
    public MarketItemSameFreeSpecialOffer(int numberOfItems, String itemTag) {
        super(numberOfItems);
        this.itemTag = itemTag;
    }

    public String getItemTag() {
        return itemTag;
    }
}
