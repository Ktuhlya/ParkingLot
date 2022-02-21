package parking

import kotlin.system.exitProcess

var placeMap = mutableMapOf<Int, String>()

fun main() {
    for (i in 1..20) placeMap.set(i, "empty")
    choNado()

}

fun choNado() {
  //  print("> ")
    val str = readln()
    val inputList = str.split(" ").toList()
    when(inputList[0]) {
        "leave" -> {
            placeMap[inputList[1].toInt()] = "empty"
            println("Spot ${inputList[1]} is free.")
            choNado()
        }
        "park" -> {
            if (!placeMap.containsValue("empty")) {
                println("Sorry, the parking lot is full.")
                choNado()
            }else{
                var key = placeMap.keyOfValue("empty")
                placeMap[key]  = inputList[2]
              //  println(placeMap)
                println("${inputList[2]} car parked in spot ${key}.")
                choNado()
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

