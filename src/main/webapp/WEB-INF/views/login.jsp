<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Login</h2>
<form method="post" action="/login">
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
    <label>Username:</label><input type="text" name="username"/><br/>
    <label>Password:</label><input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>
<c:if test="${param.logout}">
    <p>You’ve been logged out.</p>
</c:if>
</body>
</html>
