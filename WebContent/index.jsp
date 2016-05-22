<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>上市公司</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script src="js/jquery-2.1.0.min.js" type="text/javascript"charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	
</head>
<body background="http://imgk.zol.com.cn/se/3416/a3415854_s.jpg" style="background-size: cover;">
	<div style="width:100%;height:80px">
	<!-- <font face="微软雅黑" size="200px">上市公司关系网络</font> -->	
<li class="dropdown" style="float:right;padding-right: 80px;padding-top: 20px">
<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="false">
其他图形 <b class="caret"></b>
</a>
<ul class="dropdown-menu">
<li><a tabindex="-1" href="rl.jsp">公司分布图</a></li>
<li><a tabindex="-1" href="pack.jsp">公司数量图</a></li>
<form action="updateServlet" method="POST">  
<li style="padding-left: 30px"><a tabindex="-1" href='updateServlet'>跟新数据</a></li>
</form>
</ul>
</li>
	</div>
	
		<div class="search-area">
			<form action="StockServlet" method="POST" class="form-inline">
			<div class="form-group" style="margin-left: 300px;margin-top: 100px">
				<input type="text" class="form-control" placeholder="输入人名或公司全称" style="width:600px" name="in" id="in">
				<button id="loginbtn" type="submit" class="btn btn-info">查找</button>
		    </div>
			</form>
	  </div>
	    
</body>
</html>