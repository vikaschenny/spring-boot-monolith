import java.util.*;

public class LegacyCollectionsTest {
    
    // This should trigger BP-JAVA-025: ReplaceEnumerationWithIteratorRule
    public void enumerationUsage() {
        Enumeration<String> enumeration; // Should use Iterator instead
        Vector<String> vector = new Vector<>();
        enumeration = vector.elements(); // Legacy enumeration usage
        
        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            System.out.println(element);
        }
    }
    
    // This should also trigger BP-JAVA-025
    public void processEnumeration(Enumeration<Integer> numbers) { // Parameter should use Iterator
        // Process enumeration
        while (numbers.hasMoreElements()) {
            Integer num = numbers.nextElement();
            System.out.println(num);
        }
    }
    
    // This should trigger BP-JAVA-026: ReplaceHashtableWithMapRule
    public void hashtableUsage() {
        Hashtable<String, Integer> table = new Hashtable<>(); // Should use Map/HashMap
        table.put("key1", 42);
        table.put("key2", 84);
        
        Hashtable<String, String> config = new Hashtable<String, String>(); // Should use Map
        config.put("setting", "value");
    }
    
    // This should also trigger BP-JAVA-026
    private Hashtable<String, Object> dataMap; // Field should use Map
    
    public void processHashtable(Hashtable<String, String> params) { // Parameter should use Map
        for (String key : params.keySet()) {
            System.out.println(key + "=" + params.get(key));
        }
    }
    
    // This should trigger BP-JAVA-027: ReplaceVectorWithListRule
    public void vectorUsage() {
        Vector<String> items = new Vector<>(); // Should use List/ArrayList
        items.add("item1");
        items.add("item2");
        items.add("item3");
        
        Vector<Integer> numbers = new Vector<Integer>(); // Should use List
        numbers.add(1);
        numbers.add(2);
    }
    
    // This should also trigger BP-JAVA-027
    private Vector<String> messages; // Field should use List
    
    public void processVector(Vector<Object> data) { // Parameter should use List
        for (Object item : data) {
            System.out.println(item);
        }
    }
    
    // Better approaches - should NOT trigger rules
    public void modernCollections() {
        // Modern replacements - should NOT trigger rules
        Iterator<String> iterator; // Proper Iterator usage
        Map<String, Integer> map = new HashMap<>(); // Proper Map usage
        List<String> list = new ArrayList<>(); // Proper List usage
        
        list.add("modern");
        map.put("key", 100);
        iterator = list.iterator();
        
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
    
    // This should trigger BP-JAVA-028: SimplifiableTestAssertionRule
    @Test
    public void testSimplifiableAssertions() {
        Object a = new Object();
        Object b = new Object();
        String str1 = "hello";
        String str2 = "world";
        
        // These should be simplified
        assertTrue(a.equals(b)); // could be assertEquals(a, b);
        assertTrue(a == null); // could be assertNull(a);
        assertTrue(a != null); // could be assertNotNull(a);
        
        assertFalse(str1.equals(str2)); // could be assertNotEquals(str1, str2);
        assertFalse(a == null); // could be assertNotNull(a);
        assertFalse(a != null); // could be assertNull(a);
        
        assertEquals(true, isValid()); // could be assertTrue(isValid());
        assertEquals(false, isEmpty()); // could be assertFalse(isEmpty());
        assertEquals(null, getObject()); // could be assertNull(getObject());
        
        assertNotEquals(null, getResult()); // could be assertNotNull(getResult());
    }
    
    // Better approaches - should NOT trigger BP-JAVA-028
    @Test
    public void testProperAssertions() {
        Object a = new Object();
        Object b = new Object();
        
        // Proper assertions - should NOT trigger rule
        assertEquals(a, b); // Direct comparison
        assertNull(a); // Direct null check
        assertNotNull(a); // Direct not-null check
        assertTrue(isValid()); // Direct boolean check
        assertFalse(isEmpty()); // Direct boolean check
    }
    
    private boolean isValid() {
        return true;
    }
    
    private boolean isEmpty() {
        return false;
    }
    
    private Object getObject() {
        return null;
    }
    
    private Object getResult() {
        return new Object();
    }
} 