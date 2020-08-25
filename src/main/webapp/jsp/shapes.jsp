<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>ShapeApplication</title>
</head>
<h4>Shapes</h4>
<body>
    <table border="1">
        <tr>
            <th>Point A</th>
            <th>Point B</th>
            <th>Point C</th>
            <th>Point D</th>
        </tr>
        <c:forEach items="${quadrangleList}" var="quadrangle">
            <tr>
                <td>${quadrangle.getPointA()}</td>
                <td>${quadrangle.getPointB()}</td>
                <td>${quadrangle.getPointC()}</td>
                <td>${quadrangle.getPointD()}</td>
            </tr>
        </c:forEach>
    </table>
    <button type="button" name="back" onclick="history.back()">Back</button>
</body>
</html>
