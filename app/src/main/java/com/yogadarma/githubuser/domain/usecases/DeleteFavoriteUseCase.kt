package com.yogadarma.githubuser.domain.usecases

import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.entity.UserData

class DeleteFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
        fun invoke(id: Int): Int = userGithubRepository.deleteFavorite(id)
}