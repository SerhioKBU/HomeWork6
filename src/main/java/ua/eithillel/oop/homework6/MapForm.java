package ua.eithillel.oop.homework6;

public interface MapForm<K,V> {
    boolean put(K key, V value);
    boolean containsKey(K key);
    V get(K key);
    K keySet();
    int size();
}
