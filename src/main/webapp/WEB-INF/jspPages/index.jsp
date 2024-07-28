<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Quiz</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .quiz-item {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px 0;
            border-radius: 8px;
            background-color: #ffffff;
            transition: background-color 0.3s, box-shadow 0.3s;
        }
        .quiz-item:hover {
            background-color: #e9ecef;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .quiz-item input[type="radio"] {
            margin-right: 10px;
        }
        .quiz-item label {
            display: block;
            cursor: pointer;
        }
        .quiz-item h3 {
            margin: 0;
            font-size: 1.25rem;
            color: #343a40;
        }
        .quiz-item p {
            margin: 5px 0;
            color: #6c757d;
        }
        .btn-submit {
            background-color: #007bff;
            border-color: #007bff;
            width: 100px;
            height: 40px;
            font-size: 0.875rem;
            padding: 0.375rem 0.75rem;
            margin: 20px auto;
            display: block;
        }
        .btn-submit:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
        .text-center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Select a Quiz</h1>
        <form action="/get" method="post">
            <c:forEach var="quiz" items="${QuizList}">
                <div class="quiz-item">
                    <input type="radio" id="quiz${quiz.qId}" name="quizId" value="${quiz.qId}" required>
                    <label for="quiz${quiz.qId}">
                        <h3>${quiz.qTitle}</h3>
                        <p>Category: ${quiz.category}</p>
                    </label>
                </div>
            </c:forEach>
            <button type="submit" class="btn btn-primary btn-submit">Submit</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
