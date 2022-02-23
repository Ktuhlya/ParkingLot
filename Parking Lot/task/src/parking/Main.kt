package parking

import java.util.*
import kotlin.system.exitProcess

var placeMap = mutableMapOf<Int, String>()
var spot = 0
var carList = mutableListOf<String>()

const val EMPTY = "empty"

fun main() {

        carList.add(0, EMPTY)
    choNado()

}

fun choNado() {
  //  print("> ")
    val str = readLine() ?: error("hghgfttgb fgrg  fgewrgg")
    val inputList = str.split(" ").toList()

    when(inputList[0]) {

        "leave" -> {
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            } else {
                placeMap[inputList[1].toInt()] = EMPTY
                carList[inputList[1].toInt()] = EMPTY
                println("Spot ${inputList[1]} is free.")
                choNado()
            }
        }
        "park" -> {
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            } else {
                if (!placeMap.containsValue(EMPTY)) {
                    println("Sorry, the parking lot is full.")
                    choNado()
                } else {
                    var key = placeMap.keyOfValue(EMPTY)
                    placeMap[key] = inputList[2]
                    carList[key] = "$key ${inputList[1]} ${inputList[2].uppercase(Locale.getDefault())}"
                        //  println(placeMap)
                    println("${inputList[2]} car parked in spot ${key}.")
                    choNado()
                }
            }
        }
        "create" -> {
            placeMap.clear()
            carList.clear()
            carList.add(0, EMPTY)
            for (i in 1..inputList[1].toInt()) {
                placeMap.set(i, EMPTY)
                carList.add(i, EMPTY)
            }

            println("Created a parking lot with ${inputList[1]} spots.")
            choNado()
        }
        "status" -> {
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            }else{
            if (carList.count{it== EMPTY} < carList.size ) {

                for (i in 1 until carList.size) {
                    if (carList[i] != EMPTY) {
                        println(carList[i])
                    }
                }
                choNado()
            } else{
                println("Parking lot is empty.")
                choNado()
            }
        }
        }
        "spot_by_color" -> {
            var colorList= mutableListOf<Int>()
            var count = 0
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            }else{
                if (carList.count{it== EMPTY} < carList.size ) {
                    for (i in 1 until carList.size) {
                        if ((carList[i] != EMPTY)
                            && (carList[i].substringAfterLast(" ")
                                    == inputList[1].uppercase(Locale.getDefault()))) {
                            colorList.add(i)
                        }
                    }
                    if (colorList.isEmpty()){
                        println("No cars with color " +
                                "${inputList[1]} were found.")
                        choNado()
                    }else {
                        println(colorList.joinToString(", "))
                        choNado()
                    }
                } else{
                    println("Parking lot is empty.")
                    choNado()
                }
            }
        }
        "reg_by_color" -> {
            var colorList= mutableListOf<String>()
            var count = 0
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            }else{
                if (carList.count{it== EMPTY} < carList.size ) {
                    for (i in 1 until carList.size) {
                        if ((carList[i] != EMPTY)
                            && (carList[i].substringAfterLast(" ")
                                    == inputList[1].uppercase(Locale.getDefault()))) {
                            var tempList = carList[i].split(" ").toList()
                            colorList.add(tempList[1])
                        }
                    }
                    if (colorList.isEmpty()){
                        println("No cars with color" +
                                " ${inputList[1]} were found.")
                        choNado()
                    }else {
                        println(colorList.joinToString(", "))
                        choNado()
                    }
                } else{
                    println("Parking lot is empty.")
                    choNado()
                }
            }
        }
        "spot_by_reg" -> {
            var regList= mutableListOf<Int>()
            var count = 0
            if (placeMap.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
                choNado()
            }else{

                if (carList.count{it== EMPTY} < carList.size ) {
                    for (i in 1 until carList.size) {
                        var tempList = carList[i].split(" ").toList()
                        if ((carList[i] != EMPTY)
                            && (tempList[1]
                                    == inputList[1])) {
                            regList.add(i)
                        }
                    }
                    if (regList.isEmpty()){
                        println("No cars with registration " +
                                "number ${inputList[1]} were found.")
                        choNado()
                    }else{
                        println(regList.joinToString(", "))
                        choNado()
                    }
                }else{
                    println("Parking lot is empty.")
                    choNado()
                }
            }
        }



        "exit" -> exitProcess(0)
    }
}
fun MutableMap<Int, String>.keyOfValue (value: String) : Int {
    var tempList = this.toList().toMutableList()
    //println(tempList)
    var result = 0
    for (i in 0..19) {
        when(tempList[i].second ) {
            "empty" -> {
                result=tempList[i].first.toInt()
                break
            }
        }
    }
    return result
}

