package com.juanjo.personalcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalCard()
        }
    }
}

@Composable
fun PersonalCard() {
    var showBio by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color(0xFF6A0DAD)
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Botón para mostrar/ocultar información
            Button(onClick = { showBio = !showBio }) {
                Text(if (showBio) "Show less" else "Show more")
            }

            Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                        .size(200.dp)
                        .clip(RoundedCornerShape(100))
                        .padding(2.dp)
                )


            Spacer(modifier = Modifier.height(12.dp))


            Surface(
                shape = RoundedCornerShape(50),
                color = Color(0xFF00BFA6),
                shadowElevation = 4.dp
            ) {
                Text(
                    text = "Juanjo Gómez",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                )
            }


            if (showBio) {
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(200.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Juan José Gómez",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFF00BFA6)
                            )
                            Text(
                                "Ingeniero Informático",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFF00BFA6)
                            )

                            Spacer(Modifier.height(8.dp))

                            Text("Universidad de La Sabana", fontSize = 12.sp)
                            Text("3006855351", fontSize = 12.sp)
                            Text("juangomsaa@unisabana.edu.co", fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonalCard() {
    PersonalCard()
}
