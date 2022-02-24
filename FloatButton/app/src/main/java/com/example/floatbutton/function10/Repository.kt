package com.example.floatbutton.function10

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.floatbutton.net.BaseHttpHelper
import kotlinx.coroutines.flow.Flow

/**
 * description:
 *b
 * @author zwp
 * @since 2021/9/15
 */
object Repository {

    private const val  PAGE_SIZE = 50

    private val service = BaseHttpHelper.create<PageService>()

    fun getPageData():Flow<PagingData<Repo>>{
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = {
                //数据源
                RepoPagingSource()
            }
        ).flow
    }
}