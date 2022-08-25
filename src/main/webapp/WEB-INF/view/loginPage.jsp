<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="form">
    <form action ="processForm" method = "GET">
        <h2>Login</h2>
        <div class="input-box">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" name="username" placeholder="UserName" required>
        </div>
        <div class="input-box">
            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
            <input type="password" name="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
        </div>
        <div class="input-box">
            <input type="submit" name="sign-in" value="Login">
        </div>
        <a href="/register">Navigate to Register</a>
    </form>
</div>
</body>
</html>