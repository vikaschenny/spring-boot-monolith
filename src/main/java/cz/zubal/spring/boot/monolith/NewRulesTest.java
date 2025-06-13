import java.util.*;

public class NewRulesTest {
    
    // This should trigger BP-JAVA-029: OneDeclarationPerLineRule
    // Multiple variable declarations on the same line - should be separated
    private String name, description; // separate declarations
    private int count, total, max; // separate declarations
    public static final String CONST1 = "value1", CONST2 = "value2"; // separate declarations
    
    // Better approach - should NOT trigger BP-JAVA-029
    private String properName;
    private String properDescription;
    private int properCount;
    private int properTotal;
    
    // This should trigger BP-JAVA-030: PreserveStackTraceRule
    public void handleException() {
        try {
            riskyOperation();
        } catch (IOException e) {
            // Throwing new exception without preserving original stack trace
            throw new RuntimeException("Operation failed"); // Should preserve 'e'
        }
        
        try {
            anotherRiskyOperation();
        } catch (SQLException e) {
            // Another case - not using the caught exception
            throw new IllegalStateException("Database error"); // Should use 'e'
        }
    }
    
    // Better approach - should NOT trigger BP-JAVA-030
    public void handleExceptionProperly() {
        try {
            riskyOperation();
        } catch (IOException e) {
            // Properly preserving stack trace
            throw new RuntimeException("Operation failed", e); // Uses 'e' as cause
        }
        
        try {
            anotherRiskyOperation();
        } catch (SQLException e) {
            // Alternative proper approach
            RuntimeException re = new RuntimeException("Database error");
            re.initCause(e); // Preserves stack trace
            throw re;
        }
    }
    
    // This should trigger BP-JAVA-031: PrimitiveWrapperInstantiationRule
    public void primitiveWrapperUsage() {
        // Deprecated constructor usage - should use valueOf()
        Integer number = new Integer(42); // Should use Integer.valueOf(42)
        Boolean flag = new Boolean(true); // Should use Boolean.valueOf(true)
        Double value = new Double(3.14); // Should use Double.valueOf(3.14)
        Long bigNumber = new Long(1000L); // Should use Long.valueOf(1000L)
        Float decimal = new Float(2.5f); // Should use Float.valueOf(2.5f)
        Character letter = new Character('A'); // Should use Character.valueOf('A')
        Byte smallNumber = new Byte((byte) 10); // Should use Byte.valueOf((byte) 10)
        Short mediumNumber = new Short((short) 100); // Should use Short.valueOf((short) 100)
    }
    
    // Better approach - should NOT trigger BP-JAVA-031
    public void properPrimitiveWrapperUsage() {
        // Modern valueOf() usage
        Integer number = Integer.valueOf(42);
        Boolean flag = Boolean.valueOf(true);
        Double value = Double.valueOf(3.14);
        Long bigNumber = Long.valueOf(1000L);
        Float decimal = Float.valueOf(2.5f);
        Character letter = Character.valueOf('A');
        Byte smallNumber = Byte.valueOf((byte) 10);
        Short mediumNumber = Short.valueOf((short) 100);
        
        // Or even better - auto-boxing (since Java 1.5)
        Integer autoBoxed = 42;
        Boolean autoFlag = true;
        Double autoValue = 3.14;
    }
    
    // Multiple variables on same line in local declarations (BP-JAVA-029)
    public void localVariableDeclarations() {
        int a = 1, b = 2, c = 3; // Should separate these
        String s1 = "hello", s2 = "world"; // Should separate these
        
        // Better approach
        int properA = 1;
        int properB = 2;
        int properC = 3;
    }
    
    // Exception chaining examples for BP-JAVA-030
    public void moreExceptionHandling() {
        try {
            complexOperation();
        } catch (Exception e) {
            // Bad - loses original exception
            throw new IllegalArgumentException("Invalid input");
        }
        
        try {
            anotherComplexOperation();
        } catch (RuntimeException e) {
            // Bad - doesn't reference caught exception
            throw new IllegalStateException("State error");
        }
    }
    
    // Helper methods
    private void riskyOperation() throws IOException {
        throw new IOException("IO Error");
    }
    
    private void anotherRiskyOperation() throws SQLException {
        throw new SQLException("SQL Error");
    }
    
    private void complexOperation() throws Exception {
        throw new Exception("Complex error");
    }
    
    private void anotherComplexOperation() throws RuntimeException {
        throw new RuntimeException("Runtime error");
    }
}

// Test SQL exception class (simplified)
class SQLException extends Exception {
    public SQLException(String message) {
        super(message);
    }
} 