package uca.edu.brawlcharacters.utils

import uca.edu.brawlcharacters.model.Brawl
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val brawls:List<Brawl>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()

}
