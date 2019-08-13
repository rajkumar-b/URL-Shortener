<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>URL Shortener - Demo Site</title>
</head>
<body>
	<form action="shortenURL" method="post">
		<input 	type="url" 
				name="inputUrlReal" 
				value="${inputUrlReal}"
				placeholder="Enter the URL to Shorten"/>
				
		<input 	type="submit" 
				value="Get Shortened URL!"/>
				
		<input 	type="text" 
				name="shortenedUrl" 
				value="${shortenedUrl}"/>
	</form>
	
	<h4>OR</h4>
	
	<form action="expandURL" method="post">
		<input 	type="text" 
				name="inputUrlShort" 
				value="${inputUrlShort}"
				placeholder="Enter the URL to Expand"/>
				
		<input 	type="submit" 
				value="Get Real URL!"/>
				
		<input 	type="text" 
				name="expandedUrl" 
				value="${expandedUrl}"/>
	</form>
	
</body>
</html>