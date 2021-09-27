using System;
using System.Diagnostics;

namespace TestC_Sharp
{
    class Program
    {

        public static int[] test1 = { 5, 1, 4, 2, 8, 9 };

        static void Main(string[] args)
        {
            Console.WriteLine("\nTiempo de ejecucion: " + experiment(test1) + " seg");
        }

        public static double experiment(int[] test)
        {
            Stopwatch timeMeasure = new Stopwatch();
            timeMeasure.Start();
            printArray(bubbleSort(test));
            timeMeasure.Stop();
            
            return timeMeasure.Elapsed.TotalMilliseconds/1000;
        }

        static int[] bubbleSort(int[] array) {
            for (var i = 0; i < array.Length; i++) {
                for (var j = 0; j < array.Length-1; j++) {
                    if (array[j] > array[j + 1]) 
                    {
                        var temp = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = temp;
                    }
                }
            }

            return array;
        }

        static void printArray(int[] array) {
            for (var i = 0; i < array.Length; i++)
            {
                if (i != array.Length - 1)
                {
                    Console.Write(array[i] + " ,");
                }
                else
                {
                    Console.Write(array[i]);
                }
            }
        }

    }
}