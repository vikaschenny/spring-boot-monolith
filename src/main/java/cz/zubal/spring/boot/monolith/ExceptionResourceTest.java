import java.io.*;
import java.nio.charset.Charset;

public class ExceptionResourceTest {
    
    // This should trigger BP-JAVA-004: AvoidCatchingGenericExceptionRule
    public void catchGenericException() {
        try {
            doSomething();
        } catch (Exception e) { // Should catch specific exceptions
            e.printStackTrace();
        }
    }
    
    // This should trigger BP-JAVA-007: UseProperResourceManagementRule
    public void improperResourceManagement() {
        FileInputStream fis = new FileInputStream("test.txt"); // Should use try-with-resources
        BufferedReader reader = new BufferedReader(new FileReader("data.txt")); // Should use try-with-resources
    }
    
    // This should trigger BP-JAVA-009: UseStandardCharsetsRule
    public void charsetUsage() {
        Charset utf8 = Charset.forName("UTF-8"); // Should use StandardCharsets.UTF_8
        Charset ascii = Charset.forName("US-ASCII"); // Should use StandardCharsets.US_ASCII
        Charset iso = Charset.forName("ISO-8859-1"); // Should use StandardCharsets.ISO_8859_1
    }
    
    // This should trigger BP-JAVA-010: UseTryWithResourcesRule
    public void oldResourcePattern() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test.txt");
            // Do something with fis
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close(); // Should use try-with-resources instead
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void doSomething() throws IOException {
        // Method implementation
    }
} 