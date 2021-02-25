import java.util.Comparator;

public interface Sorter<T>{
    <T> void sort(T arr[], Comparator<T> c);

}
