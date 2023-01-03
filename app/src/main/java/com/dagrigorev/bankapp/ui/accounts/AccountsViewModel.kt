package com.dagrigorev.bankapp.ui.accounts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dagrigorev.bankapp.data.account.AccountListElement
import com.dagrigorev.bankapp.data.account.AccountType
import java.io.Closeable
import java.time.Instant
import java.util.*

class AccountsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is accounts Fragment"
    }
    val text: LiveData<String> = _text
}