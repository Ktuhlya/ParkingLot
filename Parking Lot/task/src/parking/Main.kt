package parking

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
                    carList[key] = "$key ${inputList[1]} ${inputList[2]}"
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

