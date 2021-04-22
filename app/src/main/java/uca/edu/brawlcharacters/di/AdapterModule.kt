package uca.edu.brawlcharacters.di

import android.app.Application
import uca.edu.brawlcharacters.utils.AdapterBrawl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterBrawl{
        return AdapterBrawl()
    }
}