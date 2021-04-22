package uca.edu.brawlcharacters.retrofit

import retrofit2.http.GET

interface BrawlRetrofit {
    @GET("brawlers_legendarios")
    suspend fun get () : List<BrawlNetworkEntity>
}