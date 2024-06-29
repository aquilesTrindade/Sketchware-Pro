package mod.trindade.dev.ui.preferences

import android.content.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.res.*

data class SwitchPreference(
    val preference_name: String,
    val preference_description: String,
    val preference_id: Int,
    val preference_default_value: Boolean
)

@Composable
fun SwitchPreference(
    name: String,
    description: String,
    id: Int,
    default: Boolean,
    onChange: (isChecked: Boolean) -> Unit
) {
    
    var switchState by remember { mutableStateOf(savedValue) }

    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1
                )
            }
            Switch(
                checked = switchState,
                onCheckedChange = { isChecked ->
                    switchState = isChecked
                    onChange(isChecked)
                }
            )
        }
    }
}