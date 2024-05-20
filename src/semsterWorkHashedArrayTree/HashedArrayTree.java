package semsterWorkHashedArrayTree;

import java.util.ArrayList;
import java.util.HashMap;
class HashedArrayList {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;

    public HashedArrayList() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void add(int num) {
        if (!map.containsKey(num)) {
            list.add(num);
            map.put(num, list.size() - 1);
        }
    }

    public void remove(int num) {
        if (map.containsKey(num)) {
            int index = map.get(num);
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
            list.remove(list.size() - 1);
            map.remove(num);
        }
    }

    public int search(int num) {
        if (map.containsKey(num)) {
            return map.get(num);
        } else {
            return -1;
        }
    }
}