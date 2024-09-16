public class QuickSort {
    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i= low-1;
        for(int j=low;j<arr.length;j++){
            if(arr[j] < pivot){
                i++;
                //swap and if they are at the same element then swapping takes place at the same place
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
    
        public static void quickSort(int arr[],int low,int high){
          if (low < high){
            int pidx = partition(arr,low,high);
    
            quickSort(arr,low,pidx-1);
            quickSort(arr, pidx+1, high);
          }
        }
    
        public static void main(String args[]){
            int[] arr = {6,3,9,5,2,8};
            int n = arr.length;
    
             
        }
    }
    