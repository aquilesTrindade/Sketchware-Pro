package mod.trindade.dev.ui.preferences

import android.content.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
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
fun SwitchPreferenceLayout(
    name: String,
    description: String,
    id: Int,
    default: Boolean,
    onChange: (isChecked: Boolean) -> Unit
) {
    var switchState by remember { mutableStateOf(default) }

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
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.weight(1f))
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