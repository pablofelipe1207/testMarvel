package com.pfmiranda.testMarvel.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pfmiranda.testMarvel.models.CharacterRepository
import com.pfmiranda.testMarvel.models.Characters
import org.koin.dsl.module


val viewModelModule = module {
    factory { MainViewModel(get()) }
}

class MainViewModel(private val characterRepository: CharacterRepository) : ViewModel(){

    val characters: LiveData<Characters> = liveData {
        val data = characterRepository.getCharacters()
        emit(data)
    }

}