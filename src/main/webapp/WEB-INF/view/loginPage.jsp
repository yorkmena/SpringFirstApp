<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

</head>
<body>
<div class="form">
    <form action ="processLogin" method = "GET">
        <h2>Login</h2>
        <div class="input-box">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" name="userName" placeholder="UserName" required>
        </div>
        <div class="input-box">
            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
            <input type="password" name="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 4 or more characters" required>
        </div>
        <div class="input-box">
            <input type="submit" name="sign-in" value="Login">
        </div>
        <a href="register">Register</a>
    </form>
</div>
</body>
</html>