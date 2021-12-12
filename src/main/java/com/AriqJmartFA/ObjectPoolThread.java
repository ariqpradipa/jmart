package com.AriqJmartFA;

import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector<T>();
    private Function<T, Boolean> routine;

    /**
     * multi threading using object poolthread
     * @param name thread name
     * @param routine the routine
     */
    public ObjectPoolThread(String name, Function<T, Boolean> routine) {

        super(name);
        this.routine = routine;
//        Thread thread = new Thread(name);
//        thread.start();

    }

    /**
     * Assign routine
     *
     * @param routine routine value
     */
    public ObjectPoolThread(Function<T, Boolean> routine) {

        this.routine = routine;

    }

    /**
     * Synchronize add
     *
     * @param object object to synchronize
     */
    public synchronized void add(T object) {

        objectPool.add(object);

    }

    /**
     * exit from synchronize
     */
    public synchronized void exit() {

        this.exitSignal = true;
        //currentThread().stop();

    }

    /**
     * Start run the thread
     */
    public void run() {

        exitSignal = false;
        boolean test;

        synchronized (this){
            for(T object : this.objectPool) {

                test = routine.apply(object);
                if (!test) {

                    this.objectPool.add(object);

                } else {

                    this.objectPool.remove(object);

                }

                while(this.objectPool.size() == 0){

                    try {

                        routine.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }
                }
                if(exitSignal) {

                    break;

                }
            }
        }
    }

    /**
     *
     * @return size of the pool
     */
    public int size() {

        return objectPool.size();

    }
}
