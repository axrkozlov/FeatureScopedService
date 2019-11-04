package com.secondhands.navigationexamproject.ui

import android.util.Log
import androidx.lifecycle.*
import com.secondhands.navigationexamproject.domain.GetConcertsUseCase
import com.secondhands.navigationexamproject.entity.ApiResponse
import com.secondhands.navigationexamproject.entity.ConcertItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class ListViewModel(
    private val getConcertsUseCase: GetConcertsUseCase
) : ViewModel() {

    private val _concertResponse = MutableLiveData<ApiResponse>()
    val concertResponse: LiveData<ApiResponse> = _concertResponse

    private val _concertList = MutableLiveData<List<ConcertItem>>()
    val concertList: LiveData<List<ConcertItem>> = _concertList

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _toastText = MutableLiveData<String>()
    val toastText: LiveData<String> = _toastText

    init {
        loadConcerts()
    }

    fun loadConcerts() {
        _dataLoading.value = true

        viewModelScope.launch {
            getConcertsUseCase.invoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _concertResponse.value = it
                    _concertList.value = it.apiBody.perforList
                },{
                    Log.e("LOG>>", "Error : $it")
                })

            _dataLoading.value = false
        }
    }

}
