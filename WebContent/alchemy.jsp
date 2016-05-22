<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
  <link rel="stylesheet" href="css/alchemy.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/vendor.css">
</head>
<body>
  <div class="alchemy" id="alchemy"></div>
<script type="text/javascript" src="js/vendor.js"></script>
 <script src="js/alchemy.min.js" type="text/javascript"charset="utf-8"></script>
  <script type="text/javascript">
        var config = {
            dataSource: 'mm1.json',
            };
        alert(config);
        alchemy = new Alchemy(config)
    </script>
  </body>
</html>