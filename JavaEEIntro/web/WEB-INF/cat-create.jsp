<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>
<h1>Create a Cat!</h1>
<form method="post">
    <div>
        <label for="name-input">Name:</label>
        <input type="text" name="name" id="name-input"/>
    </div>
    <div>
        <label for="breed-input">Breed:</label>
        <input type="text" name="breed" id="breed-input"/>
    </div>
    <div>
        <label for="color-input">Color:</label>
        <input type="text" name="color" id="color-input"/>
    </div>
    <div>
        <label for="legs-count-input">Number of legs:</label>
        <input type="number" name="legs-count" id="legs-count-input"/>
    </div>
    <div>
        <input type="submit" value="Create Cat"/>
    </div>
    <br/>
    <a href="/">Back To Home</a>
</form>
</body>
</html>
