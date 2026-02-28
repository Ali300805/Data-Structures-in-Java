import java.util.LinkedHashMap;
import java.util.Map;

public class RecentSearchCache {
    Map<String, Integer> cache = new LinkedHashMap<>();
    int capacity = 1000;

    public void addSearch(String query) {
        if (cache.containsKey(query)) {
            cache.put(query, cache.get(query) + 1);
        } else {
            if (cache.size() >= capacity) {
                String leastUsedQuery = cache.entrySet().iterator().next().getKey();
                cache.remove(leastUsedQuery);
            }
            cache.put(query, 1);
        }
    }

    public int getSearchCount(String query) {
        return cache.getOrDefault(query, 0);
    }

    public int getCacheSize() {
        return cache.size();
    }

    public java.util.List<String> getQueriesInOrderOfRecency() {
        return new java.util.ArrayList<>(cache.keySet());
    }   

    public static void main(String[] args) {
        RecentSearchCache searchCache = new RecentSearchCache();
        searchCache.addSearch("go");
        searchCache.addSearch("java");
        searchCache.addSearch("python");
        searchCache.addSearch("java");

        System.out.println("Search count for 'java': " + searchCache.getSearchCount("java")); // Output: 2
        System.out.println("Search count for 'python': " + searchCache.getSearchCount("python")); // Output: 1
        System.out.println("Current cache size: " + searchCache.getCacheSize()); // Output: 2
        System.out.println("Queries in order of recency: " + searchCache.getQueriesInOrderOfRecency()); // Output: [go, java, python]   
    }
}