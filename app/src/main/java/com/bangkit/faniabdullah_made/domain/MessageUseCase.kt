package com.bangkit.faniabdullah_made.domain

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}