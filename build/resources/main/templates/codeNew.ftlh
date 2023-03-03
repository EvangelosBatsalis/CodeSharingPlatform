<html>
    <head>
<#--        <style> <#include "/static/css/style.css"></style>-->
<#--        <link rel="stylesheet"-->
<#--              href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">-->
<#--        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>-->
<#--        <script>hljs.initHighlightingOnLoad();</script>-->
                <style>
            #load_date{
                font-size: 16px;
                color: green;
            }
            #code_snippet{
                background-color: aquamarine;
                width: 450px;
                max-width: 1000px;
                height: 100px;
                max-height: 500px;
                box-sizing: border-box;
                resize: both;
                overflow: hidden;
                border: 1px solid gray;
                background-color: whitesmoke;
                font-size: 16px;
            }

        </style>
        <script> //defer src="/static/sendFunction.js"

            function send() {
                let object = {
                    "code": document.getElementById("code_snippet").value,
                    "time":document.getElementById("time_restriction").value,
                    "views":document.getElementById("views_restriction").value
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
        <textarea id="code_snippet" placeholder="// write you code here"></textarea>
        <br><br>
        Time restriction: <input id="time_restriction" type="text" value="0"/>
        <br><br>
        Views restriction: <input id="views_restriction" type="text" value="0"/>
        <br><br>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </body>
</html>