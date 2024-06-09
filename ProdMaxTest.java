package tools;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProdMaxTest {

    @Test
    public void testFindMaxProductPair() {
        int[] numbers = { -1, -3, -4, 2, 0, -5 };
        int[] maxProductPair1 = ProdMax.findMaxProductPair(numbers);
        Assert.assertArrayEquals(new int[] { -4, -5 }, maxProductPair1);

    }
}