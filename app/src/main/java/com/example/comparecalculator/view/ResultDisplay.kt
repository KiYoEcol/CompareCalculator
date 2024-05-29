package com.example.comparecalculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comparecalculator.R
import com.example.comparecalculator.viewmodel.MainViewModel

@Composable
fun ResultDisplay(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    Row(modifier = modifier.fillMaxWidth()) {
        val selectedIndexOfTextNumberDisplay by viewModel.selectedIndexOfTextNumberDisplay.collectAsStateWithLifecycle()
        val textNumberDisplayPrice1 by viewModel.textNumberDisplayPrice1.collectAsStateWithLifecycle()
        val textNumberDisplayPrice2 by viewModel.textNumberDisplayAmount1.collectAsStateWithLifecycle()
        val textNumberDisplayPrice3 by viewModel.textNumberDisplayPrice2.collectAsStateWithLifecycle()
        val textNumberDisplayPrice4 by viewModel.textNumberDisplayAmount2.collectAsStateWithLifecycle()

        ResultComponent(
            modifier = Modifier.weight(1f),
            textNumberDisplayPrice = textNumberDisplayPrice1,
            textBorderColorPrice = if (selectedIndexOfTextNumberDisplay == 1) colorResource(id = R.color.red300) else Color.White,
            onClickTextNumberDisplayPrice = { viewModel.setSelectedIndexOfTextNumberDisplay(1) },
            textNumberDisplayAmount = textNumberDisplayPrice2,
            textBorderColorAmount = if (selectedIndexOfTextNumberDisplay == 2) colorResource(id = R.color.red300) else Color.White,
            onClickTextNumberDisplayAmount = { viewModel.setSelectedIndexOfTextNumberDisplay(2) }
        )
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

        ResultComponent(
            modifier = Modifier.weight(1f),
            textNumberDisplayPrice = textNumberDisplayPrice3,
            textBorderColorPrice = if (selectedIndexOfTextNumberDisplay == 3) colorResource(id = R.color.red300) else Color.White,
            onClickTextNumberDisplayPrice = { viewModel.setSelectedIndexOfTextNumberDisplay(3) },
            textNumberDisplayAmount = textNumberDisplayPrice4,
            textBorderColorAmount = if (selectedIndexOfTextNumberDisplay == 4) colorResource(id = R.color.red300) else Color.White,
            onClickTextNumberDisplayAmount = { viewModel.setSelectedIndexOfTextNumberDisplay(4) }
        )
    }
}

@Preview
@Composable
fun ResultDisplayPreview() {
}

@Composable
fun ResultComponent(
    modifier: Modifier = Modifier,
    textNumberDisplayPrice: String = "",
    textBorderColorPrice: Color = Color.White,
    onClickTextNumberDisplayPrice: () -> Unit = {},
    textNumberDisplayAmount: String = "",
    textBorderColorAmount: Color = Color.White,
    onClickTextNumberDisplayAmount: () -> Unit = {}
) {
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
        NumberDisplayText(
            text = textNumberDisplayPrice,
            borderColor = textBorderColorPrice,
            onClick = onClickTextNumberDisplayPrice
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_result_component_between_number_displays)))
        NumberDisplayText(
            text = textNumberDisplayAmount,
            borderColor = textBorderColorAmount,
            onClick = onClickTextNumberDisplayAmount
        )
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
fun NumberDisplayText(
    modifier: Modifier = Modifier,
    text: String = "",
    borderColor: Color = Color.White,
    onClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    Text(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 3.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .horizontalScroll(scrollState)
            .clickable { onClick.invoke() },
        text = text,
        fontSize = with(LocalDensity.current) { dimensionResource(id = R.dimen.font_size_number_display).toSp() },
        maxLines = 1
    )
}

@Preview
@Composable
fun ResultComponentPreview() {
    val textNumberDisplayPrice1 = "1"
    ResultComponent(textNumberDisplayPrice = textNumberDisplayPrice1)
}