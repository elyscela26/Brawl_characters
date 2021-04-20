package uca.edu.brawlcharacters.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import uca.edu.brawlcharacters.room.BrawlerDao
import uca.edu.brawlcharacters.room.BrawlerDatabase
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideBrawlerDb(@ApplicationContext context: Context): BrawlerDatabase {
        return Room.databaseBuilder(context, BrawlerDatabase::class.java, BrawlerDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideBrawlerDao(brawlerDatabase: BrawlerDatabase): BrawlerDao {
        return brawlerDatabase.brawlerDao()
    }
}