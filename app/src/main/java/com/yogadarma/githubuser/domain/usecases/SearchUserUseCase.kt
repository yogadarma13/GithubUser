package com.yogadarma.githubuser.domain.usecases

import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.responses.SearchUserResponse
import com.yogadarma.githubuser.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Observable

class SearchUserUseCase(
    private val userGithubRepository: UserGithubRepository,
    private val scheduler: SchedulerProvider
) {
    fun invoke(username: String): Observable<SearchUserResponse> =
        userGithubRepository.searchUser(username)
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.mainThread)
}