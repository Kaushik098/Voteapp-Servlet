<%@page import="com.kaushik.voteapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
        nav{
            float: right; 
        }
        h1{
		     text-align: center;
			 font-style: italic;
         }    

         .container {
           border-radius: 30px;
           background-color: #f2f2f2;
           padding: 30px;
		   margin: 40px;
		   margin-left: 200px;
		   margin-right: 200px;
        }

        .list{
		    font-style: italic;
			padding: 20px;
		 }		
		 
		input[type=submit] {
           background-color: #4CAF50;
           color: white;
           padding: 12px 20px;
           border: none;
           border-radius: 4px;
           cursor: pointer;
           float: right;
        }
		 
		 body {
           border: 2px solid black;
           outline: #4CAF50 solid 10px;
           margin: auto; 
           margin-top: 30px;  
           padding: 20px;
        }
</style>

</head>
<body>
<%
User user = (User)session.getAttribute("LOGGED_IN_USER");
%>

Welcome <%=user.getAdhaarName() %>!!!
     <h1> Vote Your Candidate </h1>
     
     <nav>
        <a href = "Logout"> Logout</a>
     </nav>
	
 <div class = "container">
	     <form action = "Result" method="post">
		      <fieldset>
			       <legend> Choose any 1 Candidate and Submit : </legend> 
				   <div class = "list">
                   <input type ="radio" name = "Candidate"  value = "1800" > Virat Kohli <br> <br>	
                   <input type ="radio" name = "Candidate"  value = "1802" > MS Dhoni <br> 	<br>
                   <input type ="radio" name = "Candidate"  value = "1804" > Suresh Raina <br> 	<br>
                   <input type ="radio" name = "Candidate"  value = "1806" > Shikkhar Dhawan <br> 	<br>
                   <input type ="radio" name = "Candidate"  value = "1808" > Sachin Tendulkar <br> 	<br>
				   </div>
				   <div class="row">
                           <input type="submit" name ="result" value="Submit" >
                   </div> 
			  </fieldset>
		</form>	  	  
</div>

</body>
</html>