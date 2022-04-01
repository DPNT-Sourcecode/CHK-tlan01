/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.TST;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author teodor
 */
public class TestCHK1 {
    @Test
    public void testCHK1() {
        testSkus("A", 50);
        testSkus("B", 30);
        testSkus("C", 20);
        testSkus("D", 15);
        testSkus("x", -1);
        testSkus("AxA", -1);
        testSkus("ABC", 100);
        testSkus("ABBCD", 130);
        testSkus("AAABBCD", 210);
        testSkus("AABBBBCD", 225);
        testSkus("AAAAAABBCDDDB", 390);
    }
    
    @Test
    public void testCHK2() {
        testSkus("E", 40);
        testSkus("EE", 80);
        testSkus("EEE", 120);
        testSkus("AAAEE", 210);
        testSkus("BBBEE", 125);
        testSkus("EEEEBB", 160);
        testSkus("BEBEEE", 160);
        testSkus("ABCDEABCDE", 280);
    }
    
    @Test
    public void testCHK3() {
        testSkus("AAAAA", 200);
        testSkus("AAAAAAAA", 330);
        testSkus("AAAAAAAAA", 380);
    }
    
    @Test
    public void testCHK4() {
        testSkus("F", 10);
        testSkus("FF", 20);
        testSkus("FFF", 20);
    }
    
    private void testSkus(String skus, int expectedValue) {
        CheckoutSolution sol = new CheckoutSolution();
        int value = sol.checkout(skus);
        
        Assert.assertEquals(value, expectedValue);
    }
}





