package uca.edu.brawlcharacters.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.brawlcharacters.repository.BrawlerRepository
import uca.edu.brawlcharacters.retrofit.BrawlerRetrofit
import uca.edu.brawlcharacters.retrofit.NetworkMapper
import uca.edu.brawlcharacters.room.BrawlerDao
import uca.edu.brawlcharacters.room.CacheMapper
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBrawlerRepository(
        brawlerDao: BrawlerDao,
        brawlerRetrofit: BrawlerRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): BrawlerRepository {
        return BrawlerRepository(brawlerDao, brawlerRetrofit, cacheMapper, networkMapper)
    }
}