<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>ShapeApplication</title>
</head>
<h4>Load File Page</h4>
<body>
<form action="upload" enctype="multipart/form-data" method="post">
    <input type="file" name="loading_file" accept="text/plain">
    <input type="submit" value="Load">
    <p>${message}</p>
</form>
<form action="processController" method="post">
    <input type="hidden" name="command" value="show_files">
    <input type="submit" value="Show Files">
</form>

</body>
</html>
