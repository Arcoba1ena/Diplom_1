package test;

import praktikum.Bun;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void testGetName() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 950f);
        assertEquals("Проверка метода getName()","Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("Краторная булка N-200i", 1059f);
        assertEquals("Проверка метода getPrice()",1059f, bun.getPrice(), 0.001);
    }
}