<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="js/alchemy.min.css"/>
  <link rel="stylesheet" type="text/css" href="css/vendor.css">
  <script type="text/javascript" src="js/vendor.js"></script>
  <script src="js/alchemy.min.js"></script>
</head>
<body>
  <div class="alchemy" id="alchemy"></div>
  <script type="text/javascript">
    alchemy.begin({
        	dataSource: "cluster1.json", 
        	nodeMouseOver: 'name',
            cluster: true,
            clusterColours: ["#1B9E77","#D95F02"]})
     alert("aaa");

  </script>
</body>
</html>