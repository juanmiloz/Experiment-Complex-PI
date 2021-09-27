package ui;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static int[] test1 = new int[9];
    public static int[] test2 = new int[99];
    public static int[] test3 = new int[999];
    public static int[] test4 = new int[9999];

    public static ArrayList<Double> resultsTest1 = new ArrayList<>();
    public static ArrayList<Double> resultsTest2 = new ArrayList<>();
    public static ArrayList<Double> resultsTest3 = new ArrayList<>();
    public static ArrayList<Double> resultsTest4 = new ArrayList<>();

    public static BufferedReader br;
    public static BufferedWriter bw;


    public static void main(String args[]) throws IOException {
        for(int i = 0; i < 100; i++){
            System.out.println("======================================================");
            System.out.println("Repeticion #"+(i+1));
            initializeExperiments();
        }
        generateReport();
    }

    public static void initializeExperiments() throws IOException {
        for(int i = 0; i < 4;i++){
            if(i == 0){
                readCSV("data/array1.csv");
            }else if(i == 1){
                readCSV("data/array2.csv");
            }else if(i == 2){
                readCSV("data/array3.csv");
            }else if(i == 3){
                readCSV("data/array4.csv");
            }
        }
        Double resultTest1 = experiment(test1);
        System.out.println("Tiempo de ejecucion test 1: " + resultTest1 + " ns" );
        resultsTest1.add(resultTest1);



        Double resultTest2 = experiment(test1);
        System.out.println("Tiempo de ejecucion test 1: " + resultTest2 + " ns" );
        resultsTest2.add(resultTest2);

        Double resultTest3 = experiment(test1);
        System.out.println("Tiempo de ejecucion test 1: " + resultTest3 + " ns" );
        resultsTest3.add(resultTest3);

        Double resultTest4 = experiment(test1);
        System.out.println("Tiempo de ejecucion test 1: " + resultTest4 + " ms" );
        resultsTest4.add(resultTest4);
    }

    public static void readCSV(String path) throws IOException {
        br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        String[] temp;
        ArrayList<String> array = new ArrayList<>();
        while(line != null){
            temp = line.split(",");
            for(int i = 0; i < temp.length; i++){
                array.add(temp[i]);
            }
            line = br.readLine();
        }
        ArrayList<Integer> testInteger= castArray(array);
    }

    public static ArrayList<Integer> castArray(ArrayList<String> array){
        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            test.add(Integer.parseInt(array.get(i).trim()));
        }
        return test;
    }

    public void addTestElements(ArrayList<Integer> test){
        if(test.size()==10){
            for(int i = 0; i < test.size();i++){
                test1[i] = test.get(i);
            }
        }else if (test.size()==100){
            for(int i = 0; i < test.size();i++){
                test2[i] = test.get(i);
            }
        }else if (test.size()==1000){
            for(int i = 0; i < test.size();i++){
                test3[i] = test.get(i);
            }
        }else if (test.size()==10000){
            for(int i = 0; i < test.size();i++){
                test4[i] = test.get(i);
            }
        }
    }

    public static double experiment(int[] test){
        long start = System.nanoTime();
        bubbleSort(test);
        long end = System.nanoTime();
        double time = (double)((end-start));
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

    public static void generateReport() throws IOException {
        bw = new BufferedWriter(new FileWriter("data/report.csv"));
        for(int i = 0; i < resultsTest1.size(); i++){
            bw.write(resultsTest1.get(i)+","+resultsTest2.get(i)+","+resultsTest3.get(i)+","+resultsTest4.get(i)+","+"\n");
        }
        bw.close();
    }

}
