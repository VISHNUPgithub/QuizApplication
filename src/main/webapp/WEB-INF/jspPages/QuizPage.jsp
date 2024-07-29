<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.QuizApp.model.Response"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quiz Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/QuizPage.css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Quiz</h1>
		<form action="/result/${quizId }" method="post">
	
			<c:forEach var="question" items="${questions}">
				<div class="quiz-section mb-4">
					<h3>${question.qTitle}</h3>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="${question.qId}"
							id="option_1" value="${question.option1}" required /> <label
							class="form-check-label" for="option_1">
							${question.option1} </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="${question.qId}"
							id="option_2" value="${question.option2}" required /> <label
							class="form-check-label" for="option_2">
							${question.option2} </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="${question.qId}"
							id="option_3" value="${question.option3}" required /> <label
							class="form-check-label" for="option_3">
							${question.option3} </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="${question.qId}"
							id="option_4" value="${question.option4}" required /> <label
							class="form-check-label" for="option_4">
							${question.option4} </label>
					</div>
				</div>
			</c:forEach>
			<button type="submit" class="btn btn-primary btn-submit">Submit</button>
		</form>
	</div>
</body>
</html>
