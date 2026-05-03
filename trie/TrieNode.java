package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single node in the Trie.
 * Each node stores:
 * - children → next possible tokens (words)
 * - eol (end of line) → marks if this node completes a valid name
 */
public class TrieNode {

    // Map of next words → child nodes
    // Example: "ANZ" → node, "AXIS" → node
    Map<String, TrieNode> children = new HashMap<>();

    // True if this node represents end of a valid bank name
    // Example: ANZ → BANK (eol = true means "ANZ BANK" is valid)
    boolean eol = false;
}