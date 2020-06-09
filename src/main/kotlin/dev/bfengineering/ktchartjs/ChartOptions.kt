package dev.bfengineering.ktchartjs

data class ChartOptions(var aspectRatio: Float,
                    var responsive: Boolean,
                    var maintainAspectRatio: Boolean,
                    var title: ChartTitle,
                    var legend: ChartLegend) {
    var scales: ChartScale = ChartScale()
}

data class ChartTitle(var display: Boolean,
    var text: String
)

class ChartScale() {
    var xAxes: ArrayList<ChartAxes> = ArrayList()
    var yAxes: ArrayList<ChartAxes> = ArrayList()
}

data class ChartAxes(var display: Boolean, var chartScaleLabel: ChartScaleLabel, var tick: ChartTick)

data class ChartTick(var autoSkip: Boolean)

data class ChartScaleLabel(var display: Boolean, var labelString: String)

data class ChartLegend(var display: Boolean, var position: String)