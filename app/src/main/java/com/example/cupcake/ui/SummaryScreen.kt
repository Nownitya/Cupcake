package com.example.cupcake.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.component.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onSendButtonClicked: (String, String) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources

    val numberOfCupcake = resources.getQuantityString(
        R.plurals.cupcake,
        orderUiState.quantity,
        orderUiState.quantity
    )
    val orderSummary = stringResource(
        R.string.order_details,
        numberOfCupcake,
        orderUiState.flavor,
        orderUiState.date,
        orderUiState.quantity
    )
    val newOrder = stringResource(R.string.new_cupcake_order)

    val items = listOf(
        Pair(stringResource(R.string.quantity), numberOfCupcake),
        Pair(stringResource(R.string.flavor), orderUiState.flavor),
        Pair(stringResource(R.string.pickup_date), orderUiState.date)
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items.forEach { item ->
                Text(item.first.uppercase())
                Text(text = item.second, fontWeight = FontWeight.Bold)
                HorizontalDivider(thickness = dimensionResource(id = R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            FormattedPriceLabel(
                subtotal = orderUiState.price,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
                Button(
                    onClick = { onSendButtonClicked(newOrder, orderSummary) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.send))
                }
                OutlinedButton(
                    onClick = onCancelButtonClicked,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.cancel))
                }

            }

        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "DarkPreview",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun OrderSummaryPreviewDark() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Check", "Check", "₹200.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "DarkPreview", uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun OrderSummaryPreviewLight() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Check", "Check", "₹200.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Preview
@Composable
fun OrderSummaryPreviewNeutral() {
    CupcakeTheme {
        OrderSummaryScreen(
            orderUiState = OrderUiState(0, "Check", "Check", "₹200.00"),
            onSendButtonClicked = { subject: String, summary: String -> },
            onCancelButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}


/*

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onSendButtonClicked: (String, String) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val resources = LocalContext.current.resources
    val numberOfCupcake = numberOfCupcake(resources, orderUiState)
    val orderSummary = orderSummary(numberOfCupcake, orderUiState)
    val newOrder = stringResource(R.string.new_cupcake_order)
    val items = items(numberOfCupcake, orderUiState)
}

@Composable
private fun numberOfCupcake(
    resources: Resources,
    orderUiState: OrderUiState
) = resources.getQuantityString(
    R.plurals.cupcake,
    orderUiState.quantity,
    orderUiState.quantity
)

@Composable
private fun orderSummary(
    numberOfCupcake: String,
    orderUiState: OrderUiState
) = stringResource(
    R.string.order_details,
    numberOfCupcake,
    orderUiState.flavour,
    orderUiState.date,
    orderUiState.quantity
)

@Composable
private fun items(
    numberOfCupcake: String,
    orderUiState: OrderUiState
) = listOf(
    Pair(stringResource(R.string.quantity), numberOfCupcake),
    Pair(stringResource(R.string.flavor), orderUiState.flavour),
    Pair(stringResource(R.string.pickup_date), orderUiState.date)
)
*/
