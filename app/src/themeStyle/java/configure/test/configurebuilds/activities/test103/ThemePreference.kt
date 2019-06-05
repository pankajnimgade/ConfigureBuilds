package configure.test.configurebuilds.activities.test103

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Pankaj Nimgade on 5/26/2019.
 */
class ThemePreference private constructor(application: Application) {

    private lateinit var sharedPreferences: SharedPreferences

    companion object {

        private var INSTANCE: ThemePreference? = null

        private const val THEME_PREFERENCE_FILE_NAME = "THEME_PREFERENCE"

        fun getInstance(application: Application): ThemePreference {

            if (INSTANCE == null) {
                INSTANCE = ThemePreference(application)
                INSTANCE?.sharedPreferences =
                        application.getSharedPreferences(THEME_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
            }
            return INSTANCE!!
        }

    }

    fun getThemeMode(): Int {
        return sharedPreferences.getInt(ThemeSharedPreferencesKeys.THEME_MODE.key, AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
    }

    fun saveThemeMode(themeMode: ThemeMode) {
        sharedPreferences.edit().putInt(ThemeSharedPreferencesKeys.THEME_MODE.key, themeMode.themeMode).apply()
    }

}

enum class ThemeSharedPreferencesKeys(val key: String) {

    THEME_MODE("THEME_MODE")
}

enum class ThemeMode(val themeMode: Int) {

    DAY_LIGHT(AppCompatDelegate.MODE_NIGHT_NO),
    NIGHT_DARK(AppCompatDelegate.MODE_NIGHT_YES),
    SYSTEM_AUTO(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
}