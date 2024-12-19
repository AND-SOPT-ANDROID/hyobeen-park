package org.sopt.and.core.preference

import android.content.Context
import androidx.compose.runtime.staticCompositionLocalOf
import dagger.hilt.android.qualifiers.ApplicationContext

class PreferenceImpl(
    @ApplicationContext private val context: Context
) {
    private val preference = context.getSharedPreferences(
        PREF_NAME, Context.MODE_PRIVATE
    )

    var token: String
        get() = preference.getString(TOKEN, "").toString()
        set(value) = preference.edit().putString(TOKEN, value).apply()

    companion object{
        private const val PREF_NAME = "wavve_prefs"
        private const val TOKEN = "token"

        val LocalPreference = staticCompositionLocalOf<PreferenceImpl> {
            error("Preference Failed")
        }
    }
}