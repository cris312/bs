<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style>
.link {
  stroke : #CCC;
  stroke-width : 2;
}
svg { overflow : hidden; }
</style>
<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/d3.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/echarts.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/china.js" type="text/javascript"charset="utf-8"></script>
</head>
<body>
<div id="canvas">
  <svg xmlns="http://www.w3.org/2000/svg" width="1000" height="3000"></svg>
 </div>
<script>
                
$.getJSON('cap1000_6.json', function(graph){ 
	alert(graph);
	 //返回随机颜色代码
    function random_color() {
        var letters = '0123456789ABCDEF'.split('');
        var color = '#';
        for (var i = 0; i < 6; i++ ) {
            color += letters[Math.round(Math.random() * 15)];
        }
        return color;
    }
    function draw() {
      var width = document.body.clientWidth;
      var height = document.body.clientHeight;
      //设置svg宽度和高度
      var svg = d3.select("#canvas svg")
        .attr("width", width)
        .attr("height", height);
      //设置Force-Directed力参数
      var force = d3.layout.force()
        .gravity(.03)
        .distance(30)
        .charge(-30)
        .size([width, height]);
      force
        .nodes(graph.nodes)
        .links(graph.links)
        .start();
      //选择边集合
      var link = svg.selectAll(".link")
        .data(graph.links)
        .enter().append("line")
        .attr("class", "link");
      //选择节点集合
      var node = svg.selectAll(".node")
        .data(graph.nodes)
        .enter().append("g")
        .attr("class", "node")
        .call(force.drag)
        .on("mouseover",function(d,i){  
            d.show = true;  
        })  
        .on("mouseout",function(d,i){  
            d.show = false;  
        }); //响应鼠标拖拽事件
      //节点添加圆形图案
      node.append("svg:circle").attr("r", 5)
        .style("fill", function(){
          return random_color();
        })
        .style("stroke", "#FFF").style("stroke-width", 3);
      //绑定tick事件
      force.on("tick", function() {
        link.attr("x1", function(d) { return d.source.x; })
          .attr("y1", function(d) { return d.source.y; })
          .attr("x2", function(d) { return d.target.x; })
          .attr("y2", function(d) { return d.target.y; });
        node.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
      });
    }
    $(function(){
      draw();
    });
	}); 
                      
</script>  
</body>
</html>