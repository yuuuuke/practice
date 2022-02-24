package com.example.floatbutton.function10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/15
 */
class Function10ViewModel: ViewModel() {

    fun getPagingData(): Flow<PagingData<Repo>>{
        return Repository.getPageData().cachedIn(viewModelScope)
    }
}