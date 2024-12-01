package ec.edu.epn.geoalerta

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class LaunchScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeoAlertaApp()
        }

        // Cambia a loginScreen después de 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, loginScreen::class.java)
            startActivity(intent)
            finish() // Cierra launchScreen para que no se regrese al usar el botón de retroceso
        }, 3000)
    }
}

@Composable
fun GeoAlertaApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.escudo),
            contentDescription = "Shield Icon",
            modifier = Modifier.size(350.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "GeoAlerta",
            fontSize = 50.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
