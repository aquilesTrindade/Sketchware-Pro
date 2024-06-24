package mod.trindade.dev.ui.activities.settings

import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mod.trindade.dev.ui.toolbar.topAppBarLarge
import mod.trindade.dev.ui.theme.TrindadeWareTheme
import mod.trindade.dev.ui.preferences.*

import com.sketchware.remod.R

class SystemSettings: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrindadeWareTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        Content()
                    }
                )
            }
        }
    }
    
    @Composable
    fun getPreferences(sharedPreferences: SharedPreferences): List<SwitchPreference> {
        return listOf(
            SwitchPreference(
                preference_name = stringResource(R.string.system_settings_title_setting_vibration),
                preference_description = stringResource(R.string.system_settings_description_setting_vibration),
                preference_id = 0,
                preference_default_value = sharedPreferences.getBoolean("P12I0", true),
                preference_change_status = { isChecked ->
                    sharedPreferences.edit().putBoolean("P12I0", isChecked).apply()
                }
            ),
            SwitchPreference(
                preference_name = stringResource(R.string.system_settings_title_automatically_save),
                preference_description = stringResource(R.string.system_settings_description_automatically_save),
                preference_id = 1,
                preference_default_value = sharedPreferences.getBoolean("P12I1", false),
                preference_change_status = { isChecked ->
                    sharedPreferences.edit().putBoolean("P12I1", isChecked).apply()
                }
            )
        )
    }

    @Composable
    fun Content() {
        val sharedPreferences = getSharedPreferences("P12", Context.MODE_PRIVATE)
        val preferences = getPreferences(sharedPreferences)

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            topAppBarLarge(
               title = "System Settings"
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                preferences.forEach { preference ->
                    SwitchPreferenceLayout(
                        name = preference.preference_name,
                        description = preference.preference_description,
                        id = preference.preference_id,
                        default = preference.preference_default_value,
                        onChange = preference.preference_change_status
                    )
                }
            }
        }
    }
}