import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductTags {
    private static final int MIN_TAGS = 5;
    private static final int MAX_TAGS = 30;

    private Map<String, Set<String>> productTags = new HashMap<>();

    public boolean addTag(String productId, String tag) {
        Set<String> tags = productTags.computeIfAbsent(productId, k -> new LinkedHashSet<>());
        
        if (tags.size() >= MAX_TAGS) {
            System.out.println("Cannot add tag: maximum " + MAX_TAGS + " tags reached");
            return false;
        }
        
        if (tags.add(tag)) {
            System.out.println("Added tag '" + tag + "' to product " + productId);
            return true;
        }
        System.out.println("Tag '" + tag + "' already exists for product " + productId);
        return false;
    }
    
    public Set<String> getTags(String productId) {
        return productTags.getOrDefault(productId, new LinkedHashSet<>());
    }

    public List<String> filterProductsByTag(String tag) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : productTags.entrySet()) {
            if (entry.getValue().contains(tag)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public boolean hasMinimumTags(String productId) {
        return getTags(productId).size() >= MIN_TAGS;
    }

    public static void main(String[] args) {
        ProductTags store = new ProductTags();
        
        store.addTag("PROD-001", "electronics");
        store.addTag("PROD-001", "smartphone");
        store.addTag("PROD-001", "electronics"); // Duplicate - ignored
        store.addTag("PROD-002", "electronics");
        store.addTag("PROD-002", "laptop");
        
        System.out.println("\nTags for PROD-001: " + store.getTags("PROD-001"));
        System.out.println("Products with 'electronics': " + store.filterProductsByTag("electronics"));
    }
}
