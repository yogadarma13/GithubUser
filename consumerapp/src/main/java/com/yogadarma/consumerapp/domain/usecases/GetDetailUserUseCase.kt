package com.yogadarma.consumerapp.domain.usecases

import com.yogadarma.consumerapp.data.repositories.UserGithubRepository
import com.yogadarma.consumerapp.domain.responses.DetailUserResponse
import com.yogadarma.consumerapp.rx.SchedulerProvider
import io.reactivex.rxjava3.core.Observable

class GetDetailUserUseCase(
    private val userGithubRepository: UserGithubRepository,
    private val scheduler: SchedulerProvider
) {
    fun invoke(username: String): Observable<DetailUserResponse> =
        userGithubRepository.getDetailUser(username)
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.mainThread)
}