package ec.edu.epn.geoalerta

//import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.style.TextDecoration

class loginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}


@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = R.drawable.escudo),
            contentDescription = "Shield Icon",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(70.dp))

        OutlinedCardLogin()



    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedCardLogin() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(60.dp), // Define un redondeo de 16.dp en las esquinas
        modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho
            .fillMaxHeight() // Ocupa todo el alto disponible desde su posición
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Bienvenido",
                color = Color.Black,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Inicie sesión para continuar",
                color = Color.Black,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            EmailInputField()

            Spacer(modifier = Modifier.height(5.dp))

            PasswordInputField()

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /*TODO: Implement login functionality */ },
                modifier = Modifier
                    .fillMaxWidth() // Hace que el botón ocupe todo el ancho disponible, igual que el campo de contraseña
                    .padding(horizontal = 48.dp), // Espaciado en los márgenes
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black) // Fondo negro
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White, // Letras blancas
                    style = TextStyle(fontSize = 16.sp) // Ajusta el tamaño de la fuente si es necesario
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Olvidaste tu contraseña",
                color = Color(0xFF000000), // Azul eléctrico
                style = TextStyle(
                    textDecoration = TextDecoration.Underline // Subrayado
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Regístrate ahora",
                color = Color(0xFF1749FE), // Azul eléctrico
                style = TextStyle(
                    textDecoration = TextDecoration.Underline // Subrayado
                )
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInputField() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("CORREO ELECTRÓNICO") },
        placeholder = { Text("example@gmail.com") },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFA7BBFF), // Azul claro para el fondo
            focusedIndicatorColor = Color.Transparent, // Sin borde cuando está enfocado
            unfocusedIndicatorColor = Color.Transparent, // Sin borde cuando no está enfocado
            focusedLabelColor = Color.Black, // Color del texto de la etiqueta
            cursorColor = Color.Black, // Color del cursor
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        label = { Text("CONTRASEÑA") },
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFA7BBFF), // Azul claro para el fondo
            focusedIndicatorColor = Color.Transparent, // Sin borde cuando está enfocado
            unfocusedIndicatorColor = Color.Transparent, // Sin borde cuando no está enfocado
            focusedLabelColor = Color.Black, // Color del texto de la etiqueta
            cursorColor = Color.Black, // Color del cursor
        )

    )
}



