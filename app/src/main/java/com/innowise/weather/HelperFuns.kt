package com.innowise.weather

import android.content.Context
import androidx.annotation.StringRes
import com.innowise.weather.app.ServiceLocator

object HelperFuns {
    fun getString(@StringRes strId: Int, vararg args: Any): String =
        ServiceLocator.get(Context::class).getString(strId, *args)
}