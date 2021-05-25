//两种经典排序算法
//快速排序 quicksort
public static void quicksort(int[] a, int begin, int end) {
    if (end <= begin) return a;
    int pivot = partition (a, begin, end);
    quicksort(a, begin, pivot - 1);
    quicksort(a, pivot + 1, end);
}

public int partiton(int[] a, int begin, int end) {
    int pivot = end;
    int counter = begin;
    for (int i = begin; i < end; i++) {
      if (a[i] < a[pivot]) {
        int temp = a[i];
        a[i] = a[counter];
        a[counter] = temp;
        counter++;
      }
    }
    int temp = a[pivot];
    a[pivot] = a[counter];
    a[counter] = temp;
    return counter;
}

//归并排序 mergesort
public static void mergesort(int[] a, int begin, int end)  {
    if (begin < end) return;
    int mid = (begin + end) >> 1;
    mergesort(a, begin, mid);
    mergesort(a, mid + 1, end);
    merge(a, begin, mid, end);
}

public static void merge(int[] a, int begin, int mid, int end) {
    int[] temp = new int[end - begin + 1];
    int i = begin, j = mid + 1, k = 0;
     while (i <= mid && j <= right) {
         temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
     }
     while (i <= mid) temp[k++] = a[i++];
     while (j <= end) temp[k++] = a[j++];
     for (int p = 0; p < temp.length; p++) {
         a[begin + p] = temp[p];
     }
}

