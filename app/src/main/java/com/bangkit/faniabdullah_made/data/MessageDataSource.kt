package com.bangkit.faniabdullah_made.data

import com.bangkit.faniabdullah_made.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String) =
        MessageEntity("Hello $name! Welcome to Clean Architecture")
}