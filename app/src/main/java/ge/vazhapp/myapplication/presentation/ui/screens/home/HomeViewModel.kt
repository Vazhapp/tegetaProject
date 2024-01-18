package ge.vazhapp.myapplication.presentation.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ge.vazhapp.myapplication.common.Resource
import ge.vazhapp.myapplication.data.model.ColorsItem
import ge.vazhapp.myapplication.domain.usecase.GetAllColorsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllColorsUseCase: GetAllColorsUseCase
) : ViewModel() {

    private val _allColors = MutableStateFlow(listOf(ColorsItem()))
    val allColors = _allColors.asStateFlow()

    init {
        getAllColors()
    }


    private fun getAllColors() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = getAllColorsUseCase()) {
                is Resource.Success -> {
                    result.data?.let { _allColors.emit((it)) }
                }
                is Resource.Error -> {
                    // TODO e.g. error dialog
                }
            }
        }
    }

}