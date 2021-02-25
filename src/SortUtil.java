public class SortUtil {

    public static <T>void ordenar(Precedable<T> arr[]){
        for (int i= arr.length-1; i>0; i--){
            for (int j=0; j<i ; j++){
                if (arr[j].precedeA((T)arr[j+1])>0){
                    swap(arr, j, j+1);
                }
            }
        }

    }

    private static<T> void swap( Precedable<T> arr[], int pos1,  int pos2){
        Precedable<T> temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }



}
