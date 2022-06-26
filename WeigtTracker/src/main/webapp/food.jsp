<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Food</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/tracker/'">Home</button>
     </div>
     <form action="/app/tracker/" method="post">
                                 <div visible="hidden">
                                     <input type="hidden" name="command" value="addFood">
                                 </div>

                                 <label><b>Add food</b></label>
                                 <input name="name" type="text" placeholder="Enter name" required>
                                 <input name="calories" type="text" placeholder="Enter calories" required>
                                 <input name="proteins" type="text" placeholder="Enter proteins" required>
                                 <input name="fats" type="text" placeholder="Enter fats" required>
                                 <input name="carbohydrates" type="text" placeholder="Enter carbohydrates" required>

                                 <button type="submit">Add</button>

                    </form>
    <form action="/app/tracker/" method="post">
                  <div visible="hidden">
                      <input type="hidden" name="command" value="deleteFood">
                  </div>

                  <label><b>Delete food by id</b></label>
                  <input name="id" type="text" placeholder="Enter id" required>
                  <button type="submit">Delete</button>

     </form>
    <c:forEach var="item" items="${requestScope.food}">
                    <p>food id = "${item.id()}" </p>
                    <p>food name = "${item.name()}" </p>
                    <p> calories = "${item.calories()}"</p>
                    <p> proteins = "${item.proteins()}"</p>
                    <p> fats = "${item.fats()}"</p>
                    <p> carbohydrates = "${item.carbohydrates()}"</p>
    <hr>
    </c:forEach>
</body>
</html>