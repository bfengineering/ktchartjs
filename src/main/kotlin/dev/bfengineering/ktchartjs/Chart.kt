package dev.bfengineering.ktchartjs

class Chart(val chartLabel: String) {
    var data: ChartData
    var options: ChartOptions
    var usedColorSet: HashMap<String, Boolean> = HashMap()

    init {
        data = ChartData()
        options = ChartOptions(2.0f, true, false, ChartTitle(true, chartLabel), ChartLegend(true, "right"))
    }

    fun addLabels(labels: ArrayList<String>) {
        data.labels = labels
    }

    fun addDatum(datum: ChartDatum) {
        if(datum.borderColor == "" && datum.backgroundColor != "") {
            datum.borderColor = datum.backgroundColor
        } else if(datum.backgroundColor == "" && datum.borderColor != "") {
            datum.backgroundColor = datum.borderColor
        } else {
            val color = selectColor(datum.label)
            datum.borderColor = color
            datum.backgroundColor = color
        }
        data.datasets + datum
    }

    fun addXAxes(label: String, autoSkip: Boolean) {
        options.scales.xAxes + ChartAxes(true, ChartScaleLabel(true, label), ChartTick(autoSkip))
    }

    fun addYAxes(label: String, autoSkip: Boolean) {
        options.scales.yAxes + ChartAxes(true, ChartScaleLabel(true, label), ChartTick(autoSkip))
    }

    fun selectColor(label: String): String {
        val hash = label.hashCode()
        var index = hash % colorCodes.size
        var color = colorCodes[index]

        var notFound = true
        while(notFound) {
            if(!usedColorSet.containsKey(color)) {
                usedColorSet.put(color, true)
                notFound = false
            }

            index += 1
            color = colorCodes[index]
        }
        return color
    }
}