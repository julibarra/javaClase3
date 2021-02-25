import java.util.Comparator;

public class QuickSortSorterImple<T> implements Sorter <T> {

    @Override
    public <T> void sort(T[] arr, Comparator<T> c) {
        quickSortIterative(arr,0,arr.length-1,c);
    }


    public static<T> void quicksortC(T A[], int izq, int der,Comparator c) {

        T pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        T aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(c.compare(A[i],pivote)<=0&& i < j) i++; // busca elemento mayor que pivote
            while(c.compare(A[j],pivote)>0) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }

        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quicksortC(A,izq,j-1,c);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quicksortC(A,j+1,der,c);          // ordenamos subarray derecho

    }
//------------------------------------------------------------
/*
    <T>void swap_vals(T arr[], int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    <T>int partition(T arr[], int l, int h, Comparator c){
        T x = arr[h];
        int i = (l - 1);
        for (int j = l; j <= h - 1; j++){
            //arr[j] <= x
            if (c.compare(arr[j],x)<=0){
                i++;
                swap_vals(arr, i, j);
            }
        }
        swap_vals(arr, i + 1, h);
        return (i + 1);
    }
    <T>void quick_sort(T arr[], int l, int h, Comparator c){
        int my_list[] = new int[h - l + 1];
        int top = -1;
        my_list[++top] = l;
        my_list[++top] = h;
        while (top >= 0){
            h = my_list[top--];
            l = my_list[top--];
            int p = partition(arr, l, h, c);
            if (p - 1 > l){
                my_list[++top] = l;
                my_list[++top] = p - 1;
            }
            if (p + 1 < h){
                my_list[++top] = p + 1;
                my_list[++top] = h;
            }
        }
    }
    //-----------------------------------------------------------------------


 */

    public void quicksort(T[] arr, int below, int above, Comparator<T> c) {
        int left, right;
        T middle, x;
        left = below;
        right = above;
        middle = arr[(left + right) / 2];
        do {
            while (c.compare(arr[left], middle) < 0 && left < above) {
                left++;
            }
            while (c.compare(middle, arr[right]) < 0 && right > below) {
                right--;
            }
            if (left <= right) {
                x = arr[left];
                arr[left] = arr[right];
                arr[right] = x;
                left++;
                right--;
            }
        } while (left <= right);
        if (below < right) {
            quicksort(arr, below, right, c);
        }
        if (left < above) {
            quicksort(arr, left, above, c);
        }
    }


    public static<T> int partition(T arr[], int low, int high, Comparator c)
    {
        T pivot = arr[high];

        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            //arr[j] <= pivot
            if (c.compare(arr[j], pivot)<=0) {
                i++;

                // swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* A[] --> Array to be sorted,
   l  --> Starting index,
   h  --> Ending index */
    static <T>void quickSortIterative(T arr[], int l, int h ,Comparator c)
    {
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int  p = partition(arr, l, h, c);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
}
