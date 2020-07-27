package com.yogadarma.consumerapp.domain.usecases

import android.content.ContentValues
import android.net.Uri
import com.yogadarma.consumerapp.data.repositories.UserGithubRepository

class AddFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(favorite: ContentValues): Uri? = userGithubRepository.insertFavorite(favorite)
}