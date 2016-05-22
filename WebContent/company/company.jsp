<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="/bs/css/alchemy.min.css"/>
    <link rel="stylesheet" type="text/css" href="/bs/css/vendor.css">
    <%
 String companyName = (String)request.getAttribute("companyName");
 %>
    <title><%=companyName %></title>
</head>
<body>
  <div class="alchemy" id="alchemy"></div>
<script type="text/javascript" src="/bs/js/vendor.js" charset="utf-8"></script>
 <script src="/bs/js/alchemy.min.js" type="text/javascript" charset="utf-8"></script>
 <%
 String fileName = (String)request.getAttribute("fileName");
 %>
  <script type="text/javascript" charset="utf-8">
       var config = {
            dataSource: '/bs/company/<%=fileName%>.json',
            edgeTypes: {"edgeType":["CompanyAndPerson", "CompanyAndCompany"]}, 
            nodeTypes: {"nodeType":["Person", "Company","CoreCompany"]},
            forceLocked: true,
            nodeCaption: 'id',
            edgeCaption: 'edgeType',
            nodeStyle: {
            	"CoreCompany": {
                  "color"      : "#FFA500",
                  "radius"     : 20,
                  "borderWidth": 8
                  },
              "Person": {
                  "color"      : "#F6F",
                  "radius"     : 20,
                  "borderWidth": 8
              },
              "Company":{
                  "radius"     : 10
              }
            },
            edgeStyle: {
                  "CompanyAndPerson": {
                  "width": 5,
                  "color": "rgb(0,255,0)"
              },
                  "CompanyAndCompany": {
                  "width": 3,
                  "color": "rgb(0,255,0)"
              }
            }
          }

        alchemy = new Alchemy(config)
    </script>
  </body>
</html>