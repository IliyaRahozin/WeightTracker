<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Profile</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/tracker/'">Home</button>
     </div>

         <p>user name = "${user.username()}" </p>
          <p>user age = "${user.age()}"</p>
          <p>user height = "${user.height()}"</p>
          <p>user weight = "${user.weight()}"</p>
          <p>user lifestyle = "${requestScope.lifestyle}"</p>

            <form action="/app/tracker/" method="post">
                            <div visible="hidden">
                                <input type="hidden" name="command" value="commandUpdateUser">
                            </div>

                            <label><b>Update user info</b></label>
                            <input name="username" type="text" placeholder="Enter username" required>
                            <input name="age" type="text" placeholder="Enter age" required>
                            <input name="height" type="text" placeholder="Enter height" required>
                            <input name="weight" type="text" placeholder="Enter weight" required>
                            <select id="lifestyle" name="lifestyle" >
                                    <c:forEach var="lifestyle" items="${requestScope.lifestyles}">
                                              <option value="${lifestyle.id()}"> ${lifestyle.type()} </option>
                                    </c:forEach>
                            </select>
                            <button type="submit">Update</button>

                    </form>
</body>
</html>