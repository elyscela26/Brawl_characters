package uca.edu.brawlcharacters.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uca.edu.brawlcharacters.retrofit.BrawlerRetrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RetrofitModule {
    @Singleton
    @Provides
    fun providesGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api-cars-test.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun providePlaceService(retrofit: Retrofit.Builder): BrawlerRetrofit {
        return retrofit.build().create(BrawlerRetrofit::class.java)
    }
}