package com.example.myapplication

import android.app.Activity

class MainActivity() {
    var oldName: String? = "oldName"
    var nullName: String? = null
    lateinit var lateName: String
    val title: NewSealedClass = NewSealedClass.Worker as NewSealedClass
    val position: Int = 1

    fun main() {
        val myName: String = oldName ?: "newName"
        println(myName) // -> oldName

        val newName: String = nullName ?: "NotNullName"
        println(newName) // -> NotNullName

        lateName = "lateName"
        println(lateName)

        when (lateName) {
            "newName" -> {
            }
            "oldName" -> {
            }
        }

        when {
            lateName == "abcd" -> {}
            position == 2 -> {}
            // Unhandle case
            else -> {
//                TODO : handle something
            }
        }
    }

    fun getCount(number: Int) : Int = (number + 1)
    fun getName() : Pair<String,Int> = "name" to 1
    fun getTriple() : Triple<String,String,String> = Triple("1","2","3")

    fun filterList() {
        var filterFun : (Int) -> Boolean = {number -> number == 4}
        val listPoint = listOf(1,4,5,6,4,9)
//        can be like this
//        println(listPoint.filter { number : Int -> number == 4 })
        println(listPoint.filter{it == 4})
        println(listPoint.filter(filterFun))
        listPoint.forEach { point -> println(point) }
        listPoint.forEachIndexed{index, i -> println("Point is " + listPoint[index])}

        val listAge : List<Age> = listPoint.map{point -> Age(point)}
    }

    fun extensionStringName() {
        var myName = "abcdef"
        println(myName.formatName())
    }
}

// extension to string class
fun String.formatName() : String {
    return "$this abdcdef"
}

data class NewReturn(val name: String, val age : Int) {

}

sealed class NewSealedClass{
    object Worker : NewSealedClass()
    object Boss : NewSealedClass()
}

class Age(val age: Int){

}