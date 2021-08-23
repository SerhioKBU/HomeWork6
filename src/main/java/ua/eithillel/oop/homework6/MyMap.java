package ua.eithillel.oop.homework6;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;
import java.util.Objects;


public class MyMap<K, V> implements MapForm<K, V>, Iterable<V>{
    private static final int ARRAY_LENGTH = 16;
    Entry<K,V> [] buckets = new Entry[ARRAY_LENGTH];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int index;
            Entry<K,V> current;

            {
                index = getNextHeadIndex(-1);
                if (index!= -1) current = buckets[index];
            }

            private int getNextHeadIndex(int currentHead){
                for (int i = currentHead + 1; i < buckets.length; i++) {
                    if (buckets[i]!=null) return i;
                }
                return -1;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public V next() {
                V value = (V) current.value;
                current = current.next;
                if(current==null) {
                    index = getNextHeadIndex(index);
                    if (index != -1) current = buckets[index];
                }
                return value;
            }
        };
    }

    @Data
    @AllArgsConstructor
    public static class Entry<K,V> {
        private K key;
        private V value;
        Entry<K,V> next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public int getBucket(K key) {
        return key.hashCode() % buckets.length;
    }

    @Override
    public boolean put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        int bucketItem = getBucket(key);

        if (buckets[bucketItem] == null) {
            buckets[bucketItem] = newEntry;
            size++;
        } else {
            Entry<K,V> current = buckets[bucketItem];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    break;
                }
                if (current.next == null) {
                    current.next = newEntry;
                    size++;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        Entry<K, V> bucket = buckets[getBucket(key)];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    @Override
    public K keySet() {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for (Entry<K, V> current = buckets[getBucket(key)];
             current!=null;
             current = current.next) {

            if (current.key.equals(key)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("Roma", 7454378);
        map.put("Artem", 3661422);
        map.put("Ivan", 9971245);
        map.put("Roma", 7771245);
        map.put("Tom", 7881200);

        for (Integer i: map) {
            System.out.println(i);
        }
        System.out.println("-----------------");
        System.out.println("Get bucket: "
                            + map.getBucket("Ivan") + " | "
                            + map.getBucket("Roma"));
        System.out.println("-----------------");
        System.out.println("Get Value: " + map.get("Ivan") + " | "
                                         + map.get("Roma"));
        System.out.println("-----------------");
        System.out.println("Contains or not: " + map.containsKey("Ivan") + " | "
                                               + map.containsKey("Arten"));
        System.out.println("-----------------");
        System.out.println("Size: " + map.size + " Is empty? " + map.isEmpty());

    }
}
