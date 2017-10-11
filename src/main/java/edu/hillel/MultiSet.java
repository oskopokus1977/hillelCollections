package edu.hillel;

import java.util.HashMap;
import java.util.Map;

public class MultiSet<T> {
    public HashMap<T, Integer> hashMap;

    public MultiSet() {
        hashMap = new HashMap<T, Integer>();
    }

    public void printSet() {
        for (Map.Entry<T, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public void add(T e) {
        if (hashMap.isEmpty()) {
            hashMap.put(e, 1);
        } else {
            if (hashMap.containsKey(e)) {
                hashMap.put(e, (hashMap.get(e) + 1));
            } else {
                hashMap.put(e, 1);
            }
        }
    }

    public void remove(T e) {
        if (hashMap.containsKey(e)) {
            if (hashMap.get(e) > 1) {
                hashMap.put(e, (hashMap.get(e) - 1));
            } else {
                hashMap.remove(e);
            }
        } else {
            System.out.println("Object " + e + " is absent in the set");
        }
    }

    public int contains(T e) {
        if (!hashMap.containsKey(e)) {
            return 0;
        } else {
            return hashMap.get(e);
        }
    }

    public int size() {
        int size = 0;
        for (Integer i : hashMap.values()) {
            size += i;
        }
        return size;
    }

    public MultiSet union(MultiSet<T> multiSet) {
        MultiSet<T> newMS = new MultiSet<T>();
        newMS.hashMap.putAll(hashMap);
        for (Map.Entry<T, Integer> pair : multiSet.hashMap.entrySet()) {
            if (hashMap.containsKey(pair.getKey())) {
                newMS.hashMap.put(pair.getKey(), (hashMap.get(pair.getKey()) + multiSet.hashMap.get(pair.getKey())));
            } else {
                newMS.hashMap.put(pair.getKey(), 1);
            }
        }
        return newMS;
    }

    public MultiSet intersect(MultiSet<T> multiSet) {
        MultiSet<T> newMS = new MultiSet<T>();
        for (Map.Entry<T, Integer> pair : multiSet.hashMap.entrySet()) {
            if (hashMap.containsKey(pair.getKey())) {
                newMS.hashMap.put(pair.getKey(), (hashMap.get(pair.getKey()) + multiSet.hashMap.get(pair.getKey())));
            }
        }
        return newMS;
    }

    public MultiSet uniquSet() {
        MultiSet<T> uniqMS = new MultiSet<T>();
        for (T r : hashMap.keySet()) {
            uniqMS.add(r);
        }
        return uniqMS;
    }
}
