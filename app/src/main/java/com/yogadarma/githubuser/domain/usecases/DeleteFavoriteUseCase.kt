package com.yogadarma.githubuser.domain.usecases

import com.yogadarma.githubuser.data.repositories.UserGithubRepository

class DeleteFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(id: Int): Int = userGithubRepository.deleteFavorite(id)
}