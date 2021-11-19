package com.AriqJmartFA;

import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal;
    private Vector<T> objectPool = new Vector<>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine) {

        super(name);
        this.routine = routine;
        Thread thread = new Thread(name);
        thread.start();

    }

    public ObjectPoolThread(Function<T, Boolean> routine) {

        super();

    }
    public synchronized void add(T object) {

        this.objectPool.add(object);

    }
    public synchronized void exit() {

        currentThread().stop();

    }
    public void run() {

        for(T x: objectPool) {
            this.routine = (Function<T, Boolean>) x;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        exit();

    }
    public int size() {

        return objectPool.size();

    }
}
