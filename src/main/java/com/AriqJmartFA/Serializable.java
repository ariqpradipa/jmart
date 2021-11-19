package com.AriqJmartFA;

import java.util.HashMap;

public abstract class Serializable {

    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap();

    protected Serializable() {

        Class<?> key = this.getClass();

        if (mapCounter.containsKey(key)) {
            mapCounter.put(key, mapCounter.get(key) + 1);

        } else {

            mapCounter.put(key,0);

        }
        this.id = mapCounter.get(key);
    }

    public int compareTo(Serializable other) {

        return Integer.compare(this.id, other.id);

    }

    public boolean equals(Object object) {

        return (object instanceof Serializable && ((Serializable) object).id == this.id);
    }

    public boolean equals(Serializable other) {

        return (other.id == this.id);

    }

    public static <T extends Serializable> int setClosinId(Class<T> clazz, int id) {

        return mapCounter.put(clazz, id);

    }

    public static <T extends Serializable> int getClosinId(Class<T> clazz) {

        return mapCounter.get(clazz);

    }
}
