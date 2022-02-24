package com.example.floatbutton.function10

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.floatbutton.net.BaseHttpHelper
import java.lang.Exception

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/15
 */
class RepoPagingSource: PagingSource<Int, Repo>() {

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        return try{
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val repoResponse = BaseHttpHelper.create<PageService>().searchRepos(page,pageSize)
            val repoItems = repoResponse.items
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (repoItems.isNotEmpty()) page + 1 else null
            LoadResult.Page(repoItems,prevKey,nextKey)
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}