package edu.neo.impl

import edu.neo.interfaces.IUser

class User : IUser {
    override fun validateUser(name: String, pass: String): Boolean {
// validar de una bde , o con rest ( retrofit2 ) ...
        return name.equals("dante") && pass.equals("123")
    }

    override fun validateLongPassword(cantPass: Int): String {
        // realizar logica que valide la longitud total de saraza!
        return cantPass.toString().length.toString()
    }


}