package emmanuelagr.example.application.paint.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import emmanuelagr.example.application.paint.composables.Canvas
import emmanuelagr.example.application.paint.composables.PaintingTools
import emmanuelagr.example.application.paint.models.Painting

@Composable
fun Paint() {
    val painting = remember { mutableStateOf(mutableListOf<Painting>()) }
    val paintColor = remember { mutableStateOf(Color.Black) }
    val paintStroke = remember { mutableStateOf(Stroke(5f)) }

    painting.value.add(Painting(Path(), paintColor.value, paintStroke.value))

    Scaffold(
        topBar = { PaintingTools(paths = painting, paintColor) },
        backgroundColor = MaterialTheme.colors.background,
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                content = { Canvas(paintColor, paintStroke, paths = painting.value) })
        },
        modifier = Modifier.fillMaxSize()
    )
}