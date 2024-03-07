package xyz.kandrac.oopcore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.kandrac.oopcore.screen.ExceptionsScreen
import xyz.kandrac.oopcore.screen.HigherOrderFunctionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(Modifier.fillMaxSize().background(Color.White)) {
                LandingScreen()
            }
        }
    }
}

private enum class LandingScreenSubScreen {
    Landing, Exceptions, Hof
}

@Composable
private fun LandingScreen() {
    var screen by remember { mutableStateOf(LandingScreenSubScreen.Landing) }

    BackHandler(screen != LandingScreenSubScreen.Landing) { screen = LandingScreenSubScreen.Landing }

    when(screen) {
        LandingScreenSubScreen.Landing ->
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                LandingScreenItem(
                    icon = R.drawable.ic_alert_outline,
                    text = stringResource(R.string.landing_item_exceptions),
                    description = stringResource(R.string.landing_item_exceptions_description),
                    onClick = { screen = LandingScreenSubScreen.Exceptions }
                )
                Divider()
                LandingScreenItem(
                    icon = R.drawable.ic_airballoon_outline,
                    text = stringResource(R.string.landing_item_hof),
                    description = stringResource(R.string.landing_item_hof_description),
                    onClick = { screen = LandingScreenSubScreen.Hof }
                )
                Divider()
            }
        LandingScreenSubScreen.Exceptions -> ExceptionsScreen()
        LandingScreenSubScreen.Hof -> HigherOrderFunctionScreen()
    }
}

@Composable
private fun LandingScreenItem(
    icon: Int,
    text: String,
    description: String,
    onClick: () -> Unit
) {
    Row(Modifier.clickable { onClick() }.padding(16.dp, 8.dp).fillMaxWidth().height(64.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painterResource(icon), null, Modifier.size(48.dp).padding(start = 8.dp), Color.Black)
        Column(Modifier.padding(horizontal = 12.dp).weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text, fontSize = 18.sp, fontWeight = FontWeight.Medium)
            Text(description, fontSize = 12.sp, fontWeight = FontWeight.Light, color = Color(0xFF434343))
        }
    }
}
