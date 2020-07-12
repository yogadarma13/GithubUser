package com.yogadarma.githubuser.domain.usecases

import com.yogadarma.githubuser.data.repositories.UserGithubRepository
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Observable

class GetFollowerUserUseCase(
    private val userGithubRepository: UserGithubRepository,
    private val scheduler: SchedulerProvider
) {
    fun invoke(username: String): Observable<ArrayList<UserData>?> =
        userGithubRepository.getFollowerUser(username)
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.mainThread)
}