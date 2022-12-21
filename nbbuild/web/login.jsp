
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="login.css">
  <title>login</title>
</head>
<body>

  <input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
    <form action="loginServlet" method="post">
  <div class="loginbox">
    <img src="Avatar.png" class="avatar" alt="">
    <h1>Login here</h1>
      <p>User name</p>
      <input type="text" aria-label="username" name="username" placeholder="Username or email" required>
      <p>Password</p>
      <input type="password" name="password" placeholder="password" required>
      <input type="submit" name="" value="login">
      <br>
      <a href="#">Forgot password?</a><br>
      <a href="Register.jsp">Don't have an account?</a>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>  
  <script type="text/javascript">
    var status=document.getElementById("status").value;
    if(status=="failed"){
      swal("Sorry","Wrong UserName or Password","error");
    }
  </script>
</body>
</html>