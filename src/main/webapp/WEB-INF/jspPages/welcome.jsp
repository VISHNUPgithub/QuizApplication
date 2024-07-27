<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Quiz Challenge</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .navbar {
            margin-top:10px;
            margin-bottom: 60px;
            border-radius: 15px; 
   		    box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1),0 -1px 10px rgba(0, 0, 0, 0.1);
   		    height: 40px;
        }
        .welcome-message {
            margin: 30px 0;
            text-align: center;
        }
        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }
        .form-container h1{
        	text-align: center; 
        }
        .form-container label {
    		font-weight: bold;
		}
        
        .quote {
            font-style: italic;
            font-size: 1.2em;
            text-align: center;
            margin-top: 20px;
        }
        .btn-primary {
            display: block;
            margin: 0 auto;
            width: 35%;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <h1 class="navbar-brand">Quiz</h1>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Admin</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <% if ("home".equals(request.getAttribute("welcome"))) { %>
        <div class="container">
            <div class="welcome-message">
                <h1>Welcome, competitors, to our Quiz challenge!<br>
                We bring competitive questions to improve your skills</h1>
                <p class="quote">"To know what you know and what you do not know, that is true knowledge." - Confucius</p>
            </div>
            <div class="form-container">
                <form action="/viewAllQuiz" method="get">
                    <div class="form-group">
                        <label for="userName">Enter your name:</label>
                        <input type="text" class="form-control" id="userName" name="userName" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Go to Quiz List</button>
                </form>
            </div>
        </div>
    <% } else if ("admin".equals(request.getAttribute("welcome"))) { %>
        <div class="container">
            <div class="form-container">
            <h1>Admin Login</h1>
                <form action="/adminLogin" method="post">
                    <div class="form-group">
                        <label for="adminUserName">Username:</label>
                        <input type="text" class="form-control" id="adminUserName" name="adminUserName" required>
                    </div>
                    <div class="form-group">
                        <label for="adminPassword">Password:</label>
                        <input type="password" class="form-control" id="adminPassword" name="adminPassword" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                </form>
            </div>
        </div>
    <% } %>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
