package mod.trindade.dev.ui.activities.settings

import android.*
import android.os.*
import android.content.*

import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.input.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.res.*

import mod.trindade.dev.ui.toolbar.*
import mod.trindade.dev.ui.theme.*
import mod.trindade.dev.ui.preferences.*

import com.sketchware.remod.R

class ModSettings : ComponentActivity() {

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
    fun getPreferences(): List<SwitchPreference> {
        return listOf(
            SwitchPreference(
                preference_name = stringResource(R.string.system_settings_title_setting_vibration),
                preference_description = stringResource(R.string.system_settings_description_setting_vibration),
                preference_id = 0,
                preference_default_value = true
            ),
            SwitchPreference(
                preference_name = stringResource(R.string.system_settings_title_automatically_save),
                preference_description = stringResource(R.string.system_settings_description_automatically_save),
                preference_id = 1,
                preference_default_value = false
            )
        )
    }

    @Composable
    fun Content() {
        val preferences = getPreferences()
        val sharedPreferences = getSharedPreferences("P12", Context.MODE_PRIVATE)

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
                    default = sharedPreferences.getBoolean("P12I${preference.preference_id}", preference.preference_default_value),
                    onChange = { isChecked ->
                        sharedPreferences.edit().putBoolean("P12I${preference.preference_id}", isChecked).apply()
                    }
                )
            }
        }
    }
}