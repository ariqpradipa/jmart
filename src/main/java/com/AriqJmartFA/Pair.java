package com.AriqJmartFA;

public class Pair<T, U> {

    public T first;
    public U second;

    /**
     * to call pair
     */
    public Pair() {

    }

    /**
     *
     * @param first T value first
     * @param second T value second
     */
    public Pair(T first, U second) {

        this.first = first;
        this.second = second;

    }
}
