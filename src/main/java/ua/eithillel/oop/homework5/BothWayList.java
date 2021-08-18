package ua.eithillel.oop.homework5;

import lombok.Data;
import java.util.Iterator;
import java.util.NoSuchElementException;

@Data
public class BothWayList<T> implements LinkList<T>, Iterable<T> {
    private ListElement<T> head;
    private ListElement<T> tail;
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (head == null) {
            head = new ListElement<>(element);
            tail = head;
        } else {
            tail.next = new ListElement<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        if (head.value.equals(element)) {
            head = head.next;
            return true;
        } else {
            for (ListElement<T> previously = head, current = head.next;
                 current != null;
                 previously = current, current = current.next) {
                if (current.value.equals(element)) {
                    previously.next = current.next;
                    if (current==tail) tail=previously;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(Object o) {
        for (T t : this) {
            if (t.equals(o)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public T get(int index) {
        ListElement<T> current = head;
        for (int i = 0; i < index && current!=null; i++) {
            current = current.next;
        } return current!=null ? current.value : null;
    }

    @Override
    public T getLastElement() {
        if (tail == null)
            throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public T getFirstElement() {
        if (head == null)
            throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return get(counter--);
            }
        };
    }

    @Data
        private static class ListElement<T> {
            T value;
            ListElement<T> next;
            ListElement<T> prev;

        public ListElement(T value) {
            this.value = value;
        }
    }
}

