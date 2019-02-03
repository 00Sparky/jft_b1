package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
//Проверка корректной обработки нулевого значения
public class DistanceZeroCalculationTest {
    public void ZeroDistanceTest(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);

        Assert.assertEquals(p1.distnance(p2),0);
}

}
