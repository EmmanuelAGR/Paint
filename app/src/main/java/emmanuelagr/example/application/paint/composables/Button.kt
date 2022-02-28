package emmanuelagr.example.application.paint.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IButton(
    icon: ImageVector?,
    background: Color? = null,
    description: String,
    event: () -> Unit
) {
    val isLightTheme = MaterialTheme.colors.isLight

    Surface(
        elevation = 3.dp,
        shape = CircleShape,
        content = {
            IconButton(
                onClick = { event() },
                content = {
                    icon?.let {
                        Icon(
                            it,
                            description,
                            tint = background.let { background }
                                ?: run { if (isLightTheme) Color.Gray else Color.White }
                        )
                    }
                },
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
                    .background(Color.Transparent)
            )
        }
    )
}