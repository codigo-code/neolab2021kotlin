package edu.neo

import edu.neo.interfaces.IUser
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val user: IUser = Mockito.mock(IUser::class.java)

    @Before
    fun initializateElements(){
        Mockito.`when`(user.validateUser("mockito","moco")).thenReturn(true)
        Mockito.`when`(user.validateLongPassword(10)).thenReturn("10 es la logintud")

    }


    @Test
    fun loginUser() {

        assertEquals(user.validateUser("mockito","moco"), true)
    }


    @Test
    fun validarLogitud(){
        assertEquals(user.validateLongPassword(10),"9 es la logintud")
    }
}