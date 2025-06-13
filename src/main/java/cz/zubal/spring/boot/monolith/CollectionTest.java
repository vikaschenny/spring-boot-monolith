import java.util.*;

public class CollectionTest {
    
    // This should trigger BP-JAVA-003: PreferCollectionIsEmptyRule
    public boolean checkEmpty(List<String> list) {
        return list.size() == 0; // Should use isEmpty()
    }
    
    // This should trigger BP-JAVA-013: UseCollectionIsEmptyAdvancedRule
    public void checkVariousComparisons(Set<Integer> set) {
        if (set.size() != 0) { // Should use !isEmpty()
            System.out.println("Not empty");
        }
        
        if (set.size() > 0) { // Should use !isEmpty()
            System.out.println("Has elements");
        }
        
        if (set.size() < 1) { // Should use isEmpty()
            System.out.println("Empty");
        }
        
        if (0 == set.size()) { // Should use isEmpty()
            System.out.println("Empty");
        }
    }
    
    // This should trigger BP-JAVA-014: UseEnumCollectionsRule
    public void enumCollections() {
        HashSet<Color> colors = new HashSet<>(); // Should use EnumSet
        HashMap<Status, String> statusMap = new HashMap<>(); // Should use EnumMap
    }
    
    enum Color {
        RED, GREEN, BLUE
    }
    
    enum Status {
        ACTIVE, INACTIVE, PENDING
    }
} 