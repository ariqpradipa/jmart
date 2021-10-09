package AriqJmartFA;

import java.util.Iterator;

public class Algorithm {
    /*
    private Algorithm() {

    }

    public static <T> int count(T[][] array, T value) {

    }

    public static <T> int count(Iterable<T> iterable, T value) {

    }

    public static <T> int count(Iterator<T> iterator, T value) {

    }

    public static <T> int count(T[][] array, Predicate<T> pred) {

    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {

        int out = 0;

        while(iterable.hasNext()) {
            if(iterable.next().equals(pred))
        }

    }
    */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {

        int out = 0;

        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                out++;
            }
        }

        return out;

    }
    /*
    public static boolean exists(T[] array, T value) {

    }

    public static boolean exists(Iterable<T> iterable, T value) {

    }

    public static boolean exists(Iterator<T> iterator, T value) {

    }

    public static boolean exists(T[][] array, Predicate<T> pred) {

    }

    public static boolean exists(Iterable<T> iterable, Predicate<T> pred) {

    }

    public static boolean exists(Iterator<T> iterator, Predicate<T> pred) {

    }

    public static T find(T[][] array, T value) {

    }

    public static T find(Iterable<T> iteravle, T value) {

    }

    public static T find(Iterator<T> iterator, T value) {

    }

    public static T find(T[][] array, Predicate<T> pred) {

    }

    public static T find(Iterable<T> iterable, Predicate<T> pred) {

    }

    public static T find(Iterator<T> iterator, Predicate<T> pred) {

    }

    public static T max(T first, T second) {

    }

    public static T min(T first, T second) {

    }
    */

}
