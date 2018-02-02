<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
<c:forEach items="${stocks}" var="stock">
    
       ${stock.highPrice}

</c:forEach>
  
</body>
</html>