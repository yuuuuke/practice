package com.example.floatbutton.last

import android.content.Context
import android.R.attr.key
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import javax.crypto.Cipher


fun dp2px(context: Context, dp: Float): Float = dp * context.resources.displayMetrics.density

fun px2dp(context: Context, px: Float): Float = px / context.resources.displayMetrics.density
