import java.util.*;

public class VarargsArrayTest {
    
    // This should trigger BP-JAVA-020: UnnecessaryVarargsArrayCreationRule
    public void testArraysAsList() {
        List<String> list1 = Arrays.asList(new String[]{"foo", "bar", "baz"}); // Should use direct arguments
        List<String> list2 = Arrays.asList(new String[]{"apple", "banana"}); // Should use direct arguments
        List<Integer> numbers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5}); // Should use direct arguments
    }
    
    // This should also trigger BP-JAVA-020
    public void testListOf() {
        List<String> items = List.of(new String[]{"item1", "item2", "item3"}); // Should use direct arguments
        Set<String> tags = Set.of(new String[]{"tag1", "tag2"}); // Should use direct arguments
    }
    
    // This should also trigger BP-JAVA-020
    public void testStringFormat() {
        String message = String.format(new String[]{"Hello %s, you have %d messages"}); // Should use direct arguments
        System.out.printf(new String[]{"Value: %s"}, "test"); // Should use direct arguments
    }
    
    // This should also trigger BP-JAVA-020
    public void testCollectionsAddAll() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, new String[]{"a", "b", "c"}); // Should use direct arguments
        
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, new Integer[]{10, 20, 30}); // Should use direct arguments
    }
    
    // This should also trigger BP-JAVA-020
    public void testEnumSet() {
        EnumSet<Color> colors = EnumSet.of(new Color[]{Color.RED, Color.GREEN}); // Should use direct arguments
    }
    
    // These should NOT trigger the rule (proper varargs usage)
    public void testCorrectUsage() {
        // Correct varargs usage - should NOT trigger rule
        List<String> list1 = Arrays.asList("foo", "bar", "baz");
        List<String> list2 = Arrays.asList("apple", "banana");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        List<String> items = List.of("item1", "item2", "item3");
        Set<String> tags = Set.of("tag1", "tag2");
        
        String message = String.format("Hello %s, you have %d messages", "John", 5);
        System.out.printf("Value: %s", "test");
        
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c");
        
        EnumSet<Color> colors = EnumSet.of(Color.RED, Color.GREEN);
    }
    
    // These should NOT trigger the rule (not varargs methods)
    public void testNonVarargsArrays() {
        // Regular array usage - should NOT trigger rule
        String[] array = new String[]{"not", "varargs"};
        int[] numbers = new int[]{1, 2, 3};
        
        // Array as regular parameter (not varargs)
        processArray(new String[]{"regular", "array", "param"});
    }
    
    private void processArray(String[] array) {
        // Regular method that takes array parameter
        for (String item : array) {
            System.out.println(item);
        }
    }
    
    enum Color {
        RED, GREEN, BLUE
    }
} 