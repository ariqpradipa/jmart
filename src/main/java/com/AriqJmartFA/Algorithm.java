package com.AriqJmartFA;

import java.util.*;
import java.io.*;

public class Algorithm {

    /**
     * call Algorithm
     * Algorithm used to calculate, sort, etc data
     */
    private Algorithm() {

    }

    /**
     *
     * @param array array collection.
     * @param value the value.
     * @param <T>
     * @return the list of the array after equals value.
     */
    public static <T> List<T> collect(T[] array, T value) {

        List<T> list = new ArrayList<T>();
        for(T a:array) {

            if(a.equals(value)) {

                list.add(a);

            }
        }

        return list;

    }

    /**
     *
     * @param iterable iterable collection.
     * @param value value to compare.
     * @param <T>
     * @return list of iterable that contains value.
     */
    public static <T>  List<T> collect(Iterable<T> iterable, T value) {

        List<T> list = new ArrayList<T>();
        for(T a:iterable) {

            if(a.equals(value)) {

                list.add(a);

            }
        }

        return list;

    }

    /**
     *
     * @param iterator iterator collection.
     * @param value value to compare to.
     * @param <T>
     * @return list of iterator that contains value.
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value) {

        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {

            T a = iterator.next();
            if(a.equals(value)) {

                list.add(a);

            }
        }

        return list;

    }


    /**
     *
     * @param array array of collection.
     * @param pred predicate to compare to.
     * @param <T>
     * @return list of array that fulfill predicate.
     */
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {

        List<T> list = new ArrayList<T>();
        for (T a: array) {

            if(pred.predicate(a)) {

                list.add(a);

            }
        }

        return list;

    }

    /**
     *
     * @param iterable iterable of collect
     * @param pred predicate of collect
     * @param <T>
     * @return list of collect after be predicate
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {

        List<T> list = new ArrayList<T>();
        for (T a : iterable) {

            if (pred.predicate(a)) {

                list.add(a);

            }
        }

        return list;

    }

    /**
     *
     * @param iterator
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {

        List<T> list = new ArrayList<T>();
        while(iterator.hasNext()) {

            T a = iterator.next();
            if (pred.predicate(a)) {

                list.add(a);

            }
        }

        return list;

    }

    /**
     *
     * @param array count array.
     * @param value value to compare to.
     * @param <T>
     * @return  count.
     */
    public static <T> int count(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return count(iterator, value);

    }

    /**
     *
     * @param iterable
     * @param value
     * @param <T>
     * @return
     */
    public static <T> int count(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return count(iterable, pred);

    }

    /**
     *
     * @param iterator
     * @param value
     * @param <T>
     * @return
     */
    public static <T> int count(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return count(iterator, pred);

    }

    /**
     *
     * @param array
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> int count(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);

    }

    /**
     *
     * @param iterable
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {

        Iterator <T> iterator = iterable.iterator();
        return count(iterator, pred);

    }

    /**
     *
     * @param iterator
     * @param pred
     * @param <T>
     * @return
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

    /**
     *
     * @param array
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean exists(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return exists(iterator, value);

    }

    /**
     *
     * @param iterable
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterable, pred);

    }

    /**
     *
     * @param iterator
     * @param value
     * @param <T>
     * @return
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterator, pred);

    }

    /**
     *
     * @param array
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);

    }

    /**
     *
     * @param iterable
     * @param pred
     * @param <T>
     * @return
     */
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

    /**
     *
     * @param array
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T find(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return find(iterator, value);

    }

    /**
     *
     * @param iterable
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T find(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return find(iterable, pred);

    }

    /**
     *
     * @param iterator
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T find(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return find(iterator, pred);

    }

    /**
     *
     * @param array
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> T find(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);

    }

    /**
     *
     * @param iterable
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {

        return find(iterable.iterator(), pred);

    }

    /**
     *
     * @param iterator
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {

        while(iterator.hasNext()) {

            T object = iterator.next();

            if(pred.predicate(object)) {

                return object;

            }
        }

        return null;

    }

    /**
     *
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T first, T second) {

        if(first.compareTo(second) < 0) {

            return second;

        }
        else {

            return first;

        }
    }

    /**
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T[] array) {

        T max = array[0];
        for(int i = 1; i < array.length; i++) {

            if(max.compareTo(array[i]) < 0) {

                max = array[i];

            }
        }

        return max;

    }

    /**
     *
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(Iterable<? extends T> iterable) {

        T max = iterable.iterator().next();
        for(T elm : iterable) {

            if(max.compareTo(elm) < 0) {

                max = elm;

            }
        }

        return max;

    }

    /**
     *
     * @param iterator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(Iterator<? extends T> iterator) {

        T next, max = iterator.next();
        while (iterator.hasNext()) {

            if((next = iterator.next()).compareTo(max) > 0) {

                max = next;

            }
        }

        return max;

    }

    /**
     *
     * @param first
     * @param second
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) {

        if(comparator.compare(first, second) > 0) {

            return first;

        }
        else {

            return second;

        }
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator) {

        T max = array[0];
        for(int i = 1; i < array.length; i++) {

            if(comparator.compare(array[i], max) > 0) {

                max = array[i];

            }
        }

        return max;

    }

    /**
     *
     * @param iterable
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator) {

        T max = iterable.iterator().next();
        for(T elm : iterable) {

            if(comparator.compare(elm, max) > 0) {

                max = elm;

            }
        }

        return max;

    }

    /**
     *
     * @param iterator
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) {

        T next, max = iterator.next();
        while (iterator.hasNext()) {

            if(comparator.compare((next = iterator.next()), max) > 0) {

                max = next;

            }
        }

        return max;

    }

    /**
     *
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T first, T second) {

        if(first.compareTo(second) < 0) {

            return first;

        }
        else {

            return second;

        }
    }

    /**
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T[] array) {

        T min = array[0];
        for(int i = 1; i < array.length; i++) {

            if(array[i].compareTo(min) < 0) {

                min = array[i];

            }
        }

        return min;

    }

    /**
     *
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(Iterable<? extends T> iterable) {

        T min = iterable.iterator().next();
        for(T elm : iterable) {

            if(elm.compareTo(min) < 0) {

                min = elm;

            }
        }

        return min;

    }

    /**
     *
     * @param iterator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(Iterator<? extends T> iterator) {

        T next, min = iterator.next();
        while (iterator.hasNext()) {

            if(min.compareTo((next = iterator.next())) > 0) {

                min = next;

            }
        }

        return min;

    }

    /**
     *
     * @param first
     * @param second
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator) {

        if(comparator.compare(first, second) < 0) {

            return first;

        }
        else {

            return second;

        }
    }

    /**
     *
     * @param array
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator) {

        T min = array[0];
        for(int i = 1; i < array.length; i++) {

            if(comparator.compare(array[i], min) < 0) {

                min = array[i];

            }
        }

        return min;

    }

    /**
     *
     * @param iterable
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator) {

        T min = iterable.iterator().next();
        for(T elm : iterable) {

            if(comparator.compare(elm, min) < 0) {

                min = elm;

            }
        }

        return min;

    }

    /**
     *
     * @param iterator
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator) {

        T next, min = iterator.next();
        while (iterator.hasNext()) {

            if(comparator.compare((next = iterator.next()), min) < 0) {

                min = next;

            }
        }

        return min;

    }

    /**
     *
     * @param array
     * @param page
     * @param pageSize
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> List paginate (T[] array, int page, int pageSize, Predicate<T> pred) {

        List<T> a = new ArrayList<T>();
        List<T> b = new ArrayList<T>();

        for(T c : array) if(pred.predicate(c)) a.add(c);

        int x = 0;
        for(T d : b) {

            if (x >= ((page)*pageSize) && x < ((page+1)*pageSize)) b.add(d);
            x++;

        }

        return b;

    }

    /**
     *
     * @param iterable
     * @param page
     * @param pageSize
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> List paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {

        List<T> a = new ArrayList<T>();
        List<T> b = new ArrayList<T>();

        for(T c : iterable) if(pred.predicate(c)) a.add(c);

        int x = 0;
        for(T d : b) {

            if (x >= ((page)*pageSize) && x < ((page+1)*pageSize)) b.add(d);
            x++;

        }

        return b;

    }

    /**
     *
     * @param iterator
     * @param page
     * @param pageSize
     * @param pred
     * @param <T>
     * @return
     */
    public static <T> List paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {

        List<T> a = new ArrayList<T>();
        List<T> b = new ArrayList<T>();

        int x = 0;
        while (iterator.hasNext()) {

            T i = iterator.next();
            if(pred.predicate(i)) a.add(i);
            if (x >= ((page)*pageSize) && x < ((page+1)*pageSize)) b.add(i);
            x++;

        }

        return b;

    }

    /*
    public static <T> List<Product> paginate(T[] array, int page, int pageSize, Predicate<Product> pred) {

        List<Product> result = new ArrayList<Product>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(int i = 0; i < pageSize && i < array.length - currIdx; i++) {

            if(pred.predicate((Product) array[i])) {

                result.add((Product) array[i]);

            }
        }

        return result;

    }

    public static <T> List<Product> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<Product> pred) {

        List<T> list = new ArrayList<T>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        for(T a:iterable) {

            if(pred.predicate((Product) a)) {

                list.add(a);

            }
        }

        return (List<Product>) list;

    }

    public static <T> List<Product> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<Product> pred) {

        List<T> list = new ArrayList<T>();
        int currIdx = page > 1 ? (page-1)*pageSize : 0;

        while(iterator.hasNext()) {

            T a = iterator.next();
            if(pred.predicate((Product) a)) {

                list.add(a);

            }
        }

        return (List<Product>) list;

    }
    */

}


