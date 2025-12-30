<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Welcome, ${pageContext.request.userPrincipal.name}</h2>
<form method="post" action="/logout">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
