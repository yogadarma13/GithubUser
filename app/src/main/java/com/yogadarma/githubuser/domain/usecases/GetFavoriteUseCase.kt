package com.yogadarma.githubuser.domain.usecases

import android.database.Cursor
import com.yogadarma.githubuser.data.repositories.UserGithubRepository

class GetFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(): Cursor? = userGithubRepository.getAllFavorite()
}