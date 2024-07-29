<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/result.css">
</head>
<body>
    <div class="container result-container">
        <div class="result-card">
            <h1>Congratulations! ${userName}</h1>
            <p>You have completed the quiz.</p>
            <p>Your score is: <strong>${mark} out of ${TotalNumberOfAttemptedQuestions}</strong></p>
            <a href="/viewAllQuiz?userName=${userName }" class="btn btn-primary">Start a New Quiz</a>
        </div>
    </div>
</body>
</html>
