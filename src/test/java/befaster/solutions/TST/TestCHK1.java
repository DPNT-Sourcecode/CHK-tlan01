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
        testSkus("A", 1);
        testSkus("B", 1);
        testSkus("C", 1);
        testSkus("D", 1);
        testSkus("x", 1);
        testSkus("AxA", 1);
        testSkus("ABC", 1);
        testSkus("ABBCD", 1);
        testSkus("ABBCD", 1);
        testSkus("AAABBCD", 1);
        testSkus("AABBBBCD", 1);
        testSkus("AAAAAABBCDDDB", 1);
    }
    
    private void testSkus(String skus, int expectedValue) {
        CheckoutSolution sol = new CheckoutSolution();
        int value = sol.checkout(skus);
        System.out.println("test");
    }
}

