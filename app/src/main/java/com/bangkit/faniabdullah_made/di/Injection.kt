package com.bangkit.faniabdullah_made.di

import com.bangkit.faniabdullah_made.data.IMessageDataSource
import com.bangkit.faniabdullah_made.data.MessageDataSource
import com.bangkit.faniabdullah_made.data.MessageRepository
import com.bangkit.faniabdullah_made.domain.IMessageRepository
import com.bangkit.faniabdullah_made.domain.MessageInteractor
import com.bangkit.faniabdullah_made.domain.MessageUseCase
object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}