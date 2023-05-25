package base.class03;

/**
 * @author Liang
 * @date 2023/5/25 - 11:35
 */
public class RainArray {

    public static class MyQueue{
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队列满了，不能放入元素");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列已空，不能再抛出元素");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        private int nextIndex(int value) {
            return value < limit - 1 ? value + 1 : 0;
        }
    }
}
