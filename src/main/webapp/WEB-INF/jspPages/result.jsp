<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .result-container {
            margin-top: 50px;
            text-align: center;
        }
        .result-card {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .result-card h1 {
            margin-bottom: 20px;
        }
        .result-card p {
            font-size: 1.25rem;
        }
    </style>
</head>
<body>
    <div class="container result-container">
        <div class="result-card">
            <h1>Congratulations! ${userName}</h1>
            <p>You have completed the quiz.</p>
            <p>Your score is: <strong>${mark}</strong></p>
<<<<<<< HEAD
            <a href="/viewAllQuiz?userName=${userName }" class="btn btn-primary">Start a New Quiz</a>
=======
            <a href="/viewAllQuiz" class="btn btn-primary">Start a New Quiz</a>
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
