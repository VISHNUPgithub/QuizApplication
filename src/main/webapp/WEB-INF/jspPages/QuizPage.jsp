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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.container {
	margin-top: 50px;
}

.quiz-section {
	background-color: #ffffff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
}

.quiz-section h3 {
	margin-bottom: 20px;
}

.form-check {
	margin-bottom: 15px;
}

.form-check-input {
	margin-right: 10px;
}
.btn-submit {
	background-color: #007bff;
	border-color: #007bff;
	width: 100px;
	height: 40px;
	display: block;
	margin: 20px auto;
}
.btn-submit:hover {
	background-color: #0056b3;
	border-color: #0056b3;
}
</style>
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
