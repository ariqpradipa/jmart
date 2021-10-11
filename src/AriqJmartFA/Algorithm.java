package AriqJmartFA;

import java.util.*;
import java.io.*;

public class Algorithm {

    private Algorithm() {

    }
    /*
    public static <T> List<T> collect(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return collect(iterator, value);

    }

    public static <T>  List<T> collect(Iterable<T> iterable, T value) {

        Object::equals(Object) = value::equals;
        return collect(iterable, Object);

    }

    public static <T> List collect(Iterator<T> iterator, T value) {

    }

    public static <T> List collect(T[] array, Predicate<T> pred) {

    }

    public static <T> List collect(Iterable<T> iterable, T pred) {

    }

    public static <T> List collect(Iterator<T> iterator, T pred) {

    }
    */

    public static <T> int count(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return count(iterator, value);

    }

    public static <T> int count(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return count(iterable, pred);

    }

    public static <T> int count(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return count(iterator, pred);

    }

    public static <T> int count(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);

    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {

        Iterator <T> iterator = iterable.iterator();
        return count(iterator, pred);

    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {

        int out = 0;

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                out++;
            }
        }

        return out;

    }

    public static <T> boolean exists(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return exists(iterator, value);

    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterable, pred);

    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterator, pred);

    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);

    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {

        return exists(iterable.iterator(), pred);

    }

    // yang ini gimanan caranya ni belum tau
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                return true;
            }
        }

        return false;

    }


    public static <T> T find(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return find(iterator, value);

    }

    public static <T> T find(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return find(iterable, pred);

    }

    public static <T> T find(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return find(iterator, pred);

    }

    public static <T> T find(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);

    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {

        return find(iterable.iterator(), pred);

    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {

        while(iterator.hasNext()) {

            T object = iterator.next();

            if(pred.predicate(object)) {

                return object;

            }
        }

        return null;

    }

    public static <T extends Comparable<? super T>> T max(T first, T second) {

        if(first.compareTo(second) < 0) {

            return second;

        }
        else {

            return first;

        }
    }

    public static <T extends Comparable<? super T>> T max(T[] array) {

        T max = array[0];
        for(int i = 1; i < array.length; i++) {

            if(max.compareTo(array[i]) < 0) {

                max = array[i];

            }
        }

        return max;

    }

    /*
    public static <T extends Comparable<? super T>> T max(Iterable<? extends T> iterable) {

        T next, candidate = iterable.next();
        T max = Ordering.natural().max(iterable);

        return max;

    }
    */
    public static <T extends Comparable<? super T>> T max(Iterator<? extends T> iterator) {

        T next, candidate = iterator.next();
        while (iterator.hasNext()) {

            if((next = iterator.next()).compareTo(candidate) > 0) {

                candidate = next;

            }
        }

        return candidate;

    }

    public static <T extends Comparable<? super T>> T min(T first, T second) {

        if(first.compareTo(second) < 0) {

            return first;

        }
        else {

            return second;

        }
    }
}
