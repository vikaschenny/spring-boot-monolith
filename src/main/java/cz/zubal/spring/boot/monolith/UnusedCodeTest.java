public class UnusedCodeTest {
    
    // This should trigger BP-JAVA-011: UnusedPrivateFieldRule
    private static int FOO = 2; // Unused private field
    private int unusedField = 5; // Unused private field
    private String message = "Hello"; // Unused private field
    
    // This field is used, should NOT trigger the rule
    private int usedField = 10;
    
    // This should trigger BP-JAVA-012: UnusedPrivateMethodRule
    private void unusedPrivateMethod() { // Unused private method
        System.out.println("This method is never called");
    }
    
    private int calculateSomething() { // Unused private method
        return 42;
    }
    
    // This method is used, should NOT trigger the rule
    private void usedPrivateMethod() {
        System.out.println("This method is called");
    }
    
    // This should trigger BP-JAVA-016: UnusedFormalParameterRule
    public void methodWithUnusedParams(int unusedParam, String alsoUnused) { // Unused parameters
        System.out.println("Method implementation without using parameters");
    }
    
    public void anotherMethod(int used, int unused) { // One used, one unused parameter
        System.out.println("Using: " + used); // 'unused' parameter is not used
    }
    
    // This should trigger BP-JAVA-017: UnusedLocalVariableAdvancedRule
    public void methodWithUnusedVars() {
        int unusedLocal = 5; // Unused local variable
        String unusedString = "test"; // Unused local variable
        
        // This variable is used, should NOT trigger the rule
        int usedLocal = 10;
        System.out.println(usedLocal);
    }
    
    // This should trigger BP-JAVA-015: UnusedAssignmentRule
    public void methodWithUnusedAssignments() {
        int value = 5; // This assignment is overwritten without being used
        value = 10; // This is the value that's actually used
        System.out.println(value);
        
        String text = "initial"; // Unused assignment - always overwritten
        text = "final";
        System.out.println(text);
    }
    
    public void publicMethod() {
        // Use the private field to avoid triggering unused field rule
        System.out.println(usedField);
        
        // Call the private method to avoid triggering unused method rule
        usedPrivateMethod();
    }
    
    // Field initializer that is always overwritten in constructor
    private int fieldValue = 100; // This should trigger BP-JAVA-015
    
    public UnusedCodeTest() {
        this.fieldValue = 200; // Always overwrites the field initializer
    }
    
    public int getFieldValue() {
        return fieldValue;
    }
} 