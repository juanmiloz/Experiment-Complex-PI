package ui;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static int[] test1 = new int[10];
    public static int[] test2 = new int[100];
    public static int[] test3 = new int[1000];
    public static int[] test4 = new int[10000];

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
                addTestElements(readCSV("data/array1.csv"));
            }else if(i == 1){
                addTestElements(readCSV("data/array2.csv"));
            }else if(i == 2){
                addTestElements(readCSV("data/array3.csv"));
            }else if(i == 3){
                addTestElements(readCSV("data/array4.csv"));
            }
        }
        Double resultTest1 = experiment(test1);
        System.out.println("Tiempo de ejecucion test 1: " + resultTest1 + "ms" );
        resultsTest1.add(resultTest1);

        Double resultTest2 = experiment(test2);
        System.out.println("Tiempo de ejecucion test 2: " + resultTest2 + "ms" );
        resultsTest2.add(resultTest2);

        Double resultTest3 = experiment(test3);
        System.out.println("Tiempo de ejecucion test 3: " + resultTest3 + "ms" );
        resultsTest3.add(resultTest3);

        Double resultTest4 = experiment(test4);
        System.out.println("Tiempo de ejecucion test 4: " + resultTest4 + "ms" );
        resultsTest4.add(resultTest4);
    }

    public static ArrayList<Integer> readCSV(String path) throws IOException {
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
        return testInteger;
    }

    public static ArrayList<Integer> castArray(ArrayList<String> array){
        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            test.add(Integer.parseInt(array.get(i).trim()));
        }
        return test;
    }

    public static void addTestElements(ArrayList<Integer> test){
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
        long start = System.currentTimeMillis();
        bubbleSort(test);
        long end = System.currentTimeMillis();
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
