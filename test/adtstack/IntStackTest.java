/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtstack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author czoeller
 */
public class IntStackTest {
    
    private IntStack is;
    private int size = 5;
    
    public IntStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.is = new IntStack( this.size );
        this.is.init();
    }
    
    @After
    public void tearDown() {
    }

   /**
    * Test of init method, of class IntStack.
    */
   @Test
   public void testInit() {
       // test on empty stack
       this.is.init();
       assertTrue(this.is.isEmpty());
       
       // test on not empty stack
       this.is.push(1);
       this.is.push(2);
       this.is.init();
       assertTrue(this.is.isEmpty());
   }
    
    /**
     * Test of isEmpty method, of class IntStack.
     */
    @Test
    public void testIsEmpty() { 
        assertTrue( is.isEmpty() );
        is.push(2);
        assertFalse( is.isEmpty() );
        is.push(4);
        assertFalse( is.isEmpty() );
    }

    /**
     * Test of isFull method, of class IntStack.
     */
    @Test
    public void testIsFull() {
        assertFalse( is.isFull() );
        is.push(1);
        assertFalse( is.isFull() );
        is.push(2);
        is.push(3);
        is.push(4);
        is.push(5);
        assertTrue( is.isFull() );
    }

    /**
     * Test of push method, of class IntStack.
     */
    @Test
    public void testPush() {
        this.is.push(1);
        assertEquals( (int) this.is.top(), 1);
        
        // fill the stack up to 5 atoms
        this.is.push(2);
        this.is.push(3);
        this.is.push(4);
        this.is.push(5);
        
        // the stack is full at this moment
        try {
            this.is.push(6);
            fail("Expected an FullStackException to be thrown");
        } catch (FullStackException e) {
            assertThat(e.getMessage(), is("Stack is full."));
        }
    }

    /**
     * Test of pop method, of class IntStack.
     */
    @Test
    public void testPop() {
        // test pop on empty stack
        try {
            this.is.pop();
            fail("Expected an EmptyStackException to be thrown");
        } catch (EmptyStackException e) {
            assertThat(e.getMessage(), is("Stack is empty."));
        }
        
        // test pop on stack with one element
        this.is.push(1);
        try {
            this.is.pop();
        } catch (EmptyStackException e) {
            fail("Expected no EmptyStackException to be thrown");
        }
        assertTrue( this.is.isEmpty() );
         
        // test pop on full stack
        this.is.push(1);
        this.is.push(2);
        this.is.push(3);
        this.is.push(4);
        this.is.push(5);
        
        try {
            this.is.pop();
        } catch (EmptyStackException e) {
            fail("Expected no EmptyStackException to be thrown");
        }
        assertFalse( this.is.isEmpty() );
    }

    /**
     * Test of top method, of class IntStack.
     */
    @Test
    public void testTop() {
        IntStack isCopy = this.is;
        // test top on empty stack
        try {
            this.is.top();
            fail("Expected an EmptyStackException to be thrown");
        } catch (EmptyStackException e) {
            assertThat(e.getMessage(), is("Stack is empty."));
        }
        
        // test top on not empty stack
        try {
            this.is.push(2);
            int expected = 2;
            assertEquals( (int) this.is.top(), expected );
        } catch (EmptyStackException e) {
            fail("Expected no EmptyStackException to be thrown");
        }
        
        // test top on full stack
        // remove the atom from the pevious assert
        this.is.pop();
        // the stack should be empty at this moment
        assertTrue( this.is.isEmpty() );
        try {
            this.is.push(1);
            this.is.push(2);
            this.is.push(3);
            this.is.push(4);
            this.is.push(5);
            int expected = 5;
            assertEquals( (int) this.is.top(), expected );
        } catch (EmptyStackException e) {
            fail("Expected no EmptyStackException to be thrown");
        }
        
        // Assert that the Stack is untouched
        assertEquals(this.is, isCopy);
    }
}
