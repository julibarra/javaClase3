import java.util.Comparator;

public class BubbleSortSorterImple<T> implements Sorter<T>{
    @Override
    public <T> void sort(T[] arr, Comparator<T> c) {

    }
    public static <T>void bubbleSort(T arr[],Comparator c){
        for (int i= arr.length-1; i>0; i--){
            for (int j=0; j<i ; j++){
                if (c.compare(arr[j],arr[j+1])>0){
                    swap(arr, j, j+1);
                }
            }
        }

    }

    private static<T> void swap( T arr[], int pos1,  int pos2){
        T temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
