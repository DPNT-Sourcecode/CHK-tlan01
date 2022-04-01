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
    
    public MarketItem(String tag, int price) {
        this.tag = tag;
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public int getPrice() {
        return price;
    }
    
}

