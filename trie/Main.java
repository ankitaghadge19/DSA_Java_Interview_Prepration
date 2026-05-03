package trie;

/**
 * Entry point to test Trie functionality
 */
public class Main {

    public static void main(String[] args) {

        // Create Trie instance
        Trie trie = new Trie();

        // Insert bank names into Trie
        trie.insert("ANZ BANK LTD");
        trie.insert("ANZ BANK");
        trie.insert("ANZ BANK CORP Ltd");
        trie.insert("HSBC BANK");

        // Check exact match
        // Should return true (case-insensitive due to uppercase normalization)
        System.out.println(trie.exactMatch("ANZ BANK Ltd"));

        // Search all names starting with prefix "ANZ BANK"
        // Expected output:
        // [ANZ BANK, ANZ BANK LTD, ANZ BANK CORP LTD]
        System.out.println(trie.searchPrefix("ANZ BANK"));
    }
}