package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Trie {

    // Root node of Trie (empty node, starting point)
    private TrieNode root = new TrieNode();

    /**
     * Insert a bank name into Trie.
     * Example: "ANZ BANK LTD" → [ANZ, BANK, LTD]
     * Each token becomes one level in the tree.
     */
    public void insert(String name) {
        String[] tokens = tokenize(name);
        TrieNode current = root;

        // Traverse / create nodes for each token
        for (String token : tokens) {
            // If token not present, create new node
            current.children.putIfAbsent(token, new TrieNode());

            // Move pointer to next node
            current = current.children.get(token);
        }

        // Mark end of a valid bank name
        current.eol = true;
    }

    /**
     * Check if exact bank name exists.
     * Returns true only if full path exists AND marked as end (eol).
     */
    public boolean exactMatch(String name) {
        String[] tokens = tokenize(name);

        // Traverse till last token
        TrieNode node = traverse(tokens);

        // Valid only if node exists AND is marked as end
        return node != null && node.eol;
    }

    /**
     * Return all bank names starting with given prefix.
     * Example: "ANZ BANK" →
     * [ANZ BANK, ANZ BANK LTD, ANZ BANK CORP]
     */
    public List<String> searchPrefix(String prefix) {
        String[] tokens = tokenize(prefix);

        // Reach node where prefix ends
        TrieNode node = traverse(tokens);

        List<String> result = new ArrayList<>();

        // If prefix not found, return empty list
        if (node == null)
            return result;

        // Start DFS from this node to collect all names
        collect(node, new ArrayList<>(Arrays.asList(tokens)), result);

        return result;
    }

    /**
     * DFS traversal to collect all possible names from current node.
     * 
     * path = current words collected (like ["ANZ", "BANK"])
     * result = final list of full names
     */
    private void collect(TrieNode node, List<String> path, List<String> result) {

        // If this node marks end of a valid name → save it
        if (node.eol) {
            result.add(String.join(" ", path));
        }

        // Traverse all children (next possible words)
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {

            // Choose: add current token to path
            path.add(entry.getKey());

            // Explore: go deeper
            collect(entry.getValue(), path, result);

            // Backtrack: remove last token before exploring next branch
            path.remove(path.size() - 1);
        }
    }

    /**
     * Traverse Trie using given tokens.
     * Returns last node if path exists, else null.
     */
    private TrieNode traverse(String[] tokens) {
        TrieNode current = root;

        for (String token : tokens) {

            // If token not found → path doesn't exist
            if (!current.children.containsKey(token)) {
                return null;
            }

            // Move to next node
            current = current.children.get(token);
        }

        return current;
    }

    /**
     * Normalize input:
     * - Convert to uppercase
     * - Remove extra spaces
     * - Split into tokens (words)
     */
    private String[] tokenize(String input) {
        return input.toUpperCase().trim().split("\\s+");
    }
}