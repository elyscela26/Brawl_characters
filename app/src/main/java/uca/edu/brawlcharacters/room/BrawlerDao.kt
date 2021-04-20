package uca.edu.brawlcharacters.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BrawlerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: BrawlerCacheEntity): Long
    @Query("select * from brawl_per")
    suspend fun get(): List<BrawlerCacheEntity>
}