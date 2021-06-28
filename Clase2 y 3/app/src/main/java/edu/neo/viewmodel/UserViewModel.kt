package edu.neo.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import edu.neo.model.User

// asemeja a un controlador
class UserViewModel : ViewModel() {

    var userList: ArrayList<User> = ArrayList<User>()

    fun vilidateUser(user: User): User? {

        userList.forEach({

            if (it.username.equals(user.username) && it.password.equals(user.password)) {
                return it
            }
        })

        return null
    }


    fun saveUser(username: String, password: String) {
        // TODO: logica x para guardar
        userList.add(User(username, password))
    }
}