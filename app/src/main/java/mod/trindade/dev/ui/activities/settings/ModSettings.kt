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
    fun getPreferences(sharedPreferences: SharedPreferences): List<SwitchPreference> {
        return listOf(
            SwitchPreference(
                preference_name = "Built-in blocks",
                preference_description = "May slow down loading blocks in Logic Editor.",
                preference_id = 1,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Show all variable blocks",
                preference_description = "All variable blocks will be visible, even if you don't have variables for them.",
                preference_id = 2,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Show all blocks of palettes",
                preference_description = "Every single available block will be shown. Will slow down opening palettes!",
                preference_id = 3,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Use legacy Code Editor",
                preference_description = "Enables old Code Editor from v6.2.0.",
                preference_id = 4,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Install projects with root access",
                preference_description = "Automatically installs project APKs after building using root access.",
                preference_id = 5,
                preference_default_value = false,
                onChange = { isChecked ->
                    if (isChecked) {
                        // Shell.getShell {
                        //     if (!it.isRoot) {
                        //         // SketchwareUtil.toastError("Couldn't acquire root access")
                        //         // buttonView.setChecked(false)
                        //     }
                        // }
                    }
                }
            ),
            SwitchPreference(
                preference_name = "Launch projects after installing",
                preference_description = "Opens projects automatically after auto-installation using root.",
                preference_id = 6,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Use new Version Control",
                preference_description = "Enables custom version code and name for projects.",
                preference_id = 7,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            ),
            SwitchPreference(
                preference_name = "Enable block text input highlighting",
                preference_description = "Enables syntax highlighting while editing blocks' text parameters.",
                preference_id = 8,
                preference_default_value = false,
                onChange = { isChecked ->
                    
                }
            )
        )
    }

    @Composable
    fun getTextPreferences(): List<Preference> {
        return listOf(
            Preference(
                preference_name = "Backup directory",
                preference_description = "The default directory is /Internal storage/.sketchware/backups/.",
                preference_id = 1,
                onClick = {
                    // Handle Backup Directory click
                }
            ),
            Preference(
                preference_name = "Backup filename format",
                preference_description = "Default is \"\$projectName v\$versionName (\$pkgName, \$versionCode) \$time(yyyy-MM-dd'T'HHmmss)\"",
                preference_id = 2,
                onClick = {
                    // Handle Backup Filename Format click
                }
            )
        )
    }

    @Composable
    fun Content() {
        val sharedPreferences = getSharedPreferences("P12", Context.MODE_PRIVATE)
        val switchPreferences = getPreferences(sharedPreferences)
        val textPreferences = getTextPreferences()

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            topAppBarLarge(
                title = "Mod Settings"
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                switchPreferences.forEach { preference ->
                    SwitchPreferenceLayout(
                        name = preference.preference_name,
                        description = preference.preference_description,
                        id = preference.preference_id,
                        default = preference.preference_default_value,
                        onChange = preference.onChange
                    )
                }

                textPreferences.forEach { preference ->
                    TextPreferenceLayout(
                        name = preference.preference_name,
                        description = preference.preference_description,
                        id = preference.preference_id,
                        onClick = preference.onClick
                    )
                }
            }
        }
    }
}