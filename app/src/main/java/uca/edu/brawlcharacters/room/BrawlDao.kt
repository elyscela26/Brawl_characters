package uca.edu.brawlcharacters.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BrawlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: BrawlCacheEntity): Long
    @Query("select * from brawlers")
    suspend fun get(): List<BrawlCacheEntity>
}