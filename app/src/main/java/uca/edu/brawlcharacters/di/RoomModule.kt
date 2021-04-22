package uca.edu.brawlcharacters.di

import android.content.Context
import androidx.room.Room
import uca.edu.brawlcharacters.room.BrawlDao
import uca.edu.brawlcharacters.room.BrawlDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providePlaceDb(@ApplicationContext context: Context): BrawlDatabase{
        return Room.databaseBuilder(context, BrawlDatabase::class.java, BrawlDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePlaceDao(brawlDatabase: BrawlDatabase): BrawlDao{
        return brawlDatabase.brawlDao()
    }
}