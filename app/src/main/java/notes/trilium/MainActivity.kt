package notes.trilium

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import notes.trilium.ui.theme.TriliumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val url = "https://notes.mohanravi.com"
            TriliumTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WebViewScreen(url)
                }
            }
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(url : String) {
    AndroidView(
        factory = { context ->
            return@AndroidView WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(false)
            }
        },
        update = {
            it.loadUrl(url)
        }
    )
}
