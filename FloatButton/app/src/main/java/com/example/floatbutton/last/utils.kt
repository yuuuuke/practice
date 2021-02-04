package com.example.floatbutton.last

import android.content.Context


fun dp2px(context: Context, dp: Float): Float = dp * context.resources.displayMetrics.density

fun px2dp(context: Context, px: Float): Float = px / context.resources.displayMetrics.density
