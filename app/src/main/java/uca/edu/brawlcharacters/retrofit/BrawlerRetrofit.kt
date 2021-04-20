package uca.edu.brawlcharacters.retrofit

import retrofit2.http.GET

interface BrawlerRetrofit {
    @GET("brawl_per")
    suspend fun get () : List<BrawlerNetworkEntity>
}