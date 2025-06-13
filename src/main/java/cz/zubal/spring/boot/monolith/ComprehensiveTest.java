import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class ComprehensiveTest {
    
    // Constants that should be enums (BP-JAVA-006)
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final int PRIORITY_HIGH = 3;
    
    // Unused private fields (BP-JAVA-011)
    private String unusedMessage = "Never used";
    private int unusedCounter = 0;
    
    // Field that will trigger unused assignment (BP-JAVA-015)
    private double ratio = 0.5; // Always overwritten in constructor
    
    public ComprehensiveTest() {
        this.ratio = 0.75; // Overwrites field initializer
    }
    
    // Empty finalize method (BP-JAVA-002)
    @Override
    protected void finalize() throws Throwable {
        // Empty finalize method
    }
    
    // Method with unused parameters (BP-JAVA-016)
    public void processData(String data, int flags, boolean verbose) {
        // Only uses 'data' parameter, 'flags' and 'verbose' are unused
        System.out.println("Processing: " + data);
    }
    
    // Array parameter that should be varargs (BP-JAVA-008)
    public void printMessages(String[] messages) {
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
    
    // String concatenation in loop (BP-JAVA-001)
    public String buildReport(List<String> items) {
        String report = "Report:\n";
        for (String item : items) {
            report = report + "- " + item + "\n"; // Should use StringBuilder
        }
        return report;
    }
    
    // Collection size comparison (BP-JAVA-003, BP-JAVA-013)
    public boolean validateData(Set<String> dataSet, List<Integer> numbers) {
        if (dataSet.size() == 0) { // Should use isEmpty()
            return false;
        }
        
        if (numbers.size() > 0) { // Should use !isEmpty()
            return true;
        }
        
        return numbers.size() != 0; // Should use !isEmpty()
    }
    
    // Catching generic exception (BP-JAVA-004)
    public void riskyOperation() {
        try {
            performOperation();
        } catch (Exception e) { // Should catch specific exceptions
            e.printStackTrace();
        }
    }
    
    // Deep nesting (BP-JAVA-005)
    public void complexLogic(int value, boolean flag1, boolean flag2) {
        if (value > 0) {
            if (flag1) {
                for (int i = 0; i < value; i++) {
                    if (flag2) {
                        try {
                            if (i % 2 == 0) { // 5+ levels of nesting
                                System.out.println("Complex nested logic");
                            }
                        } catch (RuntimeException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    // Improper resource management (BP-JAVA-007, BP-JAVA-010)
    public void fileOperations() {
        FileInputStream fis = null;
        BufferedReader reader = null;
        
        try {
            fis = new FileInputStream("data.txt"); // Should use try-with-resources
            reader = new BufferedReader(new FileReader("config.txt"));
            
            // Process files
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Manual resource closing - should use try-with-resources
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // StandardCharsets usage (BP-JAVA-009)
    public void charsetOperations() {
        Charset utf8 = Charset.forName("UTF-8"); // Should use StandardCharsets.UTF_8
        Charset ascii = Charset.forName("US-ASCII"); // Should use StandardCharsets.US_ASCII
        
        // Use charsets
        System.out.println("UTF-8: " + utf8.name());
        System.out.println("ASCII: " + ascii.name());
    }
    
    // Enum collections (BP-JAVA-014)
    public void setupCollections() {
        HashSet<Color> colors = new HashSet<>(); // Should use EnumSet
        HashMap<Status, String> statusMap = new HashMap<>(); // Should use EnumMap
        
        colors.add(Color.RED);
        statusMap.put(Status.ACTIVE, "Running");
    }
    
    // Unused local variables and assignments (BP-JAVA-015, BP-JAVA-017)
    public void variableIssues() {
        int unusedVar = 10; // Unused local variable
        String tempStr = "temp"; // Unused assignment - overwritten
        tempStr = "final";
        
        int counter = 0; // Unused assignment - overwritten  
        counter = 5;
        System.out.println("Counter: " + counter);
        
        boolean unusedFlag = true; // Completely unused
    }
    
    // Unused private method (BP-JAVA-012)
    private void helperMethod() {
        System.out.println("This private method is never called");
    }
    
    private void performOperation() throws IOException {
        // Method implementation
    }
    
    public double getRatio() {
        return ratio;
    }
    
    enum Color {
        RED, GREEN, BLUE
    }
    
    enum Status {
        ACTIVE, INACTIVE, PENDING
    }
    
    // New rules added from image
    
    // Unit test annotation issues (BP-JAVA-018, BP-JAVA-019)
    public void setUp() { // Should have @Before annotation (BP-JAVA-018)
        System.out.println("Setup without annotation");
    }
    
    public void testSomething() { // Should have @Test annotation (BP-JAVA-019)
        System.out.println("Test method without @Test annotation - won't run!");
    }
    
    public void testAnotherThing() { // Should have @Test annotation (BP-JAVA-019)
        boolean result = true;
        // This test won't run without @Test annotation
    }
    
    // Unnecessary varargs array creation (BP-JAVA-020)
    public void varargsIssues() {
        // These should trigger BP-JAVA-020
        List<String> list1 = Arrays.asList(new String[]{"foo", "bar"}); // Unnecessary array creation
        List<String> list2 = List.of(new String[]{"item1", "item2"}); // Unnecessary array creation
        String msg = String.format(new String[]{"Hello %s"}, "World"); // Unnecessary array creation
        
        Set<Integer> set = Set.of(new Integer[]{1, 2, 3}); // Unnecessary array creation
        
        List<String> list = new ArrayList<>();
        Collections.addAll(list, new String[]{"a", "b", "c"}); // Unnecessary array creation
    }
    
    // System.out usage (BP-JAVA-021)
    public void debugMethods() {
        System.out.println("Debug message"); // Should use logger (BP-JAVA-021)
        System.err.println("Error message"); // Should use logger (BP-JAVA-021)
        System.out.printf("Value: %s%n", "test"); // Should use logger (BP-JAVA-021)
    }
    
    // Test assertions without messages (BP-JAVA-022)
    @Test
    public void testAssertionsWithoutMessages() {
        assertEquals("foo", "bar"); // Should include message (BP-JAVA-022)
        assertTrue(false); // Should include message (BP-JAVA-022)
        assertNull("not null"); // Should include message (BP-JAVA-022)
    }
    
    // Test with too many assertions (BP-JAVA-023)
    @Test
    public void testWithTooManyAssertions() {
        // This test has too many assertions (exceeds default limit of 5)
        assertEquals("msg1", 1, 1); // 1
        assertTrue("msg2", true);   // 2
        assertFalse("msg3", false); // 3
        assertNotNull("msg4", ""); // 4
        assertNull("msg5", null);   // 5
        assertEquals("msg6", 2, 2); // 6 - exceeds limit (BP-JAVA-023)
        assertTrue("msg7", true);   // 7 - exceeds limit (BP-JAVA-023)
    }
    
    // Test without any assertions (BP-JAVA-024)
    @Test
    public void testWithoutAnyAssertions() {
        // This test method has no assertions - should trigger BP-JAVA-024
        String result = "processed";
        System.out.println(result); // No assertions to verify correctness
    }
    
    // Legacy collections usage (BP-JAVA-025, BP-JAVA-026, BP-JAVA-027)
    public void legacyCollections() {
        Enumeration<String> enumeration; // Should use Iterator (BP-JAVA-025)
        Hashtable<String, Integer> hashtable = new Hashtable<>(); // Should use Map (BP-JAVA-026)
        Vector<String> vector = new Vector<>(); // Should use List (BP-JAVA-027)
        
        hashtable.put("key", 42);
        vector.add("item");
        enumeration = vector.elements();
    }
    
    // Simplifiable test assertions (BP-JAVA-028)
    @Test
    public void testSimplifiableAssertions() {
        Object a = new Object();
        Object b = new Object();
        
        // These assertions can be simplified
        assertTrue(a.equals(b)); // could be assertEquals(a, b) (BP-JAVA-028)
        assertTrue(a == null); // could be assertNull(a) (BP-JAVA-028)
        assertEquals(true, isActive()); // could be assertTrue(isActive()) (BP-JAVA-028)
        assertEquals(null, getValue()); // could be assertNull(getValue()) (BP-JAVA-028)
    }
    
    private boolean isActive() {
        return true;
    }
    
    private Object getValue() {
        return null;
    }
} 