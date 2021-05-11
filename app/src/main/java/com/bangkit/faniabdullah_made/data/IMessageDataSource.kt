package com.bangkit.faniabdullah_made.data

import com.bangkit.faniabdullah_made.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}