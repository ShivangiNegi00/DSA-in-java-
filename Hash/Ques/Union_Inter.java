// package Ques;

import java.util.HashSet;

public class Union_Inter {
    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        int n= arr1.length ,  m = arr2.length;
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }

        for(int j=0;j<m;j++) {
            set.add(arr2[j]);
        }

        return set.size();
    }

    public static int intersection(int arr1[] , int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int j=0;j<arr2.length ; j++) {
            if(set.contains(arr2[j])) {
                count++;
                set.remove(arr2[j]); // if  there is intersection element then remove the set element since that has been already found
            }
        }

        return count;
    }
    public static void main(String args[]) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,4,7,1,2};

        System.out.println(union(arr1, arr2));// 7

        System.out.println(intersection(arr1, arr2));//2
    }
}
