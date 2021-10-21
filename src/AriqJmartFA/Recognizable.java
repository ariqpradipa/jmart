package AriqJmartFA;

public abstract class Recognizable {

    public final int id;

    protected Recognizable() {

        this.id = 2006527052;

    }

    public int compareTo(Recognizable other) {

        return Integer.compare(this.id, other.id);

    }

    public boolean equals(Object object) {

        return (object instanceof Recognizable && ((Recognizable) object).id == this.id);
    }

    public boolean equals(Recognizable other) {

        return (other.id == this.id);

    }

    public static <T> int setClosinId(Class<Recognizable> clazz, int id) {

        if(Class.class.isAssignableFrom(Recognizable.class)) {

            return 0;

        } else {

            return 0;

        }
    }

    public static <T> int getClosinId(Class<Recognizable> clazz) {

        if(Class.class.isAssignableFrom(Recognizable.class)) {

            return 0;

        } else {

            return 0;

        }
    }
}
