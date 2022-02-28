package emmanuelagr.example.application.paint.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import emmanuelagr.example.application.paint.models.Painting

@Composable
fun PaintingTools(
    paths: MutableState<MutableList<Painting>>,
    paintColor: MutableState<Color>
) {
    var expandableState by remember { mutableStateOf<Boolean>(false) }

    val x by animateDpAsState(
        targetValue = if (expandableState) 125.dp else 65.dp
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(x)
            .padding(5.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
            ) {
                IButton(
                    Icons.Rounded.Palette,
                    description = "Color palette",
                    event = { expandableState = !expandableState }
                )

                Box(
                    contentAlignment = Alignment.Center,
                    content = { Text(text = "CANVAS", color = Color.Black) },
                    modifier = Modifier
                        .height(50.dp),
                )

                IButton(
                    Icons.Rounded.Delete,
                    description = "Clear canvas",
                    event = { paths.value = mutableListOf() }
                )
            }
            ColorPalette(paintColor)
        }
    }
}