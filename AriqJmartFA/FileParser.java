package AriqJmartFA;


public interface FileParser {
    
    public default boolean read(String content) {

        return false;

    }

    public default Object write() {

        return null;

    }

    public static Object newInstance(String content) {

        return null;

    }
}
