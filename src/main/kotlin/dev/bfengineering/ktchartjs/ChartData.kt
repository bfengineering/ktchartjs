package dev.bfengineering.ktchartjs

class ChartData() {
    var labels: ArrayList<String> = ArrayList()
    var datasets: ArrayList<ChartDatum> = ArrayList()
}

data class ChartDatum(var label: String, var backgroundColor: String, var borderColor: String, var data: Double, var fill: Boolean)