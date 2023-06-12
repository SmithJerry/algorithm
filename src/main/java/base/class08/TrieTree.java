package base.class08;

/**
 * @author Liang
 * @date 2023/6/3 - 17:22
 */
public class TrieTree {
    class Trie{
        class Node{
            public int pass;
            public int end;
            public Node[] nexts;

            public Node(){
                pass = 0;
                end = 0;
                nexts = new Node[26];
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] str = word.toCharArray();
            Node node = root;
            node.pass++;
            int path = 0;
            for(int i = 0; i < str.length; i++){
                path = str[i] - 'a';
                if(node.nexts[path] == null){
                    node.nexts[path] = new Node();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word){
            if(countWordsEqualTo(word) != 0){
                char[] chs = word.toCharArray();
                Node node = root;
                node.pass--;
                int path = 0;
                for(int i = 0; i < chs.length; i++){
                    path = chs[i] - 'a';
                    if(--node.nexts[path].pass == 0){
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        private int countWordsEqualTo(String word) {
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            Node node = root;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
    }


}
