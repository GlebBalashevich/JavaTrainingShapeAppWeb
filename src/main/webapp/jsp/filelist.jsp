<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ShapeApplication</title>
</head>
<h4>Available Files</h4>
<body>
    <form action="processController" method="post">
        <input type="hidden" name="command" value="read_file">
        <select name="reading_file">
            <c:forEach items="${list}" var="file">
                <option value="${file.getFileName()}">
                    <c:out value="${file.getFileName()}"/>
                </option>
            </c:forEach>
            <input type="submit" value="Read File">
        </select>
    </form>
</body>
</html>
