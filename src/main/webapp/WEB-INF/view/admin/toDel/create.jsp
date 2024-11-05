<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <style>
                * {
                    margin: 0;
                    padding: 0;
                }
            </style>
        </head>

        <body>
            <form:form action="/createF" method="post" modelAttribute="newPeople" enctype="multipart/form-data">
                <div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
                    <div>
                        <div>
                            <label for="fname">name:</label><br>
                            <form:input type="text" id="fname" name="fname" path="name" /><br>
                        </div>

                        <div>
                            <label for="lname">pass:</label><br>
                            <form:input type="text" id="lname" name="lname" path="pass" />
                        </div>

                        <div>
                            <input type="file" id="myFile" name="fileName">
                        </div>

                        <div>
                            <form:select class="form-select" aria-label="Default select example" path="roless.name">
                                <form:option value="Admin">Admin</form:option>
                                <form:option value="User">User</form:option>
                            </form:select>
                        </div>

                        <div style="margin-top: 17px;">
                            <button type="submit">submit </button>
                        </div>
                    </div>
                </div>
            </form:form>
        </body>

        </html>