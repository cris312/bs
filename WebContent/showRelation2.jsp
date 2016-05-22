<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/d3.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/echarts.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/china.js" type="text/javascript"charset="utf-8"></script>
</head>
<body>
<div id="main" style="width: 1000px;height:1000px;"></div>
<script>
var myChart = echarts.init(document.getElementById('main'));
myChart.showLoading();
$.get('cap1000_2.json', function (webkitDep) {
	alert(webkitDep);
    myChart.hideLoading();
    option = {
        legend: {
            data: ['HTMLElement', 'WebGL', 'SVG', 'CSS', 'Other']
        },
        series: [{
            type: 'graph',
            layout: 'force',
            animation: false,
            label: {
                normal: {
                    position: 'right',
                    formatter: '{b}'
                }
            },
            draggable: true,
            data: webkitDep.nodes.map(function (node, idx) {
                node.id = idx;
                return node;
            }),
            categories: webkitDep.categories,
            force: {
                // initLayout: 'circular'
                // gravity: 0
                 //repulsion: 20,
                edgeLength: 150,
                repulsion: 20
            },
            edges: webkitDep.links
        }]
    };
    myChart.setOption(option);
});
</script>  
</body>
</html>