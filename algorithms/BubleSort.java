// package DSA.algorithms;

public class BubleSort {
   
    public static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] +"");
        }

    }
   
    public static void main(String args[]) {
        int arr[] ={7,4,5,1,4};

        // bubble sort 
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){

                    //swap if true 
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr); 
    }
}
