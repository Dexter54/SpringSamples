<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>

</head>

<body>

<form:form  method="POST"  modelAttribute="studentmanager" action="son">

        <form:label path="stud.name">Name: </form:label>
        <form:input path="stud.name" />
        <form:errors path="stud.name" /><br>
        <form:label path="stud.surname">Surname: </form:label>
        <form:input path="stud.surname" />
        <form:errors path="stud.surname" /><br><br>
        <form:label path="stud.Dep">Dep: </form:label>
        <form:input path="stud.Dep" />
        <form:errors path="stud.Dep" /><br><br>
        <form:label path="stud.age">Age: </form:label>
        <form:input path="stud.age" />
        <form:errors path="stud.age" /><br><br>
        <form:button>Submit</form:button>
    </form:form>
</body>

</html>
