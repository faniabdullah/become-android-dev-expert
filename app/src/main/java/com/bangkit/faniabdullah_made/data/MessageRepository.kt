package com.bangkit.faniabdullah_made.data

import com.bangkit.faniabdullah_made.domain.IMessageRepository

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {
    override fun getWelcomeMessage(name: String) = messageDataSource.getMessageFromSource(name)
}