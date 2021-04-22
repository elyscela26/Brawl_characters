package uca.edu.brawlcharacters.di

import uca.edu.brawlcharacters.retrofit.NetworkMapper
import uca.edu.brawlcharacters.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.brawlcharacters.repository.BrawlRepository
import uca.edu.brawlcharacters.retrofit.BrawlRetrofit
import uca.edu.brawlcharacters.room.BrawlDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBrawlRepository(
            brawlDao: BrawlDao,
            brawlRetrofit: BrawlRetrofit,
            cacheMapper: CacheMapper,
            networkMapper: NetworkMapper
    ): BrawlRepository {
        return BrawlRepository(brawlDao, brawlRetrofit, cacheMapper, networkMapper)
    }
}