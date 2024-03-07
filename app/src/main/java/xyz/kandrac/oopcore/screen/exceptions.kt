package xyz.kandrac.oopcore.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import xyz.kandrac.oopcore.R

@Composable
fun ExceptionsScreen() {
    Text(stringResource(id = R.string.landing_item_exceptions))

}

@Preview
@Composable
private fun ExceptionsScreenPreview() {
    ExceptionsScreen()
}