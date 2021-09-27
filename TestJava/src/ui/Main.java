package ui;

public class Main {

    public static int[] test1 = {5, 1, 4, 2, 8, 9};

    public static void main(String args[]){
        System.out.println("\nTiempo de ejecucion: " + experiment(test1) + " seg");
    }

    public static double experiment(int[] test){
        long start = System.currentTimeMillis();
        printArray(bubbleSort(test));
        long end = System.currentTimeMillis();
        double time = (double)((end-start)/1000);
        return time;
    }

    public static int[] bubbleSort(int[] array){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }

        return array;
    }

    public static void printArray(int [] array){
        for(int i = 0; i < array.length; i++){
            if(i != array.length-1){
                System.out.print(array[i] + " ,");
            }else{
                System.out.print(array[i]);
            }
        }
    }

}
