package uca.edu.brawlcharacters.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brawl_per")
class BrawlerCacheEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "image")
    var image: String
    
)
