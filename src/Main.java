import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, FileNotFoundException, InvocationTargetException, ClassNotFoundException {
        Integer[] array=new Integer[100000];
        for (int i=99999; i>=0;i--){
            array[i]=i;
        }

        Integer[] array2=new Integer[10];
        for (int i=9; i>=0;i--){
            array2[i]=i;
        }
        Comparator<Integer> c1 = (n1, n2) -> n1 - n2;

        Sorter sorter=(Sorter)MiFactory.getInstance();

        Timer timer = new Timer();
        timer.start();
        sorter.sort(array2,c1);
        System.out.println(timer.getElapsedTime());
        timer.stop();
        for (Integer i: array){
            System.out.println(i);
        }

    }
}
