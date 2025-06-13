import java.util.*;

public class UnitTestAnnotationTest {
    
    // This should trigger BP-JAVA-018: UnitTestShouldUseBeforeAnnotationRule
    public void setUp() {
        // Setup method without @Before annotation
        System.out.println("Setting up test");
    }
    
    // This should also trigger BP-JAVA-018
    protected void setUp() {
        // Another setup method without annotation
        System.out.println("Another setup");
    }
    
    // This should trigger BP-JAVA-019: UnitTestShouldUseTestAnnotationRule
    public void testValidation() {
        // Test method without @Test annotation - won't run!
        System.out.println("Testing validation");
    }
    
    // This should also trigger BP-JAVA-019
    public void testCalculation() {
        // Another test method without @Test annotation
        int result = 2 + 2;
        // assert result == 4; // This test won't run!
    }
    
    // This should also trigger BP-JAVA-019
    public void testSomethingElse() {
        // Test method starting with 'test' but no annotation
        boolean isValid = true;
        // assert isValid; // Won't run!
    }
    
    // These should NOT trigger the rules (properly annotated)
    
    @Before
    public void setUpWithAnnotation() {
        // Properly annotated setup method
        System.out.println("Setup with @Before annotation");
    }
    
    @BeforeEach
    public void setUpJUnit5() {
        // JUnit 5 setup method
        System.out.println("Setup with @BeforeEach annotation");
    }
    
    @Test
    public void testWithAnnotation() {
        // Properly annotated test method
        System.out.println("Test with @Test annotation");
    }
    
    @RepeatedTest(5)
    public void testRepeated() {
        // JUnit 5 repeated test
        System.out.println("Repeated test");
    }
    
    @ParameterizedTest
    public void testParameterized() {
        // JUnit 5 parameterized test
        System.out.println("Parameterized test");
    }
    
    // These should NOT trigger rules (not test methods)
    public void regularMethod() {
        // Regular method, not a test
        System.out.println("Regular method");
    }
    
    public void validateData() {
        // Method not starting with 'test'
        System.out.println("Validate data");
    }
} 