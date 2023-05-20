package test;

import praktikum.Bun;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.Assert;
import praktikum.Burger;
import org.mockito.Mockito;
import praktikum.Ingredient;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    Bun bun;
    Burger burger = new Burger();
    Ingredient ingredient;

    @Test
    public void testSetBuns() {
        bun = new Bun("Булочка с кунжутом",550f);
        burger.setBuns(bun);
        assertThat("Проверка метода setBuns()",burger.getReceipt(),containsString("Булочка с кунжутом"));
    }

    @Test
    public void testAddIngredient() {
        ingredient = new Ingredient(FILLING, "Хрустящие минеральные кольца", 000f);
        burger.addIngredient(ingredient);
        assertEquals("Проверка метода addIngredient()", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        ingredient = new Ingredient(SAUCE, "HOT", 999f);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Проверка метода removeIngredient()", burger.ingredients.isEmpty());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredientIndexZero = new Ingredient(SAUCE, "PAPERS", 567f);
        Ingredient ingredientIndexOne = new Ingredient(FILLING, "Кристальные минералы", 999f);
        burger.addIngredient(ingredientIndexZero);
        burger.addIngredient(ingredientIndexOne);
        burger.moveIngredient(0,1);
        assertEquals("Проверка метода moveIngredient()", ingredientIndexZero, burger.ingredients.get(1));
    }

    @Mock
    private Bun mockBun;

    @Test
    public void testGetPrice() {
        Mockito.when(mockBun.getPrice()).thenReturn(999f);
        burger.setBuns(mockBun);
        assertEquals("Проверка метода getPrice()",1998f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("MOCK_VALUE");
        burger.setBuns(mockBun);
        ingredient = new Ingredient(SAUCE, "PAPERS", 567f);
        burger.addIngredient(ingredient);
        assertThat("Проверка метода getReceipt()",burger.getReceipt(), containsString("MOCK_VALUE"));
    }
}