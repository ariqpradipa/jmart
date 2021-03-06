package com.AriqJmartFA;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

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
     * @param iterator collect iterator
     * @param pred predicate to add to
     * @return collection.
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
     * @return  count.
     */
    public static <T> int count(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return count(iterator, value);

    }

    /**
     *
     * @param iterable iterable value.
     * @param value value.
     * @return count.
     */
    public static <T> int count(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return count(iterable, pred);

    }

    /**
     *
     * @param iterator count iterator.
     * @param value value to iterate.
     * @return count based on iterator and value.
     */
    public static <T> int count(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return count(iterator, pred);

    }

    /**
     *
     * @param array count array.
     * @param pred predicate of the array.
     * @return count based on array and predicate.
     */
    public static <T> int count(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);

    }

    /**
     *
     * @param iterable iterable.
     * @param pred predicate to iterate.
     * @return count based on iterable and predicate
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {

        Iterator <T> iterator = iterable.iterator();
        return count(iterator, pred);

    }

    /**
     *
     * @param iterator iterator to iterate to.
     * @param pred predicate to iterate to.
     * @return count based on iterator and predicate.
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
     * @param array array of data.
     * @param value value to compare to.
     * @return data that exists.
     */
    public static <T> boolean exists(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return exists(iterator, value);

    }

    /**
     *
     * @param iterable iterable to iterate to.
     * @param value value to compare to.
     * @return exists data based on iterable and value.
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterable, pred);

    }

    /**
     *
     * @param iterator iterator to iterato to.
     * @param value value to compare to.
     * @return exists based on iterator and value.
     */
    public static <T> boolean exists(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return exists(iterator, pred);

    }

    /**
     *
     * @param array array of exists.
     * @param pred pred to gain from array.
     * @return exists based on pred of array.
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return exists(iterator, pred);

    }

    /**
     *
     * @param iterable iterable of exists.
     * @param pred predicate of exists.
     * @return exists based on iterable and predicate.
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {

        return exists(iterable.iterator(), pred);

    }

    /**
     *
     * @param iterator iterator of exists.
     * @param pred the predicate.
     * @return exists based on iterator and predicate.
     */
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
     * @param array array of items to be find.
     * @param value value of the items.
     * @return foundable items.
     */
    public static <T> T find(T[] array, T value) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> pred = value::equals;
        return find(iterator, value);

    }

    /**
     *
     * @param iterable find iterable.
     * @param value value to compare to.
     * @return foundable items.
     */
    public static <T> T find(Iterable<T> iterable, T value) {

        Predicate<T> pred = value::equals;
        return find(iterable, pred);

    }

    /**
     *
     * @param iterator find iterator.
     * @param value value to compare to.
     * @return foundable items based on iterator and value.
     */
    public static <T> T find(Iterator<T> iterator, T value) {

        Predicate<T> pred = value::equals;
        return find(iterator, pred);

    }

    /**
     *
     * @param array array to find item within.
     * @param pred predicate of items.
     * @return foundable items in provided array.
     */
    public static <T> T find(T[] array, Predicate<T> pred) {

        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);

    }

    /**
     *
     * @param iterable iterable of find.
     * @param pred predicate of find.
     * @return foundable items based on iterable and predicate.
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {

        return find(iterable.iterator(), pred);

    }

    /**
     *
     * @param iterator iterator to iterate to.
     * @param pred predicate of items.
     * @return foundable items based on predicate and iterator.
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
     * @param first first to compare
     * @param second second to compare
     * @return max from the compare
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
     * @param array array of data.
     * @return max in array.
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
     * @param iterable iterable to max.
     * @return max from iterable.
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
     * @param iterator iterator to max.
     * @return max from iterator.
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
     * @param first first to compare to.
     * @param second second to compare to.
     * @param comparator comparator to compare to.
     * @return max based on comparator
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
     * @param array array of data.
     * @param comparator comparator to comapre to.
     * @return max from array data.
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
     * @param iterable iterable max.
     * @param comparator comparator to compare to.
     * @return max from iterable and comparator.
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
     * @param iterator iterator to compare to.
     * @param comparator comparator to compare to.
     * @return max from iterator and comparator.
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
     * @param first first to compare.
     * @param second second to compare.
     * @return minimum based on first and second.
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
     * @param array aray to get min.
     * @return min from array.
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
     * @param iterable min iterable.
     * @return min based on iterable.
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
     * @param iterator iterator to iterate to.
     * @return min based on iterator.
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
     * @param first first data to compare.
     * @param second second data to compare.
     * @param comparator comparator to compare to.
     * @return min after being compare.
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
     * @param array array to compare.
     * @param comparator comparator to compare to.
     * @return min after being compare to.
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
     * @param iterable itrable to compare min.
     * @param comparator comparator to compare to.
     * @return min based on iterable and comparator.
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
     * @param iterator iterator to compare to.
     * @param comparator comparator to compare to.
     * @return min based on iterator and comparator.
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
     * @param array array of data.
     * @param page current page.
     * @param pageSize max page size.
     * @param pred predicate of items.
     * @return paginate result.
     */
    public static <T> List paginate (T[] array, int page, int pageSize, Predicate<T> pred) {

        return Arrays.stream(array).filter(pred::predicate).skip(pageSize*page).limit(pageSize).collect(Collectors.toList());

    }

    /**
     *
     * @param iterable iterable to iterate.
     * @param page current page.
     * @param pageSize max page size.
     * @param pred predicate of items.
     * @return paginate result.
     */
    public static <T> List paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {

        List<T> list = new ArrayList<T>();
        int counter = 0, counterPrint = 0;
        int size = pageSize * page;
        for (T each : iterable){
            if (counter < size && pred.predicate(each)){
                counter++;
                continue;
            }
            if (counterPrint < pageSize && pred.predicate(each)){
                list.add(each);
                counterPrint++;
            }else{
                break;
            }
        }
        return list;

    }

    /**
     *
     * @param iterator iterator to iterate to.
     * @param page current page.
     * @param pageSize max page size.
     * @param pred predicate of items.
     * @return paginate result.
     */
    public static <T> List paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {

        int iteration = 0;
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);

        List<T> array = new ArrayList<T>();

        iterator.forEachRemaining(array::add);

        for (; iteration < array.size() && occurences < startingIdx; ++iteration) {
            if (pred.predicate(array.get(iteration))) {
                ++occurences;
            }
        }
        for (int i = 0; i < array.size() && pageList.size() < pageSize; ++i) {
            if (pred.predicate(array.get(iteration))) {
                pageList.add(array.get(iteration));
            }
        }
        return pageList;

    }
}


