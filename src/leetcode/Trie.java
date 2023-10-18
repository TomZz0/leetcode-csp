package leetcode;

/**
 * @author wzh
 * @date 2023年10月10日 14:44
 * Description: dictionary tree
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public void insert(String word){
        int n = word.length();
        Trie node = this;
        for (int i=0;i<n;i++){
            char ch = word.charAt(i);
            int index = ch-'a';
            if (node.children[index] == null) node.children[index] = new Trie();
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
