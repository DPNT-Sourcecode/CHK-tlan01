/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.TST;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Test;

/**
 *
 * @author teodor
 */
public class TestCHK1 {
    @Test
    public void testCHK1() {
        testSkus("A");
        testSkus("B");
        testSkus("C");
        testSkus("D");
//        sol.checkout("x");
//        sol.checkout("AxA");
//        sol.checkout("ABC");
//        sol.checkout("ABBCD");
//        sol.checkout("ABBCD");
//        sol.checkout("AAABBCD");
//        sol.checkout("AABBBBCD");
//        sol.checkout("AAAAAABBCDDDB");
    }
    
    private void testSkus(String skus) {
        CheckoutSolution sol = new CheckoutSolution();
        sol.checkout(skus);
    }
}


