<html>
    <head>
        <script>
            function send() {
                let object = {
                    "code": document.getElementById("code_snippet").value
                };

                let json = JSON.stringify(object);

                let xhr = new XMLHttpRequest();
                xhr.open("POST", '/api/code/new', false)
                xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                xhr.send(json);

                if (xhr.status == 200) {
                    alert("Success!");
                }
            }
        </script>
        <title>
            Create
        </title>
    </head>
    <body>
<#--        <pre id="code_snippet">${code_snipet}</pre>-->
        <br>
<#--        <span id="load_date">${date}</span>-->
        <br>
        <textarea id="code_snippet"> ${code_snipet} </textarea>
        <br>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </body>
</html>