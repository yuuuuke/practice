package com.example.floatbutton.function10

import com.example.floatbutton.function10.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/15
 */
interface PageService {
    @GET("search/repositories?sort=stars&q=Android")
    suspend fun searchRepos(@Query("page") page: Int, @Query("per_page") perPage: Int): RepoResponse
}