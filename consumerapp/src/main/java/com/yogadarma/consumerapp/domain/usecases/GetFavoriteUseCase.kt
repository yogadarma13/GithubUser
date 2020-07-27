package com.yogadarma.consumerapp.domain.usecases

import android.database.Cursor
import com.yogadarma.consumerapp.data.repositories.UserGithubRepository

class GetFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(): Cursor? = userGithubRepository.getAllFavorite()
}