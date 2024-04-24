package com.example.hireephraim

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hireephraim.ui.theme.AppColorOne
import com.example.hireephraim.ui.theme.CalcButtonMediumEmphasis
import com.example.hireephraim.ui.theme.CardBackgroundOne
import com.example.hireephraim.ui.theme.CardBackgroundTwo
import com.example.hireephraim.ui.theme.CardTextOne
import com.example.hireephraim.ui.theme.black
import com.example.hireephraim.ui.theme.shirtColor
import com.example.hireephraim.ui.theme.white
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}
@Composable
fun Front(navController: NavHostController){
    Box(
        modifier = Modifier
            .background(AppColorOne)
            .fillMaxHeight()
            .fillMaxWidth()
    ){
            Column(
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .padding(all = 0.dp)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f), // Fills the column's width
                    contentAlignment = Alignment.Center
                ) {
                    Column{
                        Image(
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp)
                                .clip(CircleShape),
                            // Optional: Adds padding around the image
                            painter = painterResource(id = R.drawable.image3), // Resource reference
                            contentDescription = "Description of the image" // Optional: Accessibility
                        )
                    }
                    ElevatedButton(
                        onClick = { navController.navigate(route = MainActivityNavigation.homePage)},
                        Modifier.padding(top = 220.dp).width(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CalcButtonMediumEmphasis
                        )
                        ) {
                        Text("Proceed")
                    }
                }
            }
    }

    }
@ExperimentalMaterial3Api
@Composable
fun Home(navController: NavHostController){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Front Page") },
                    selected = false,
                    onClick = { navController.navigate(route = MainActivityNavigation.frontPage) }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home Page") },
                    selected = false,
                    onClick = { navController.navigate(route = MainActivityNavigation.homePage) }
                )
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Calculator App") },
                    selected = false,
                    onClick = { navController.navigate(route = CalculatorNavigation.Home) }
                )
            }
        },
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = black,
                        titleContentColor = shirtColor,
                    ),
                    title = {
                        Text(
                            "Hire Ephraim App",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            onTextLayout = {}
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(route = MainActivityNavigation.frontPage) }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint = shirtColor,
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                tint = shirtColor,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
        ) { innerPadding ->
            HomePageContent(navController = navController, innerPadding)
        }
    }
}

@Composable
fun HomePageContent(navController: NavHostController, innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()
    Box( modifier = Modifier
        .padding(innerPadding)
    ){
        Column (
            modifier = Modifier.verticalScroll(state = scrollState)
        ){
            Card1()
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .background(AppColorOne)
                    .clip(RoundedCornerShape(66.dp))
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                Text(
                    text = "Mobile App Skills",
                    fontSize = 18.sp,
                    color = shirtColor,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Section2(
                navController = navController
            )

            Section3()
        }
    }
}

@Composable
fun Card1() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundOne,
            contentColor = CardTextOne
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Column{
                Image(
                    modifier = Modifier
                        .size(100.dp)  // Set desired size for the profile image
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile_three), // Resource reference
                    contentDescription = "Description of the image" // Optional: Accessibility
                )
            }
        }
        Text(
            text = "\"Focus on what I can do, not who I am, my passion lies in building amazing stuff " +
                    "with any available stuff, I am not just an app developer, I am a creative.\"",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
        )
        Row(
            modifier = Modifier
                .padding(10.dp)
        ){
            val ctx = LocalContext.current
            Column(modifier = Modifier.weight(0.5f)){
                ElevatedButton(onClick = {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.")
                    )
                    ctx.startActivity(urlIntent)
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = black, // Optional: Set text color (defaults to white)
                        containerColor = shirtColor // Set background color to orange
                    )
                    ) {
                    Icon(
                        painter = painterResource(R.drawable.data_object_24px),
                        contentDescription = stringResource(id = R.string.dataObject)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("GitHub")
                }
            }
            Column(modifier = Modifier.weight(0.5f)){
                ElevatedButton(onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = black, // Optional: Set text color (defaults to white)
                        containerColor = shirtColor // Set background color to orange
                    )
                    ) {
                    Icon(
                        painter = painterResource(R.drawable.perm_phone_msg_24px),
                        contentDescription = stringResource(id = R.string.chat)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Contact")
                }
            }
        }
    }
}

@Composable
fun Section2(navController: NavHostController) {
    LazyRow {
        item {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 300.dp, height = 190.dp)
                    .padding(start = 11.dp, end = 5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardBackgroundTwo,
                    contentColor = CardBackgroundOne
                )            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(shirtColor), // Fills the available width
                    horizontalArrangement = Arrangement.SpaceBetween // Distributes space between elements
                ) {
                    Text(
                        text = "Seamless Functionality",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(3.dp)
                        ) // Display the text
                    Icon(
                        painter = painterResource(R.drawable.bolt_24px),
                        contentDescription = stringResource(id = R.string.chat),
                        tint = CardBackgroundOne,
                        modifier = Modifier
                            .size(28.dp)
                            .padding(3.dp)
                    )
                }
                Text(
                    text = "I built a calculator  that could do some complex arithmetic, " +
                            "with the aim of showcasing my ability to build apps that " +
                            "execute algorithmic functions fast without slowing down the app",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(6.dp)
                )
                OutlinedButton(onClick = { navController.navigate(route = CalculatorNavigation.Home) },
                    modifier = Modifier
                        .padding(6.dp)
                    ) {
                    Text("Try Calculator")
                }

            }
        }

    }
}

@Composable
fun Section3(){
    val gradient = Brush.linearGradient(
        0.0f to CardBackgroundOne,
        500.0f to shirtColor,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()// Fills available width
            .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 10.dp) // Adds padding
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                // Fills the entire Card area
                .background(gradient)
        )
        {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(0.4f)) {
                    var isPlaying by remember { mutableStateOf(false) } // Track playback state

                    val player = MediaPlayer.create(LocalContext.current, R.raw.randomacoustic)
                    OutlinedButton(onClick = {
                        isPlaying = !isPlaying // Toggle playback state directly
                        if (isPlaying) {
                            player.start()
                        } else {
                            player.pause()
                        }
                    },
                        modifier = Modifier
                            .padding(15.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = black, // Optional: Set text color (defaults to white)
                            containerColor = Color.Transparent,
                        ),
                        border = BorderStroke(width = 2.dp, color = white)
                        ) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Outlined.Close else Icons.Filled.PlayArrow,
                            tint = shirtColor,
                            contentDescription = "Localized description"
                        )
                    }
                }

                Text(
                    text = "Beta 1.0.1 Message",
                    fontSize = 22.sp,
                    overflow = TextOverflow.Ellipsis,  //  Show ellipsis (...) for overflow
                    modifier = Modifier
                        .width(160.dp)
                        .padding(10.dp),
                    color = white
                )
                Column(modifier = Modifier.weight(0.3f)) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(id = R.drawable._408085), // Resource reference
                        contentDescription = "Description of the image" // Optional: Accessibility
                    )
                }
            }
        }
    }
}



//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun AppPreview() {
//        Test()
//}