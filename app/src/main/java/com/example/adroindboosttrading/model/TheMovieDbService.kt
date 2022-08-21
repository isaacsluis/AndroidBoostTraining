package com.example.adroindboosttrading.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface TheMovieDbService {

    @GET("movie/popular")
    fun listPopularMovies(@Query("api_key")apiKey:String):Call<MovieDBResult>
}