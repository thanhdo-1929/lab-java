/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class DataInputTest {
    
    public DataInputTest() {
    }
    
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

    /**
     * Test of inputInt method, of class DataInput.
     */
    @Test
    public void testInputInt() {
        System.out.println("inputInt");
        int min = 1;
        int max = 4;
        String err = "1";
        DataInput instance = new DataInput();
        int expResult = 1;
        int result = instance.inputInt(min, max, err);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputString method, of class DataInput.
     */
    @Test
    public void testInputString() {
        System.out.println("inputString");
        DataInput instance = new DataInput();
        String expResult = "";
        String result = instance.inputString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputDouble method, of class DataInput.
     */
    @Test
    public void testInputDouble() {
        System.out.println("inputDouble");
        double min = 0.0;
        double max = 0.0;
        String err = "";
        DataInput instance = new DataInput();
        double expResult = 0.0;
        double result = instance.inputDouble(min, max, err);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputDate method, of class DataInput.
     */
    @Test
    public void testInputDate() {
        System.out.println("inputDate");
        DataInput instance = new DataInput();
        String expResult = "";
        String result = instance.inputDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
