package com.yogadarma.githubuser.domain.usecases

import androidx.lifecycle.LiveData
import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.entity.Favorite

class GetFavoriteUseCase(
    private val userGithubRepository: UserGithubRepository
) {
    fun invoke(): LiveData<List<Favorite>> = userGithubRepository.getAllFavorite()
}