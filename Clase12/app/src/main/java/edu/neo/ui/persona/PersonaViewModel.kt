package edu.neo.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is persona Fragment"
    }
    val text: LiveData<String> = _text
}