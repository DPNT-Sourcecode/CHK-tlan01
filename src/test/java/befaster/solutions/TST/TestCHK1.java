/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.TST;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
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
        testSkus("ABBCD", 115);
        testSkus("AAABBCD", 210);
        testSkus("AABBBBCD", 195);
        testSkus("AAAAAABBCDDDB", 240);
    }
    
    private void testSkus(String skus, int expectedValue) {
        CheckoutSolution sol = new CheckoutSolution();
        int value = sol.checkout(skus);
        
        Assert.assertEquals(value, expectedValue);
    }
}



