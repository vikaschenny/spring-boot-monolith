import java.util.logging.Logger;

public class SystemAndAssertionTest {
    
    private static final Logger log = Logger.getLogger(SystemAndAssertionTest.class.getName());
    
    // This should trigger BP-JAVA-021: SystemPrintlnRule
    public void debuggingMethods() {
        System.out.println("Entering test"); // Should use logger instead
        System.err.println("Error occurred"); // Should use logger instead
        System.out.print("Debug message"); // Should use logger instead
        System.err.print("Error message"); // Should use logger instead
        System.out.printf("Value: %s%n", "test"); // Should use logger instead
        System.err.printf("Error code: %d%n", 404); // Should use logger instead
    }
    
    // Better approach - should NOT trigger BP-JAVA-021
    public void properLogging() {
        log.fine("Entering test"); // Proper logging
        log.warning("Warning occurred"); // Proper logging
        log.info("Information message"); // Proper logging
    }
    
    // This should trigger BP-JAVA-022: UnitTestAssertionsShouldIncludeMessageRule
    @Test
    public void testWithoutMessages() {
        assertEquals("foo", "bar"); // Should include message
        assertTrue(false); // Should include message
        assertNull("not null"); // Should include message
        assertNotEquals(1, 2); // Should include message
    }
    
    // Better approach - should NOT trigger BP-JAVA-022
    @Test
    public void testWithMessages() {
        assertEquals("foo does not equal bar", "foo", "bar"); // Proper message
        assertTrue("should be true", true); // Proper message
        assertNull("should be null", null); // Proper message
        assertNotEquals("should not be equal", 1, 2); // Proper message
    }
    
    // This should trigger BP-JAVA-023: UnitTestContainsTooManyAssertsRule (assuming max=5)
    @Test
    public void testWithTooManyAsserts() {
        boolean myVar1 = false;
        boolean myVar2 = true;
        boolean myVar3 = false;
        boolean myVar4 = true;
        boolean myVar5 = false;
        boolean myVar6 = true;
        boolean myVar7 = false;
        
        assertFalse("var1 should be false", myVar1); // 1
        assertTrue("var2 should be true", myVar2);   // 2
        assertFalse("var3 should be false", myVar3); // 3
        assertTrue("var4 should be true", myVar4);   // 4
        assertFalse("var5 should be false", myVar5); // 5
        assertTrue("var6 should be true", myVar6);   // 6 - exceeds limit
        assertFalse("var7 should be false", myVar7); // 7 - exceeds limit
    }
    
    // Better approach - should NOT trigger BP-JAVA-023
    @Test
    public void testWithFewAsserts() {
        boolean myVar = false;
        assertFalse("should be false", myVar); // Only 1 assert
    }
    
    // This should trigger BP-JAVA-024: UnitTestShouldIncludeAssertRule
    @Test
    public void testWithoutAssertions() {
        // Test method without any assertions - won't actually verify anything!
        String result = processData("input");
        System.out.println(result); // No assertions - test doesn't verify anything
    }
    
    // Another test without assertions - should trigger BP-JAVA-024
    public void testCalculationNoAssert() {
        int result = 2 + 2;
        // Missing assertion: assertEquals("2 + 2 should equal 4", 4, result);
    }
    
    // Better approach - should NOT trigger BP-JAVA-024
    @Test
    public void testWithProperAssertions() {
        String result = processData("input");
        assertNotNull("result should not be null", result); // Proper assertion
        assertEquals("result should match expected", "processed: input", result);
    }
    
    // Edge case: test method using fail() - should NOT trigger BP-JAVA-024
    @Test
    public void testExceptionHandling() {
        try {
            riskyOperation();
            fail("should have thrown exception"); // fail() counts as assertion
        } catch (Exception e) {
            // Expected exception
        }
    }
    
    private String processData(String input) {
        return "processed: " + input;
    }
    
    private void riskyOperation() throws Exception {
        throw new Exception("test exception");
    }
} 