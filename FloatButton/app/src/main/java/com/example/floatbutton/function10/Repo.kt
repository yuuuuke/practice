package com.example.floatbutton.function10

import com.google.gson.annotations.SerializedName

/**
 * description:
 *
 * @author zwp
 * @since 2021/9/15
 */
data class Repo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val starCount: Int
)

