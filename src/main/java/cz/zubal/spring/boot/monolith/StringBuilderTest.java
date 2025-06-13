public class StringBuilderTest {
    
    // This should trigger BP-JAVA-001: UseStringBuilderRule
    public String buildString() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result = result + "item" + i; // String concatenation in loop
        }
        return result;
    }
    
    // This should also trigger BP-JAVA-001
    public String buildStringWhile() {
        String message = "Hello";
        int count = 0;
        while (count < 5) {
            message += " World"; // String concatenation in while loop
            count++;
        }
        return message;
    }
    
    // This should also trigger BP-JAVA-001
    public String buildStringEnhancedFor() {
        String text = "";
        String[] words = {"one", "two", "three"};
        for (String word : words) {
            text = text + word + " "; // String concatenation in enhanced for loop
        }
        return text;
    }
} 