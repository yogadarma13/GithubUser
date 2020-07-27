package com.yogadarma.consumerapp.domain.usecases

import android.database.Cursor
import com.yogadarma.consumerapp.data.repositories.UserGithubRepository

class GetFavoriteByIdUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(id: Int): Cursor? = userGithubRepository.getFavoriteById(id)
}