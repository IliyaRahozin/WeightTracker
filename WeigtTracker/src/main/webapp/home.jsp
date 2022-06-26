<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weight Tracker</title>
</head>
<body>
<div>
    <h1>Weight Tracker</h1>
</div>

<div>
    <div>
        <button onclick="location.href='/app/tracker/?command=login'">Login</button>
        <button onclick="location.href='/app/tracker/?command=register'">Register</button>
        <c:if test = "${sessionScope.registered == true}">
            <button onclick="location.href='/app/tracker/?command=foodList'">Food</button>
        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                <button onclick="location.href='/app/tracker/?command=track'">Track</button>
        </c:if>
        <c:if test = "${sessionScope.admin == true}">
            <button onclick="location.href='/app/tracker/?command=usersList'">Users</button>
        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                                    <button onclick="location.href='/app/tracker/?command=commandProfile'">Profile</button>
                        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                    <button onclick="location.href='/app/tracker/?command=logOut'">LogOut</button>
        </c:if>

    </div>
</div>
</body>
</html>