public class StructureTest {
    
    // This should trigger BP-JAVA-006: UseEnumsInsteadOfConstantsRule
    public static final int STATUS_ACTIVE = 1;
    public static final int STATUS_INACTIVE = 2;
    public static final int STATUS_PENDING = 3;
    public static final int STATUS_CANCELLED = 4; // Multiple int constants - should use enum
    
    public static final String ERROR_NOT_FOUND = "NOT_FOUND";
    public static final String ERROR_INVALID = "INVALID";
    public static final String ERROR_TIMEOUT = "TIMEOUT"; // Multiple String constants - should use enum
    
    // This should trigger BP-JAVA-005: AvoidDeepNestingRule
    public void deeplyNestedMethod(int value, boolean condition1, boolean condition2) {
        if (value > 0) {
            if (condition1) {
                for (int i = 0; i < 10; i++) {
                    if (condition2) {
                        try {
                            if (i % 2 == 0) { // Deep nesting - 5+ levels
                                System.out.println("Deep nesting detected");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    // This should trigger BP-JAVA-008: UseVarargsRule
    public void processArray(String[] items) { // Should use String... items
        for (String item : items) {
            System.out.println(item);
        }
    }
    
    public void processNumbers(int[] numbers) { // Should use int... numbers
        for (int num : numbers) {
            System.out.println(num);
        }
    }
    
    // Constructor with array parameter - should trigger BP-JAVA-008
    public StructureTest(String[] args) { // Should use String... args
        // Constructor implementation
    }
    
    // This should NOT trigger varargs rule (main method exception)
    public static void main(String[] args) {
        // Main method - should be ignored
    }
    
    // This should NOT trigger varargs rule (byte array exception)
    public void processBytes(byte[] data) {
        // Byte array - should be ignored
    }
} 