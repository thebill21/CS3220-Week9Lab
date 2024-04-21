<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Poll View for #${poll.id} Poll</title>
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
        <a class="btn btn-secondary" href="/" style="display:inline-block; margin-bottom:20px;">Back to All Polls</a>
    </div>
    <h2>Poll View for #${poll.id} Poll</h2>
    <h3>${poll.question}</h3>
</div>
<div class="container mt-4">
    <div class="row">
        <form th:action="@{/submitPoll/${poll.id}" method="post">
            <input type="hidden" name="pollId" th:value="${poll.id}"/>
            <table class="table centered-table">
                <thead>
                <tr>
                    <th scope="col">Option</th>
                    <th scope="col">Votes</th>
                </tr>
                </thead>
                <tbody>
                <#list options as option>
                    <tr>
                        <td>${option.option}</td>
                        <td>
                            <#if poll.isSingleChoice>
                                <input type="radio" name="options${poll.id}" value="${option.id}" />
                            <#else>
                                <input type="checkbox" name="options${poll.id}" value="${option.id}" />
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <button type="submit" class="btn btn-secondary">Submit</button>
        </form>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>
