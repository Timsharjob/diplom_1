package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Mock
    Bun bun;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals(burger.bun, bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertNotEquals(0, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100.13f);
        Mockito.when(ingredient.getPrice()).thenReturn(50f);
        Assert.assertEquals(250.26f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", "Bun"));
        expectedReceipt.append(String.format("= %s %s =%n", "filling", "CosmoMeat"));
        expectedReceipt.append(String.format("(==== %s ====)%n", "Bun"));
        expectedReceipt.append(String.format("%nPrice: %f%n", 250.259995f));
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("CosmoMeat");
        Mockito.when(bun.getPrice()).thenReturn(100.13f);
        Mockito.when(ingredient.getPrice()).thenReturn(50f);
        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
