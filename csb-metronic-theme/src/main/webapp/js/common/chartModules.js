ChartModuleAPI = {
    DrawCloudChart: function (word_list, tagCloud_id) {
        $(tagCloud_id).jQCloud(word_list, {
            shape: "elliptic"
        });
    },
    DrawPieChart: function (chartId, chartType, title, data) {

        new Highcharts.Chart({
            chart: {
                renderTo: chartId,
                type: chartType,
                backgroundColor: 'transparent',
                width: 700,
                style: {
                    margin: '0 auto'
                }
            },

            title: {
                text: title
            },

            tooltip: {
                useHTML: true,
                pointFormat: '{series.name}: <strong>{point.percentage:.1f}%</strong>'
            },

            exporting: { enabled: false },

            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        useHTML: true,
                        enabled: true,
                        color: '#000000',
                        format: '<b>{point.name}:</b><br>{point.percentage:.1f}%</b>'
                    }
                },
                showInLegend: true
            },

            series: data

        });
    },

    DrawLineChart: function (chartId, chartType, title, data) {
        new Highcharts.Chart({
            chart: {
                renderTo: chartId,
                type: chartType,
                backgroundColor: "transparent",
                width: 1000,
                style: {
                    margin: '0 auto'
                }
            },
            exporting: { enabled: false },
            title: {
                text: title,
                x: -20 //center
            },
            subtitle: {
                text: "From " + data.xAxis.categories[0] + " To " + data.xAxis.categories[data.xAxis.categories.length - 1] + "",
                x: -20
            },

            xAxis: data.xAxis,
            yAxis: data.yAxis,
            tooltip: {
                valueSuffix: ''
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0,
                useHTML: true
            },

            series: data.data
        });
    }
};
