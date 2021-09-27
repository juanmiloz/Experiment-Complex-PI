var test1:IntArray = intArrayOf(5, 1, 4, 2, 8, 9)

fun main(){
    println("\nTiempo de ejecucion: ${experiment(test1)} seg")
}

fun experiment(test: IntArray): Double {
    val start = System.currentTimeMillis()
    printArray(bubbleSort(test))
    val end = System.currentTimeMillis()
    return ((end - start) / 1000).toDouble()
}

fun bubbleSort(array:IntArray):IntArray{

    for(i in array.indices){
        for(j in 0..array.size-2){
            if(array[j] > array[j+1]){
                var temp = array[j+1]
                array[j+1] = array[j]
                array[j] = temp
            }
        }
    }

    return array
}

fun printArray(array:IntArray){
    for (i in array.indices) {
        if (i != array.size-1) {
            print(array.get(i).toString() + " ,")
        } else {
            print(array.get(i))
        }
    }
}