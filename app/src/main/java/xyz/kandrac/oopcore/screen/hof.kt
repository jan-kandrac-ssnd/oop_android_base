package xyz.kandrac.oopcore.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import xyz.kandrac.oopcore.R

private class Name(val title: String, val first: String, val last: String)
private class User(val name: Name, val email: String, val phone: String)

private class Users(
    @SerializedName("results") val users: List<User>
)

@Composable
private fun sampleValues(): List<User> = Gson().fromJson(LocalContext.current.resources.openRawResource(R.raw.sample_users).reader(), Users::class.java).users

@Composable
fun HigherOrderFunctionScreen() {
    val context = LocalContext.current
    // typické použitie je posielať funkciu do funkcie, ak si nie sme istí, akým
    // spôsobom má hlavná funkcia vyriešiť istú časť riešeného problému, typické príklady sú
    // - filter - potrebuje vedieť, na základe čoho má položky zo zoznamu vybrať
    // - map - potrebuje vedieť, ako má previesť položku z jednej hodnoty na druhú
    // - onClick - čo sa má vykonať ak stlačíme tlačidlo
    // - sort

    val users = sampleValues()

    Column {
        // len prvé mená všetkých používateľov
        // joinToString vieme volať nad akýmkoľvek zoznamom
        // defaultne spája tieto záznamy do textu pomocou
        // ", " ako oddeľovač
        // ".toString()" ako funkcia na prevedenie do textu
        Text(users.joinToString { it.name.first })

        // Vypíšte len prvé mená používateľov, ale zoradené podľa abecedy

        // Vypíšte len mená začínajúce na A

        // (Android) Zobrazte týchto používateľov pod seba = 1 používateľ = 1 Text funkcia

        // (Android) Takto vyzera tlacidlo - onClick prijima funkciu, ktora nieco vykona
        Button(onClick = { Toast.makeText(context, "kliknute", Toast.LENGTH_SHORT).show()}) { Text(text = "Klikni ma") }
    }

}

@Preview
@Composable
private fun HigherOrderFunctionScreenPreview() {
    HigherOrderFunctionScreen()
}