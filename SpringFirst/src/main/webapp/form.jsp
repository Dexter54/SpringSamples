<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>

</head>

<body>

<form:form  method="POST"  modelAttribute="student" action="son">

        <form:label path="name">Name: </form:label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error"/><br>
        <form:label path="age">Age: </form:label>
        <form:input path="age" />
        <form:errors path="age" cssClass="error"/><br><br>
        <form:button>Submit</form:button>
    </form:form>
</body>

</html>
