package mod.trindade.dev.ui.preferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.text.font.*

data class Preference(
    val preference_name: String,
    val preference_description: String,
    val preference_id: Int,
    val preference_click: () -> Unit
)

data class SwitchPreference(
    val preference_name: String,
    val preference_description: String,
    val preference_id: Int,
    val preference_default_value: Boolean,
    val preference_change_status: (isChecked: Boolean) -> Unit
)

@Composable
fun PreferenceLayout(
    name: String,
    description: String,
    id: Int,
    onPreferenceClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                onPreferenceClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
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
        }
    }
}

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
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
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