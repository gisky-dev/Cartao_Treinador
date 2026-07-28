package br.com.curso.cartaotreinador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernTrainerCard()
        }
    }
}

@Composable
fun ModernTrainerCard() {
    // Gradiente de Fundo Premium (Noite Estelar)
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF0F0C29), Color(0xFF302B63), Color(0xFF24243E))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGradient),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .shadow(elevation = 30.dp, shape = RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f))
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Avatar com Borda Gradiente Neon
                Box(
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(Color(0xFF00E676), Color(0xFF00B0FF))))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.trainer_avatar),
                        contentDescription = "Avatar Treinador",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Nome e Título
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "ASH KETCHUM",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF1A1A1A)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = "Verificado",
                        tint = Color(0xFF00B0FF),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "MESTRE POKÉMON • PALLET TOWN",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 24.dp),
                    color = Color.LightGray.copy(alpha = 0.4f)
                )

                // Stats do Treinador (Grid Horizontal)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem(Icons.Default.Star, "Rank", "S+", Color(0xFFFFA000))
                    StatItem(Icons.Default.ThumbUp, "Vitórias", "1540", Color(0xFF1976D2))
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Meus Pokémons Favoritos (Time)
                Text(
                    text = "MEU TIME PRINCIPAL",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF333333)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Alinhamento dos Ícones
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    PokemonIcon(R.drawable.pikachu, "Pikachu")
                    Spacer(modifier = Modifier.width(16.dp))
                    PokemonIcon(R.drawable.charizard, "Charizard")
                    Spacer(modifier = Modifier.width(16.dp))
                    PokemonIcon(R.drawable.blastoise, "Blastoise")
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Botão de Ação
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
                ) {
                    Text("SOLICITAR BATALHA", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

/**
 * Componente modular para itens estatísticos
 */
@Composable
fun StatItem(icon: ImageVector, label: String, value: String, tint: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(30.dp))
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Black, color = Color.Black)
        Text(text = label, fontSize = 10.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
    }
}

/**
 * Componente circular para os Pokemons com sombras
 */
@Composable
fun PokemonIcon(resId: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .shadow(4.dp, CircleShape)
                .background(Color.White, CircleShape)
                .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = name,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
