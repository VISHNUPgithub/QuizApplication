<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .navbar {
            margin-top: 10px;
            margin-bottom: 60px;
            border-radius: 15px;
            box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1), 0 -1px 10px rgba(0, 0, 0, 0.1);
            height: 40px;
        }
        .container {
            margin-top: 30px;
        }
        .btn-primary {
            display: block;
            margin: 10px auto;
            width: 100%;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }
        .aside {
            background: #f8f9fa;
            padding: 20px;
            border-right: 1px solid #ddd;
        }
        .main-content {
            padding: 20px;
        }
        .row {
            display: flex;
        }
        .question-label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #007bff;
        }
        .option-label, .answer-label, .category-label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #28a745;
        }
        .category-label {
            color: #17a2b8;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <h1 class="navbar-brand">Quiz Admin</h1>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Back</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <div class="container">
        <div class="row">
            <div class="col-md-3 aside">
                <h2>Admin Panel</h2>
                <form action="/adminPanel" method="get">
                    <button type="submit" name="adminSection" value="viewQuestions" class="btn btn-primary">View Questions</button>
                    <button type="submit" name="adminSection" value="addNewQuestion" class="btn btn-primary">Add New Question</button>
                    <button type="submit" name="adminSection" value="viewSubmissions" class="btn btn-primary">View Submissions</button>
                </form>
            </div>
            <div class="col-md-9 main-content">
                <% 
                    String adminSection = (String) request.getAttribute("adminSection");
                %>
                
                <!-- View Questions Section -->
                <% if ("viewQuestions".equals(adminSection)) { %>
                    <h2>View Questions</h2>
                    <form action="/deleteQuestion" method="post">
                        <c:forEach var="question" items="${questions}">
                            <div class="form-group">
                                <label class="question-label">Question: ${question.qTitle}</label>
                                <label class="option-label">Option 1: ${question.option1}</label>
                                <label class="option-label">Option 2: ${question.option2}</label>
                                <label class="option-label">Option 3: ${question.option3}</label>
                                <label class="option-label">Option 4: ${question.option4}</label>
                                <label class="answer-label">Right Answer: ${question.rightAnswer}</label>
                                <label class="category-label">Category: ${question.category}</label>
                                <input type="hidden" name="questionId" value="${question.qId}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                                <button type="button" class="btn btn-secondary" onclick="location.href='/updateQuestion?id=${question.qId}'">Update</button>
                            </div>
                        </c:forEach>
                    </form>
                <% 
                    } else if ("addNewQuestion".equals(adminSection)) { 
                %>
                    <h2>Add New Question</h2>
                    <div class="form-container">
                        <form action="/addQuestion" method="post">
                            <div class="form-group">
                                <label for="questionText" class="question-label">Question:</label>
                                <input type="text" class="form-control" id="questionText" name="qTitle" required>
                                <label for="option1" class="option-label">Option 1:</label>
                                <input type="text" class="form-control" id="option1" name="option1" required>
                                <label for="option2" class="option-label">Option 2:</label>
                                <input type="text" class="form-control" id="option2" name="option2" required>
                                <label for="option3" class="option-label">Option 3:</label>
                                <input type="text" class="form-control" id="option3" name="option3" required>
                                <label for="option4" class="option-label">Option 4:</label>
                                <input type="text" class="form-control" id="option4" name="option4" required>
                                <label for="rightAnswer" class="option-label">Right Answer:</label>
                                <input type="text" class="form-control" id="rightAnswer" name="rightAnswer" required>
                                <label for="category" class="option-label">Category:</label>
                                <input type="text" class="form-control" id="category" name="category" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Add Question</button>
                        </form>
                    </div>
       <% }if ("viewSubmissions".equals(adminSection)) { %>
    <h2>All User Submissions</h2>

    <c:forEach var="submissionEntry" items="${mappedSubmission}">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3>User: ${submissionEntry.key.userName}</h3>
                <p>Mark: ${submissionEntry.key.mark}</p>
            </div>
            <div class="panel-body">
                <p>Questions and Answers:</p>
                <ul>
                    <c:forEach var="question" items="${submissionEntry.value}" varStatus="status">
                        <li>
                            <p><strong>Question:</strong> ${question.qTitle}</p>
                            <p><strong>Option 1:</strong> ${question.option1}</p>
                            <p><strong>Option 2:</strong> ${question.option2}</p>
                            <p><strong>Option 3:</strong> ${question.option3}</p>
                            <p><strong>Option 4:</strong> ${question.option4}</p>
                            <p><strong>Right Answer:</strong> ${question.rightAnswer}</p>
                            <p><strong>Category:</strong> ${question.category}</p>

                            <p><strong>Selected Answer:</strong>
                                <c:choose>
                                    <c:when test="${status.index < fn:length(list)}">
                                        <c:out value="${list[status.index][0]}"/>
                                    </c:when>
                                    <c:otherwise>
                                        Not answered
                                    </c:otherwise>
                                </c:choose>
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </c:forEach>
<% } %>

            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
