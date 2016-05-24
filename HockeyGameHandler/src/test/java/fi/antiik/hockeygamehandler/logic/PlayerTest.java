/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.antiik.hockeygamehandler.logic;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    Player kalle;
    
    public PlayerTest() {          
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         kalle = new Player("Kalle");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void goalsAreCorrect(){
            kalle.setGoalsFor(100);      
        assertEquals(100, kalle.getGoalsFor());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
