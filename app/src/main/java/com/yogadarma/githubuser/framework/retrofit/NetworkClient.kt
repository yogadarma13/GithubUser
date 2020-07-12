package com.yogadarma.githubuser.framework.retrofit

import android.content.Context
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkClient {

    companion object {
        private var retrofit: Retrofit? = null

        private fun interceptor(): Interceptor {
            return Interceptor { chain ->
                var request = chain.request().newBuilder()
                    .header("Authorization", "token ff73b0b5d43bb65130e5666e0a8ee8a3ec604af2")
                    .build()

                val response = chain.proceed(request)
                response
            }
        }

        fun provideRetrofit(context: Context): Retrofit? {
            if (retrofit == null) {
                val httpClientBuilder = OkHttpClient.Builder()
                    .addNetworkInterceptor(interceptor())

                httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
                httpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
                httpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)

                val client = httpClientBuilder.build()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
            }

            return retrofit
        }

        fun provideNetworkApi(retrofit: Retrofit): NetworkApi =
            retrofit.create(NetworkApi::class.java)
    }
}