package com.example.comparecalculator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comparecalculator.R

@Composable
fun ResultDisplay(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        ResultComponent(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.weight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val fontSizeDpDiscount = with(LocalDensity.current) {
                dimensionResource(id = R.dimen.font_size_discount).toSp().toDp()
            }
            val spaceDiscount =
                if (dimensionResource(id = R.dimen.icon_size) > fontSizeDpDiscount) {
                    dimensionResource(id = R.dimen.icon_size)
                } else {
                    fontSizeDpDiscount
                }
            Spacer(
                modifier = Modifier.height(
                    dimensionResource(id = R.dimen.space_result_component_top) + spaceDiscount + dimensionResource(
                        id = R.dimen.space_result_component_between_discount_and_number_display
                    ) + 20.dp
                )
            )
            Icon(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                painter = painterResource(id = R.drawable.currency_yen_24px),
                contentDescription = ""
            )
            Text(
                text = "金額",
                fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_icon_bottom).toSp() }
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_number_displays)))
            Icon(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                painter = painterResource(id = R.drawable.sugar_cubes),
                contentDescription = ""
            )
            Text(
                text = "量",
                fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_icon_bottom).toSp() }
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_number_display_and_result_number_display) - 12.dp))
            Icon(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                painter = painterResource(id = R.drawable.block),
                contentDescription = ""
            )
            Text(
                text = "単価",
                fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_icon_bottom).toSp() }
            )
        }
        ResultComponent(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun ResultDisplayPreview() {
}

@Composable
fun ResultComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.gray500),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_top)))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = "",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "お得",
                fontSize = dimensionResource(id = R.dimen.font_size_discount).value.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_discount_and_number_display)))
        NumberDisplayText(text = "1")
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_number_displays)))
        NumberDisplayText(text = "2")
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_number_display_and_result_number_display)))
        Text(
            text = "3",
            fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_result_number_display).toSp() },
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_result_number_display_and_delete)))
        Icon(
            modifier = Modifier.size(dimensionResource(id = R.dimen.icon_size)),
            imageVector = Icons.Rounded.Delete,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_bottom)))
    }
}

@Composable
fun NumberDisplayText(modifier: Modifier = Modifier, text: String = "") {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                drawRoundRect(
                    color = Color.White,
                    cornerRadius = CornerRadius(8f, 8f)
                )
            }
            .padding(8.dp),
        text = text,
        fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_number_display).toSp() },
        maxLines = 1
    )
}

@Preview
@Composable
fun ResultComponentPreview() {
    ResultComponent()
}