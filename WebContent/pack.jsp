<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<style>
.link {
  stroke : #CCC;
  stroke-width : 2;
}

svg { overflow : hidden; }
</style>
<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/echarts.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/china.js" type="text/javascript"charset="utf-8"></script>
</head>
<body>
<li class="dropdown" style="float:right;padding-right: 80px;padding-top: 20px">
<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="false">
其他图形 <b class="caret"></b>
</a>
<ul class="dropdown-menu">
<li><a tabindex="-1" href="index.jsp">回到主页</a></li>
<li><a tabindex="-1" href="rl.jsp">公司分布图</a></li>
<li><a tabindex="-1" href="pack.jsp">公司数量图</a></li>
<form action="updateServlet" method="POST">  
      <li style="padding-left: 40px"><a tabindex="-1" href='updateServlet'>跟新数据</a></li>
</form>
</ul>
</li>
<script src="js/d3.min.js" type="text/javascript"charset="utf-8"></script>
<script>
var width  = 1100;
var height = 1100;

var pack = d3.layout.pack()
    			.size([ width, height ])
    			.radius(3);

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("transform", "translate(0,0)");


d3.json("pack.json", function(error, root) {
	 function R() {
	        var R=Math.round(Math.random() *255);
	        return R;
	    }
	 function G() {
		 	var G=Math.round(Math.random() *255);
	        return G;
	    }
	 function B() {
	        var G=Math.round(Math.random() *255);
	        return B;
	    }
	var nodes = pack.nodes(root);
	var links = pack.links(nodes);
	var r=R();
	var g=G();
	var b=B();
	svg.selectAll("circle")
		.data(nodes)
		.enter()
		.append("circle")
		.attr("fill","rgb(+"+r+","+g+","+b+")")
		.attr("fill-opacity","0.4")
		.attr("cx",function(d){
			return d.x;
		})
		.attr("cy",function(d){
			return d.y;
		})
		.attr("r",function(d){
			return d.r;
		})
		.on("mouseover",function(d,i){
			d3.select(this)
				.attr("fill","yellow");
		})
		.on("mouseout",function(d,i){
			d3.select(this)
				.attr("fill","rgb(+"+r+","+g+","+b+")");
		});
	
// 	svg.selectAll("text")
// 				  .data(nodes)
// 				  .enter()
// 				  .append("text")
// 				  .attr("font-size","10px")
// 				  .attr("fill","white")
// 				  .attr("fill-opacity",function(d){
// 					  if(d.depth == 2)
// 						  return "0.9";
// 					  else
// 						  return "0";
// 				  })
// 				  .attr("x",function(d){ return d.x; })
// 				  .attr("y",function(d){ return d.y; })
// 				  .attr("dx",-12)
// 				  .attr("dy",1)
// 				  .text(function(d){ return d.name; });
	
});             
</script>  
</body>
</html>