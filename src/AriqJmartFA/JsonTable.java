package AriqJmartFA;

import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.stream.JsonReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JsonTable<T> extends Vector<T> {

    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T> clazz, String filepath) throws IOException {

        this.filepath = filepath;
        try {

            Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] arrResult = readJson(array, filepath);
            Collections.addAll(this, arrResult);

        } catch(FileNotFoundException e) {

            File docs = new File(filepath);
            File superDoc = docs.getParentFile();
            superDoc.mkdirs();
            docs.createNewFile();

        }

    }
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(filepath));
        T rTemp = gson.fromJson(reader, clazz);
        return rTemp;
    }
    public void writeJson() throws IOException {

        writeJson(this, filepath);

    }

    public static void writeJson(Object object, String filepath) throws IOException {

        FileWriter writer = new FileWriter(filepath);
        String jsonString = gson.toJson(object);
        writer.write(jsonString);

    }
}
