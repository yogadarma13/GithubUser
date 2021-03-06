package com.yogadarma.consumerapp.domain.usecases

import com.yogadarma.consumerapp.data.repositories.UserGithubRepository
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Observable

class GetFollowingUserUseCase(
    private val userGithubRepository: UserGithubRepository,
    private val scheduler: SchedulerProvider
) {
    fun invoke(username: String): Observable<ArrayList<UserData>?> =
        userGithubRepository.getFollowingUser(username)
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.mainThread)
}