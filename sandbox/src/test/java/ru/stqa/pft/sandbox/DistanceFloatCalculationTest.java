package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceFloatCalculationTest {

    @Test
    //Проверка корректности вычисления
    public void TestDistance(){
        Point p1 = new Point(1.144,2.071);
        Point p2 = new Point(4.38,6.97);

        Assert.assertEquals(p1.distnance(p2),5.871277288631494);
    }
}
