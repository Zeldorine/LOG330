package ets.log330.utils;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Zeldorine
 */
public class StudentValueTest extends MathTests {

    @Test
    @Override
    public void testNullValue() {
        assertEquals(null, StudentValue.getStudentValue(60, 80));
        assertEquals(null, StudentValue.getStudentValue(70, 10));
        assertEquals(null, StudentValue.getStudentValue(90, 10));
    }

    @Test
    @Override
    public void testNotANumberValue() {
        assertEquals(null, StudentValue.getStudentValue(-1111, 80));
        assertEquals(null, StudentValue.getStudentValue(70, -1111));
        assertEquals(null, StudentValue.getStudentValue(90, -1111));
    }

    @Test
    @Override
    public void testBorneInferieure() {
        assertEquals(null, StudentValue.getStudentValue(Integer.MIN_VALUE, 80));
        assertEquals(null, StudentValue.getStudentValue(70, Integer.MIN_VALUE));
        assertEquals(null, StudentValue.getStudentValue(90, Integer.MIN_VALUE));
    }

    @Test
    @Override
    public void testBorneSuperieure() {
        assertEquals(null, StudentValue.getStudentValue(Integer.MAX_VALUE, 80));
        assertEquals(null, StudentValue.getStudentValue(70, Integer.MAX_VALUE));
        assertEquals(null, StudentValue.getStudentValue(90, Integer.MAX_VALUE));
    }

    @Test
    @Override
    public void testValide() {
        assertEquals(new Double(1.108), StudentValue.getStudentValue(70, 8));
        assertEquals(new Double(1.860), StudentValue.getStudentValue(90, 8));
    }

    @Override
    public void testEmptyValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
