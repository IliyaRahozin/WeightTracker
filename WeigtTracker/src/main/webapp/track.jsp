<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Track</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/tracker/'">Home</button>
     </div>
     <h3>Your current sum</h3>
     <p>calories = "${current_sum.calories()}" </p>
     <p>proteins = "${current_sum.proteins()}" </p>
     <p>fats = "${current_sum.fats()}" </p>
     <p>carbohydrates = "${current_sum.carbohydrates()}" </p>

     <h3>Your max sum</h3>
     <p>calories = "${max_sum.calories()}" </p>
     <p>proteins = "${max_sum.proteins()}" </p>
     <p>fats = "${max_sum.fats()}" </p>
     <p>carbohydrates = "${max_sum.carbohydrates()}" </p>

    <form action="/app/tracker/" method="post">
                  <div visible="hidden">
                      <input type="hidden" name="command" value="eatFood">
                  </div>
                <c:if test = "${limit == true}">
                                         <p>The limit has come, stop eating!<p>
                                </c:if>
                  <h3><b>Eat food by id</b></h3>
                  <input name="id" type="text" placeholder="Enter id" required>
                  <button type="submit">Eat</button>

     </form>
</body>
</html>