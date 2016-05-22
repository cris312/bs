<%@page import="com.bs.vo.Province"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.bs.service.*"%>
<%@page import="com.bs.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>公司分布图</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/china.js" type="text/javascript"charset="utf-8"></script>
<% 
Province []p = new Province[50];
ProvinceService ps = new ProvinceService();
p = ps.setAllColor();
%>
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
<form  method="post" action="rl.jsp" id ="passForm"> 
     <input id = 'hi' type = 'hidden' name="hi"> 
</form>  
<script src="js/d3.min.js" type="text/javascript"charset="utf-8"></script>
<script>

var width  = 1000;
var height = 1000;
var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("transform", "translate(0,0)");
var projection = d3.geo.mercator()
					.center([107, 31])
					.scale(850)
					.translate([width/2, height/2]);
var path = d3.geo.path()
				.projection(projection);
var color = d3.scale.category20();
d3.json("china.geojson", function(error, root) {
	if (error) 
		return console.error(error);
	console.log(root.features);
	
	svg.selectAll("path")
		.data( root.features )
		.enter()
		.append("path")
		.attr("stroke","#000")
		.attr("stroke-width",1)
		.attr("fill", function(d,i){
			if(i==0){	
				var color = "<%=p[1].getColor()%>";
			}
			if(i==1){	
				var color = "<%=p[2].getColor()%>";
			}
			if(i==2){	
				var color = "<%=p[3].getColor()%>";
			}
			if(i==3){	
				var color = "<%=p[4].getColor()%>";
			}
			if(i==4){	
				var color = "<%=p[5].getColor()%>";
			}
			if(i==5){	
				var color = "<%=p[6].getColor()%>";
			}
			if(i==6){	
				var color = "<%=p[7].getColor()%>";
			}
			if(i==7){	
				var color = "<%=p[8].getColor()%>";
			}
			if(i==8){	
				var color = "<%=p[9].getColor()%>";
			}
			if(i==9){	
				var color = "<%=p[10].getColor()%>";
			}
			if(i==10){	
				var color = "<%=p[11].getColor()%>";
			}
			if(i==11){	
				var color = "<%=p[12].getColor()%>";
			}
			if(i==12){	
				var color = "<%=p[13].getColor()%>";
			}
			if(i==13){	
				var color = "<%=p[14].getColor()%>";
			}
			if(i==14){	
				var color = "<%=p[15].getColor()%>";
			}
			if(i==15){	
				var color = "<%=p[16].getColor()%>";
			}
			if(i==16){	
				var color = "<%=p[17].getColor()%>";
			}
			if(i==17){	
				var color = "<%=p[18].getColor()%>";
			}
			if(i==18){	
				var color = "<%=p[19].getColor()%>";
			}
			if(i==19){	
				var color = "<%=p[20].getColor()%>";
			}
			if(i==20){	
				var color = "<%=p[21].getColor()%>";
			}
			if(i==21){	
				var color = "<%=p[22].getColor()%>";
			}
			if(i==22){	
				var color = "<%=p[23].getColor()%>";
			}
			if(i==23){	
				var color = "<%=p[24].getColor()%>";
			}
			if(i==24){	
				var color = "<%=p[25].getColor()%>";
			}
			if(i==25){	
				var color = "<%=p[26].getColor()%>";
			}
			if(i==26){	
				var color = "<%=p[27].getColor()%>";
			}
			if(i==27){	
				var color = "<%=p[28].getColor()%>";
			}
			if(i==28){	
				var color = "<%=p[29].getColor()%>";
			}
			if(i==29){	
				var color = "<%=p[30].getColor()%>";
			}
			if(i==30){	
				var color = "<%=p[31].getColor()%>";
			}
			return color;
		})
		.attr("d", path )
		.on("mouseover",function(d,i){
            d3.select(this)
                ;
        })
        .on("mouseout",function(d,i){
            d3.select(this)
               ;
        });
	
});
</script>
</body>
</html>