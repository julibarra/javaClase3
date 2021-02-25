import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Properties;

public class MiFactory {

    public static Sorter getInstance() throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("./src/MiFactory.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (Sorter) Class.forName(p.get("sorter").toString()).getConstructor().newInstance();
    }

    }

