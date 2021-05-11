package com.bangkit.faniabdullah_made.presentasion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.faniabdullah_made.domain.MessageEntity
import com.bangkit.faniabdullah_made.domain.MessageUseCase

class MainViewModel(private val messageUseCase: MessageUseCase) : ViewModel() {
    private val _message = MutableLiveData<MessageEntity>()
    val message: LiveData<MessageEntity>
        get() = _message

    fun setName(name: String) {
        _message.value = messageUseCase.getMessage(name)
    }
}