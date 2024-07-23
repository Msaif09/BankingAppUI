package com.org.bankingappui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.bankingappui.R
import com.org.bankingappui.randomColor
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer


val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Jul 18",
        value = 123f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Jul 19",
        value = 160f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Jul 20",
        value = 204f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Jul 21",
        value = 34f,
        color = randomColor(50)
    ),
    BarChartData.Bar(
        label = "Jul 22",
        value = 84f,
        color = randomColor(50)
    ),
)

@Composable
fun SpendingChart(modifier: Modifier){
    Text(
        modifier = Modifier.padding(horizontal = 22.dp),
        text = "Spending Statistics",
        fontFamily = Font(R.font.playb).toFontFamily(),
        fontSize = 25.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    Chart(modifier = modifier)
}

@Composable
fun Chart(modifier: Modifier){
    BarChart(
        modifier = modifier,
        barChartData = BarChartData(spendingByDay),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelValueFormatter = {"$ ${it.toInt()}"},
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f),
            labelTextColor = MaterialTheme.colorScheme.onBackground,
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextSize = 15.sp,
            labelTextColor = MaterialTheme.colorScheme.onBackground,
        )
    )
}