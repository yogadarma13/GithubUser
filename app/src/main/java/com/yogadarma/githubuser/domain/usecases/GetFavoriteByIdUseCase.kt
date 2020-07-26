package com.yogadarma.githubuser.domain.usecases

import android.database.Cursor
import com.yogadarma.githubuser.data.repositories.UserGithubRepository

class GetFavoriteByIdUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(id: Int): Cursor? = userGithubRepository.getFavoriteById(id)
}