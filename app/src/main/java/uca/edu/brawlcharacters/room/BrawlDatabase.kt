package uca.edu.brawlcharacters.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BrawlCacheEntity::class], version = 1)
abstract class BrawlDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "BrawlDB"
    }
    abstract fun brawlDao() : BrawlDao
}