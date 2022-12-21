<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car  Rental</title>
    <link rel="stylesheet" href="UserPage.css">
</head>
<body>
    <form action="UserPage">
    <nav>
        <div class="logo">
            <p>go</p>
        </div>
        <ul>
            <li><a href="logout"><%= session.getAttribute("username")%></a></li>
            <li><a href="#"><button>Account</button></a></li>
            <li><a href="#"><button>history</button></a></li>
            <li><button>About</button></li>
            <li><button>Logout</button></li>
        </ul>
    </nav>
    <br>
    <br>
    <div class="Company-name">
        <h1>Car Rental</h1>
    </div>
</form>

</body>
</html>