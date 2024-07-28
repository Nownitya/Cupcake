package com.example.cupcake.ui

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.cupcake.R
import com.example.cupcake.ui.component.FormattedPriceLabel
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun SelectOptionsScreen(
    subtotal: String,
    options: List<String>,
    modifier: Modifier = Modifier,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},

    ) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier, verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            options.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue = item
                            onSelectionChanged(item)
                        },
                    )
                    Text(item)
                }
            }
            HorizontalDivider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_medium)
                    )
            )
            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                enabled = selectedValue.isNotEmpty(),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.next))

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
fun SelectOptionsPreviewDark() {
    CupcakeTheme {
        SelectOptionsScreen(
            subtotal = "20",
            options = listOf("option 1", "option 2", "option 3", "option 4"),
            modifier = Modifier.fillMaxHeight()
        )

    }
}

@Preview(
    showBackground = true, showSystemUi = true, name = "DarkPreview", uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun SelectOptionsPreviewLight() {
    CupcakeTheme {
        SelectOptionsScreen(
            subtotal = "20",
            options = listOf("option 1", "option 2", "option 3", "option 4"),
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Preview
@Composable
fun SelectOptionsPreviewNeutral() {
    CupcakeTheme {
        SelectOptionsScreen(
            subtotal = "20",
            options = listOf("option 1", "option 2", "option 3", "option 4"),
            modifier = Modifier.fillMaxHeight()
        )
    }
}