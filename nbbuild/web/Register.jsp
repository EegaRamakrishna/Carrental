<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="Register.css">

  <title>Register</title>
</head>
<body>
  <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
  <div class="Registebox">
    <img src="Avatar.png" class="avatar" alt="">
    <h1>Register here</h1>
    <form action="register" method="post">
      <p>Username</p>
      <input type="text" name="username" placeholder="Username or email" required>
      <p>First Name</p>
      <input type="text" name="firstname" placeholder="Firstname" required>
      <p>Lastname</p>
      <input type="text" name="lastname" placeholder="last name" required>
      <p>Mobile number</p>
      <input type="tel" name="phone" value="+91">
      <p>Email</p>
      <input type="email" name="email" placeholder="abc@gmail.com" required>
      <p>Gender :</p>
      <select required name="gender" id="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
      </select>
      <p>Password</p>
      <input type="password" name="password" placeholder="password" required>
      <p>Retype Password</p>
      <input aria-label="h" type="password" name="Retype-password" placeholder="Retype password" required>
      <input type="submit" name="Signup" value="Signup"><br>
      <a href="login.jsp">Have an account?</a>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link>  
  <script type="text/javascript">
    var status=document.getElementById("status").value;
    if(status=="success"){
      swal("Well Done","Your Account is created","success");
    }
  </script>
</body>
</html>