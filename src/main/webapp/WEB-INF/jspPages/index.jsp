<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select Quiz</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center">Select a Quiz</h1>
        <div class="instructions">
            <h2>Instructions</h2>
            <p>1. Every question has four options. Select any option.</p>
            <p>2. For every correct answer, you will get 1 point.</p>
            <p>3. There is no negative mark for the wrong answer.</p>
        </div>
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
</body>
</html>
