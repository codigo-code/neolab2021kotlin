package edu.neo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {



    // mutable ( cambia su valor )
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    // LiveData = inmutabilidad
    val text: LiveData<String> = _text
}