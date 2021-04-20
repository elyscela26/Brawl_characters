package uca.edu.brawlcharacters.utils

import uca.edu.brawlcharacters.model.Brawler
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val brawler:List<Brawler>): DataState()
    data class Error (val exception: Exception): DataState()
    object Loading: DataState()
}