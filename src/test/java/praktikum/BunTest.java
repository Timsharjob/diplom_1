package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Bun", 100.13f);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Bun";
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 100.13f;
        Assert.assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
