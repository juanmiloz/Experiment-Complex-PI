"use strict"

var test1 = new Array(5, 1, 4, 2, 8, 9);
experiment(test1)

function experiment(array){
    /*var microprofilter = require('microprofiler');
    var start = microprofilter.start();
    
    printArray(bubbleSort(test1)); 

    var time = microprofiler.measureFrom(start);*/
    console.time('loop');
    printArray(bubbleSort(test1)); 
    console.log("\nTiempo de ejecucion: ");
    var time = console.timeEnd('loop');
}

function bubbleSort(array){
    for(var i = 0; i < array.length; i++){
        for(var j = 0; j < array.length-1; j++){
            if(array[j]>array[j+1]){
                let temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
}

function printArray(array){
    let answer = "";
    for(var i = 0; i < array.length; i++){
        if(i != array.length-1){
            answer += array[i] + " ,";
        }else{
            answer += array[i];
        }
    }
    console.log(answer)
}