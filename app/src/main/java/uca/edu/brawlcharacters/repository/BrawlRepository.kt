package uca.edu.brawlcharacters.repository

import uca.edu.brawlcharacters.retrofit.NetworkMapper
import uca.edu.brawlcharacters.room.CacheMapper
import uca.edu.brawlcharacters.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uca.edu.brawlcharacters.retrofit.BrawlRetrofit
import uca.edu.brawlcharacters.room.BrawlDao
import java.lang.Exception

class BrawlRepository constructor(
        private val brawlDao : BrawlDao,
        private val brawlRetrofit: BrawlRetrofit,
        private val cacheMapper: CacheMapper,
        private val networkMapper: NetworkMapper
){
    suspend fun getBrawls(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val brawlData = brawlRetrofit.get()
            val brawlMap = networkMapper.mapFromEntityList(brawlData)
            for (tempBrawl in brawlMap){
                brawlDao.insert(cacheMapper.mapToEntity(tempBrawl))
            }
            val cachePla = brawlDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachePla)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}