<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

</head>
<body>
<div class="form">
    <form action ="processRegistration" method = "GET">
        <h2>Registration</h2>
        <div class="input-box">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" name="userName" placeholder="UserName" required>
        </div>
        <div class="input-box">
            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
            <input type="password" name="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 4 or more characters" required>
        </div>
        <div class="input-box">
            <input type="submit" name="register" value="Register">
        </div>
        <a href="login">Login</a>
    </form>
</div>
</body>
</html>