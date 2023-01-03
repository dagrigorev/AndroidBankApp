package com.dagrigorev.bankapp.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "No products available"
    }
    val text: LiveData<String> = _text
}