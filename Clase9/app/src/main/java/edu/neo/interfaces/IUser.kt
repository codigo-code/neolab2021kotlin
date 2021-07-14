package edu.neo.interfaces

interface IUser {
    fun validateUser(name:String, pass:String) : Boolean


    fun validateLongPassword(cantPass:Int):String
}