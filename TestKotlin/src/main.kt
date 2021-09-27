import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.PrintWriter


val arr10: MutableList<Int> = ArrayList()
val arr100: MutableList<Int> = ArrayList()
val arr1000: MutableList<Int> = ArrayList()
val arr10000: MutableList<Int> = ArrayList()
val times1: MutableList<Double> = ArrayList()
val times2: MutableList<Double> = ArrayList()
val times3: MutableList<Double> = ArrayList()
val times4: MutableList<Double> = ArrayList()
var timeProm1: Double = 0.0
var timeProm2: Double = 0.0
var timeProm3: Double = 0.0
var timeProm4: Double = 0.0

fun main(){
    //println("\nTiempo de ejecucion: ${experiment(test1)} seg")
    loadArray1("./src/data/array1.csv")
    loadArray2("./src/data/array2.csv")
    loadArray3("./src/data/array3.csv")
    loadArray4("./src/data/array4.csv")
    initializeExperiment()
    exportResults()
}

fun exportResults() {
    try {
        PrintWriter(File("./src/results.csv")).use { writer ->
            val sb = StringBuilder()
            val arr1 = times1.toDoubleArray()
            val arr2 = times2.toDoubleArray()
            val arr3 = times3.toDoubleArray()
            val arr4 = times4.toDoubleArray()
            for (c in 0..99) {
                timeProm1 += arr1[c]
                sb.append(arr1[c].toString() + ",")
            }
            sb.append("\n")
            for (c in 0..99) {
                timeProm2 += arr2[c]
                sb.append(arr2[c].toString() + ",")
            }
            sb.append("\n")
            for (c in 0..99) {
                timeProm3 += arr3[c]
                sb.append(arr3[c].toString() + ",")
            }
            sb.append("\n")
            for (c in 0..99) {
                timeProm4 += arr4[c]
                sb.append(arr4[c].toString() + ",")
            }
            sb.append("\n")
            sb.append("Promedio 10^1: " + (timeProm1 / 100))
            sb.append("\n")
            sb.append("Promedio 10^2: " + (timeProm2 / 100))
            sb.append("\n")
            sb.append("Promedio 10^3: " + (timeProm3 / 100))
            sb.append("\n")
            sb.append("Promedio 10^4: " + (timeProm4 / 100))
            sb.append("\n")
            writer.write(sb.toString())
            println("done!")
        }
    } catch (e: FileNotFoundException) {
        println(e.message)
    }
}

fun initializeExperiment() {
    for (c in 0..100) {
        val start = System.currentTimeMillis()
        bubbleSort(arr10.toIntArray())
        val end = System.currentTimeMillis()
        times1.add((end - start).toDouble())
    }
    for (c in 0..100) {
        val start = System.currentTimeMillis()
        bubbleSort(arr100.toIntArray())
        val end = System.currentTimeMillis()
        times2.add((end - start).toDouble())
    }
    for (c in 0..100) {
        val start = System.currentTimeMillis()
        bubbleSort(arr1000.toIntArray())
        val end = System.currentTimeMillis()
        times3.add((end - start).toDouble())
    }
    for (c in 0..100) {
        val start = System.currentTimeMillis()
        bubbleSort(arr10000.toIntArray())
        val end = System.currentTimeMillis()
        times4.add((end - start).toDouble())
        println(c)
    }
}

fun loadArray1(path: String) {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines {
            lines -> lines.forEach {
                lineList.add(it)
            }
    }
    lineList.forEach {
        var line = listOf<String>()
        line = it.toString().split(",")
        line.forEach {
            arr10.add(it.toInt())
        }
    }
}

fun loadArray2(path: String) {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines {
            lines -> lines.forEach {
        lineList.add(it.trim())
    }
    }
    lineList.forEach {
        var line = listOf<String>()
        line = it.toString().split(",")
        line.forEach {
            arr100.add(it.trim().toInt())
        }
    }
}

fun loadArray3(path: String) {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines {
            lines -> lines.forEach {
        lineList.add(it)
    }
    }
    lineList.forEach {
        var line = listOf<String>()
        line = it.toString().split(",")
        line.forEach {
            arr1000.add(it.trim().toInt())
        }
    }
}

fun loadArray4(path: String) {
    val inputStream: InputStream = File(path).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().useLines {
            lines -> lines.forEach {
        lineList.add(it)
    }
    }
    lineList.forEach {
        var line = listOf<String>()
        line = it.toString().split(",")
        line.forEach {
            arr10000.add(it.trim().toInt())
        }
    }
}

fun experiment(test: IntArray): Double {
    val start = System.currentTimeMillis()
    bubbleSort(test)
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
