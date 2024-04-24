package com.example.hireephraim


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hireephraim.ui.theme.CalcBackground
import com.example.hireephraim.ui.theme.CalcButtonHighEmphasis
import com.example.hireephraim.ui.theme.CalcButtonLowEmphasis
import com.example.hireephraim.ui.theme.CalcButtonMediumEmphasis
import com.example.hireephraim.ui.theme.CalcInputTextMediumEmphasis
import com.example.hireephraim.ui.theme.black
import com.example.hireephraim.ui.theme.white
import androidx.compose.runtime.Composable as Composable


@Composable
fun CalculatorMain(app: CalculatorModel = viewModel()){
    val valueFlow = remember { app.result } // Remember the Flow from ViewModel
    val result by valueFlow.collectAsState(initial = null)

    var textFieldValue by remember { mutableStateOf("") }
    Log.d(TAG, "Text field value: $textFieldValue")// State variable for text field value
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(CalcBackground)
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Column(
                modifier = Modifier.fillMaxHeight(0.25f)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .padding(end = 19.dp, top = 15.dp), // Make the row fill the width
                    horizontalArrangement = Arrangement.End // Arrange elements to the left
                ) {
                    if (result != null) {
                        Text(
                            text = "Ans: $result",
                            fontSize = 30.sp,
                            color = CalcInputTextMediumEmphasis,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                        .padding(start= 10.dp,),
                ) {
                    CompositionLocalProvider(LocalTextInputService provides null) {
                        DynamicFontSizeTextField(text = textFieldValue, onTextChange = {  })
                    }

                }
            }
            Column(
                Modifier.fillMaxSize(1f)
            ){
                Row(
                    Modifier
                        .padding(start = 19.dp, top = 10.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "C",
                            onClick = { textFieldValue = "" },
                            backgroundColor = CalcButtonMediumEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "+/-",
                            onClick = {  },
                            backgroundColor = CalcButtonMediumEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "%",
                            onClick = {  },
                            backgroundColor = CalcButtonMediumEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "÷",
                            onClick = { textFieldValue += "÷" },
                            backgroundColor = CalcButtonHighEmphasis,
                            contentColor = white
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 19.dp, top = 10.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "7",
                            onClick = { textFieldValue += "7" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "8",
                            onClick = { textFieldValue += "8"  },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "9",
                            onClick = { textFieldValue += "9" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "×",
                            onClick = { textFieldValue += "×" },
                            backgroundColor = CalcButtonHighEmphasis,
                            contentColor = white
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 19.dp, top = 10.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "4",
                            onClick = { textFieldValue += "4" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "5",
                            onClick = { textFieldValue += "5" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "6",
                            onClick = { textFieldValue += "6" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "-",
                            onClick = { textFieldValue += "-" },
                            backgroundColor = CalcButtonHighEmphasis,
                            contentColor = white
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 19.dp, top = 10.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "1",
                            onClick = { textFieldValue += "1" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "2",
                            onClick = { textFieldValue += "2" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "3",
                            onClick = { textFieldValue += "3" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "+",
                            onClick = { textFieldValue += "+" },
                            backgroundColor = CalcButtonHighEmphasis,
                            contentColor = white
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(start = 19.dp, top = 10.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = ".",
                            onClick = { textFieldValue += "." },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "0",
                            onClick = { textFieldValue += "0" },
                            backgroundColor = CalcButtonLowEmphasis,
                            contentColor = white
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        Column(
                            modifier = Modifier
                                .clickable(onClick = {
                                    textFieldValue = textFieldValue.dropLast(1)
                                }) // Make the button clickable
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = black,
                                    shape = MaterialTheme.shapes.small
                                ) // Add shadow
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(70.dp)
                                    .width(70.dp)
                                    .background(CalcButtonLowEmphasis)  // Rounded corners
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.backspace_24px),
                                    contentDescription = stringResource(id = R.string.dataObject),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(40.dp),
                                    tint = white,
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(end = 15.dp)
                    ){
                        CustomButton(
                            text = "=",
                            onClick = { app.submit(textFieldValue) },
                            backgroundColor = CalcButtonHighEmphasis,
                            contentColor = white
                        )
                    }
                }
            }
            }
        }
    }

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color
){
    Column(
        modifier = modifier
            .clickable(onClick = onClick) // Make the button clickable
            .shadow(elevation = 10.dp, spotColor = black, shape = MaterialTheme.shapes.small) // Add shadow
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(70.dp)
                .width(70.dp)
                .background(color = backgroundColor)  // Rounded corners
        ) {
            Text(text = text, modifier = Modifier.align(Alignment.Center), color = contentColor, fontSize = 40.sp)
        }
    }

}

@Composable
fun DynamicFontSizeTextField(
    text: String,
    onTextChange: (String) -> Unit,
    fontSizeLarge: Float = 40f, // Adjust as needed
    fontSizeMedium: Float = 35f, // Adjust as needed
    fontSizeSmall: Float = 30f, // Adjust as needed,
    largeThreshold: Int = 20, // Adjust as needed (characters for large font)
    mediumThreshold: Int = 20, // Adjust as needed (characters for medium font)
) {
    TextField(
        value = text,
        modifier = Modifier
            .focusable(false)
            .background(CalcBackground)
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = CalcBackground,
            focusedContainerColor =  CalcBackground,
            focusedIndicatorColor = CalcBackground,
            unfocusedIndicatorColor = CalcBackground,
            cursorColor = white
        ),
        onValueChange = onTextChange,
        textStyle = TextStyle(
            fontSize = when {
                text.length > mediumThreshold -> fontSizeSmall.sp // or fontSizeSmall.dp
                text.length > largeThreshold -> fontSizeMedium.sp // or fontSizeMedium.dp
                else -> fontSizeLarge.sp // or fontSizeLarge.dp
            },
            color = white
        )
    )
}



//@Preview
//@Composable
//fun AppPreview() {
//    Main()
//}