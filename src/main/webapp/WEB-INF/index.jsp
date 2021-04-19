<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Dojo Languages</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
    <div class="container">
        <h1>Dojo Languages</h1>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Creator</th>
                    <th scope="col">Version</th>
                    <th scope="col">Actions</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allLanguages }' var='language'>
                    <tr>
                        <td>${language.name}</td>
                        <td>${language.creator}</td>
                        <td>${language.version}</td>
                        <td><a href="/languages/${language.id}">View Details</a>| <a
                                href="/languages/${language.id}/edit">Edit</a>
                            | <a href="/languages/${language.id}/delete">Delete</a></td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <h1>New Language</h1>
        <form:form action="/languages" method="post" modelAttribute="language">
            <p>
                <form:label path="name">Name</form:label>
                <form:errors path="name" />
                <form:input path="name" />
            </p>
            <p>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator" />
                <form:textarea path="creator" />
            </p>
            <p>
                <form:label path="version">Version</form:label>
                <form:errors path="version" />
                <form:input type="number" path="version" />
            </p>
            <input type="submit" value="Submit" />
        </form:form>
    </div>
</body>

</html>