package base.class07;

import base.class06.Heap;
import com.sun.beans.editors.IntegerEditor;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author Liang
 * @date 2023/6/3 - 9:59
 */
public class HeapGreater<T> {
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;// 记录数据在堆上得什么位置
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> c){
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public int size(){
        return heapSize;
    }

    public boolean contains(T obj){
        return indexMap.containsKey(obj);
    }

    public T peek(){
        return heap.get(0);
    }

    public void push (T obj){
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    private void heapInsert(int index) {
        T o1 = heap.get(index);
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0){
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public T pop(){
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T obj){
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if(obj != replace){
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int best = left + 1 < heapSize && comp.compare(heap.get(left), heap.get(left + 1)) > 0 ? left + 1 : left;
            best = comp.compare(heap.get(index), heap.get(best)) > 0 ? best : index;
            if(best == index){
                break;
            }
            swap(best, index);
            index = best;
            left = index * 2 + 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);

    }


    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for(T c : heap){
            ans.add(c);
        }
        return ans;
    }
}
