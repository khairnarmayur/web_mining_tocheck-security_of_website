<%@page import="java.util.Iterator" %>
	<%@page import="web_mining.dto.Admin" %>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Update Password</title>
				<style>
					body {
						background: linear-gradient(90deg, #db2727, #7a6bcc);
					}

					#a7 {
						width: 100%;
						height: 5cm;
					}

					#ax1 {
						text-align: center;
						text-shadow: #D1D1D4;
						text-transform: capitalize;
					}


					#a1 {
						margin-left: 250px;
						margin-right: 40px;
					}

					#a2 {
						margin-right: 40px;
					}

					#a3 {
						margin-right: 90px;
					}

					#a4 {
						margin-right: 80px;
					}

					#a5 {
						margin-right: 0px;
					}

					.navMenu {
						background-color: black;
						margin-top: -60px;
						color: aliceblue;
						padding-bottom: 10px;
					}

					a {
						text-decoration: none;
						color: #D1D1D4;
					}

					a:hover {
						color: aqua;
						font-family: 'Courier New', Courier, monospace;
					}

					#as1 {
						padding-left: 20px;
						padding-bottom: 40px;
						padding-top: 50px;
						border-style: double;
						margin-top: 10px;
						margin-left: 40%;
						margin-right: 500px;
						background: linear-gradient(90deg, #4d028f, #460606);
						color: whitesmoke;
						border-color: goldenrod;
					}

					#as1:hover {
						background: linear-gradient(90deg, #7e48ae, #c71717);
					}

					#ab2 {
						margin-top: 40px;
						margin-left: 260px;
						background-color: #7a6bcc;
						border-radius: 10px;
						border-color: aqua;
						color: whitesmoke;
					}

					#ab2:hover {
						background-color: aqua;
						border-color: blueviolet;
						color: black;
					}

					#ab3 {
						background-color: #7a6bcc;
						border-radius: 10px;
						border-color: aqua;
						color: whitesmoke;
					}

					#ab3:hover {
						background-color: aqua;
						border-color: blueviolet;
						color: black;
					}

					input {
						background-color: blanchedalmond;
						color: black;
					}

					input:hover {
						background-color: dimgray;
						color: white;
					}

					#bs5 {
						border-style: inset;
						margin-left: 110px;
						margin-right: 75px;
						background-color: antiquewhite;
						color: black;
					}
				</style>
			</head>

			<body>
				<% HttpSession h=request.getSession(); Admin a=(Admin) h.getAttribute("admin"); %>
					<header>
						<img src="./CyberNavBar.jpeg" id="a7">
					</header>
					<br><br><br>
					<nav class="navMenu">
						<a id="a1"
							href="AddKeywords.html">ADD&nbsp;KEYWORDS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="a2"
							href="CheckWebsite.html">CHECK&nbsp;WEBSITE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="a3"
							href="CheckAllWebsites.html">CHECK&nbsp;ALL&nbsp;WEBSITES</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="a4"
							href="UpdatePassword.jsp">UPDATE&nbsp;PASSWORD</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a id="a5" href="Home.html">LOGOUT</a>
						<div class="dot"></div>
					</nav>
					<div id="as1">
						<form action="passUpdate" method="post">
							<br>
							<br><br>
							<div id="as5">
								Email Id :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<%=a.getEmail()%>
							</div>
							<br><br>
							<label for="pass1">Old Password :&nbsp;&nbsp;</label>
							<input type="password" name="pass1"><br><br>
							<label for="pass2">New Password :</label>
							<input type="password" name="pass2"><br><br>
<input id=" ab2" type="submit" value="Update">
					</div>
					</form>
			</body>

			</html>