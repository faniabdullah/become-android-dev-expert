package com.bangkit.faniabdullah_made.domain

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}