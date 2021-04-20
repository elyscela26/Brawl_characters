package uca.edu.brawlcharacters.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uca.edu.brawlcharacters.retrofit.BrawlerRetrofit
import uca.edu.brawlcharacters.retrofit.NetworkMapper
import uca.edu.brawlcharacters.room.BrawlerDao
import uca.edu.brawlcharacters.room.CacheMapper
import uca.edu.brawlcharacters.utils.DataState

class BrawlerRepository constructor(
    private val brawlerDao : BrawlerDao,
    private val brawlerRetrofit: BrawlerRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getBrawler(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val brawlerData = brawlerRetrofit.get()
            val brawlerMap = networkMapper.mapFromEntityList(brawlerData)
            for (tempBrawl in brawlerMap){
                brawlerDao.insert(cacheMapper.mapToEntity(tempBrawl))
            }
            val cacheBrawl = brawlerDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheBrawl)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}