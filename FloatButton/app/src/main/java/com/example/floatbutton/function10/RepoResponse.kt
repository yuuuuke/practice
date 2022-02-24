package com.example.floatbutton.function10

import com.google.gson.annotations.SerializedName

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/15
 */
class RepoResponse(
    @SerializedName("items") val items: List<Repo> = emptyList()
)