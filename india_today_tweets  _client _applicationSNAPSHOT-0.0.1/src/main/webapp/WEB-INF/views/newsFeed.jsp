<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tweets India Today</title>


<script type="text/javascript">
        function load()
        {
        setTimeout("window.open(self.location, '_self');", 300000);
        }
</script>
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
    	body{
    		background:url("https://cdn.pixabay.com/photo/2014/04/08/19/38/sky-319546_960_720.png");
    		background-size:cover;
    		background-repeat: no-repeat;
    	}
	

        .newscontainer{
            width: 70%; 
            border: 3px solid black;
            color: black;
            border-radius: 5px;
	    background-color:rgb(210, 210, 210);
        }

        .newscontainer:hover{
            border: 3px solid lightblue;
            color: black;
        }
        
        .padding{
        	padding-left: 30px;
        }
        
        .CreatedDateColor{
        	color: DodgerBlue;
        }

    </style>
</head>
<body onload="load()">
<h1 class="mt-5 mb-4" style="text-align: center;">India Today Tweets - "${date}"</h1>
	
		
			<c:forEach items="${newsBeans}"  var="newsBean">
        	<a href="${newsBean.url}" style="text-decoration: none;">
            	<div class="newscontainer container mb-3">
                	<div class="rowstyle row mb-2">
                    	<div class="col-sm-2 text-right">
                        	<img src="https://pbs.twimg.com/profile_images/787569535880531968/3FtQQHyA_400x400.jpg" style="width: 100px; border-radius:100%;">
                    	</div>
                    <div class="col-sm-10 padding" >
                        <div class="row">
                            <h3>@${newsBean.fromUser}</h3>&nbsp &nbsp<span class="CreatedDateColor">${newsBean.createdDate}</span>
                        </div>
                    	<div class="row">
                            <p>${newsBean.text}</p>
                        </div>
                    </div>
                </div>
            </div>
        </a>
        </c:forEach>
	
</body>
</html>