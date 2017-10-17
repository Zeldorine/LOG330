/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ets.log330.utils;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class SommeDistanceTests extends MathTests {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Override
    public void testNullValue() {

    }

    @Test
    @Override
    public void testEmptyValue() {

    }

    @Test
    @Override
    public void testBorneInferieure() {

    }

    @Test
    @Override
    public void testBorneSuperieure() {
        List<Float> data = new ArrayList<Float>();
        for(int i=0; i<Integer.MAX_VALUE;i++){
            data.add(Float.MIN_VALUE);
        }
        System.out.println("taille: " + data.size());
    }

    @Test
    @Override
    public void testValide() {

    }

    @Test
    @Override
    public void testNotANumberValue() {
    }
}
