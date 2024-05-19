package com.example.comparecalculator.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.comparecalculator.R

@Composable
fun CalculatorButtons(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (
            button0,
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            buttonDot,
            buttonDel,
            buttonNext
        ) = createRefs()

        Button(
            modifier = Modifier
                .size(80.dp)
                .constrainAs(button7) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(button8.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "7")
        }
        Button(
            modifier = Modifier
                .size(80.dp)
                .constrainAs(button8) {
                    top.linkTo(button7.top)
                    start.linkTo(button7.end)
                    end.linkTo(button9.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "8")
        }
        Button(
            modifier = Modifier
                .size(80.dp)
                .constrainAs(button9) {
                    top.linkTo(button8.top)
                    start.linkTo(button8.end)
                    end.linkTo(buttonDel.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "9")
        }
        Button(
            modifier = Modifier
                .width(80.dp)
                .constrainAs(buttonDel) {
                    top.linkTo(button9.top)
                    start.linkTo(button9.end)
                    bottom.linkTo(button6.bottom)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "Del")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button4) {
                    top.linkTo(button7.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(button5.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "4")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button5) {
                    top.linkTo(button4.top)
                    start.linkTo(button4.end)
                    end.linkTo(button6.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "5")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button6) {
                    top.linkTo(button5.top)
                    start.linkTo(button5.end)
                    end.linkTo(buttonDel.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "6")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button1) {
                    top.linkTo(button4.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(button2.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "1")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button2) {
                    top.linkTo(button1.top)
                    start.linkTo(button1.end)
                    end.linkTo(button3.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "2")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(button3) {
                    top.linkTo(button2.top)
                    start.linkTo(button2.end)
                    end.linkTo(buttonNext.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "3")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .width(80.dp)
                .constrainAs(buttonNext) {
                    top.linkTo(button3.top)
                    start.linkTo(button3.end)
                    bottom.linkTo(buttonDot.bottom)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "Next")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .height(80.dp)
                .constrainAs(button0) {
                    top.linkTo(button1.bottom)
                    start.linkTo(button1.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(button2.end)
                    width = Dimension.fillToConstraints
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = "0")
        }
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(80.dp)
                .constrainAs(buttonDot) {
                    top.linkTo(button0.top)
                    start.linkTo(button0.end)
                    end.linkTo(buttonNext.start)
                },
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray500))
        ) {
            Text(text = ".")
        }
    }
}

@Preview
@Composable
fun CalculatorButtons2Preview() {
    CalculatorButtons()
}