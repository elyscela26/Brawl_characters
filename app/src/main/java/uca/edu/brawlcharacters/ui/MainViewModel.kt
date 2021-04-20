package uca.edu.brawlcharacters.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import uca.edu.brawlcharacters.intent.Intent
import uca.edu.brawlcharacters.repository.BrawlerRepository
import uca.edu.brawlcharacters.utils.DataState
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject constructor(
    private val placeRepository: BrawlerRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    val userIntent = Channel<Intent>(Channel.UNLIMITED)
    private val _dataState= MutableStateFlow<DataState>(DataState.Idle)

    val dataState: StateFlow<DataState>
        get() = _dataState
    init {
        setStateEvent()
    }
    fun setStateEvent(){
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect{intn ->
                when(intn){
                    is Intent.GetBrawlerEvent -> {
                        placeRepository.getBrawler()
                            .onEach {
                                _dataState.value = it
                            }
                            .launchIn(viewModelScope)
                    }
                    Intent.None -> {

                    }
                }

            }
        }
    }
}