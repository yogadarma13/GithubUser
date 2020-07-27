package com.yogadarma.consumerapp.domain.usecases

import com.yogadarma.consumerapp.data.repositories.UserGithubRepository

class DeleteFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(id: Int): Int = userGithubRepository.deleteFavorite(id)
}