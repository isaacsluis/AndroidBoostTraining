package com.example.adroindboosttrading.model

data class MovieDBResult(
    val page: Int,
    val results: List<MovieDb>,
    val total_pages: Int,
    val total_results: Int
)