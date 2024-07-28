package com.example.cupcake.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    /*val rupeeFormat = NumberFormat.getCurrencyInstance(Locale("EN", "INDIA"))
    rupeeFormat.currency = Currency.getInstance("INR")
//    val subtotal = rupeeFormat.format(subtotal.toDouble())
//    val formattedSubTotal = rupeeFormat.format(subtotal.toDouble())
    val formattedSubTotal = try {
        val amount = subtotal.toDoubleOrNull() ?: 0.0
        rupeeFormat.format(amount)
    } catch (e: NumberFormatException) {
        "Invalid Input"
    }*/
    Text(
        text = stringResource(
            id = R.string.subtotal_price,
            subtotal
        ),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}

@Preview(name = "FormattedPriceLabel")
@Composable
fun FormattedPriceLabelPreview() {
    CupcakeTheme {
        FormattedPriceLabel(subtotal = "32")
    }
}