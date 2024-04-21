<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Add Answer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"/>
    <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css"/>
</head>

<body>
<div class="container mt-4">
    <div class="container mt-4">
        <a class="btn btn-secondary" href="/" style="display:inline-block; margin-bottom:20px;">Back to Poll</a>
    </div>
</div>
<div class="container">
    <div class="container mt-4">
        <ul>
            <#list options as option>
                <li>${option.option}</li>
            </#list>
        </ul>
        <form action="/addAnswer/add" method="post">
            <input type="hidden" name="pollId" value="${poll.id}">
            <input type="hidden" name="isSingleChoice" value="${poll.isSingleChoice?then('true','false')}">
            <input class="form-control" type="text" name="newAnswer" required placeholder="Your answer here">
            <button class="btn btn-secondary" type="submit">Add New Answer</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>
