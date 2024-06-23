package mod.trindade.dev.ui.settings

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

class SystemSettings : ComponentActivity() {

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
                name = stringResource(R.string.system_settings_title_setting_vibration),
                description = stringResource(R.string.system_settings_description_setting_vibration),
                id = 0,
                default = true,
                onChange = { isChecked ->
                    val sharedPreferences = getSharedPreferences("P12", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("P12I0", isChecked).apply()
                }
            ),
            SwitchPreference(
                name = stringResource(R.string.system_settings_title_automatically_save),
                description = stringResource(R.string.system_settings_description_automatically_save),
                id = 0,
                default = false,
                onChange = { isChecked ->
                    val sharedPreferences = getSharedPreferences("P12", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("P12I2", isChecked).apply()
                }
            )
        )
    }

    @Composable
    fun Content() {
        val preferences = getPreferences()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            preferences.forEach { preference ->
                SwitchPreferenceLayout(
                    name = preference.name,
                    description = preference.description,
                    id = preference.id,
                    default = preference.default,
                    onChange = preference.onChange
                )
            }
        }
    }
}