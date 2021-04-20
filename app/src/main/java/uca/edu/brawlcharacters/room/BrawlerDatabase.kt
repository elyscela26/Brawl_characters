package uca.edu.brawlcharacters.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BrawlerCacheEntity::class], version = 1)
abstract class BrawlerDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "BrawlerDB"
    }
    abstract fun brawlerDao() : BrawlerDao
}