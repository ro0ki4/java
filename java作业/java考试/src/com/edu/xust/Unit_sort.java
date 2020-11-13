package com.edu.xust;

public class Unit_sort {
    public static void main(String[] args) {
        int[] a = {0, 7, 4, 2, 1, 6, 4, 1, 2, 5};
        sort(a);
        for(int x:a){
            System.out.print(x + "  ");
        }
    }
    static void sort(int[]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if (array[j] > array[j + 1]) {
                    array[j]=array[j]+array[j+1];
                    array[j+1]=array[j]-array[j+1];
                    array[j]=array[j]-array[j+1];
                }
            }
        }
    }
}
