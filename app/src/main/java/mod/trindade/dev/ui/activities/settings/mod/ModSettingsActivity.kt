package mod.trindade.dev.ui.activities.settings.mod

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
}    