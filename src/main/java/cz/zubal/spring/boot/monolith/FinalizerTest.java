public class FinalizerTest {
    
    // This should trigger BP-JAVA-002: AvoidEmptyFinalizerRule
    @Override
    protected void finalize() throws Throwable {
        // Empty finalize method
    }
    
    // Another class with empty finalize
    static class InnerClass {
        @Override  
        protected void finalize() {
            /* Empty finalize with comment only */
        }
    }
    
    // This should NOT trigger the rule (non-empty finalize)
    static class NonEmptyFinalize {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Cleaning up");
        }
    }
} 