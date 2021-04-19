<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="d-flex p-2">
        <div>
            <h1>Language Details about ${showLanguage.name}</h1>

            <p>Creator:
                <c:out value="${showLanguage.creator}" />
            </p>
            <p>Current Version:
                <c:out value="${showLanguage.version}" />
            </p>
            <a href="/languages/${showLanguage.id}/edit">Edit Language</a> | <a
                href="/languages/${showLanguage.id}/delete">Delete Language</a>
        </div>
        <div>
            <a href="/languages">Dashboard</a>
        </div>
    </div>
</body>

</html>