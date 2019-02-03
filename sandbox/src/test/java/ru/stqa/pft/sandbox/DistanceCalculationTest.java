package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceCalculationTest {

    @Test
    //Проверка корректности вычисления
    public void TestDistance(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(4,6);

        Assert.assertEquals(p1.distnance(p2),5);
    }
}
