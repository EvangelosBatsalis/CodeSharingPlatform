<html>
<head>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
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
    <title>Latest</title>
</head>
<body>
<#list snippets as code>
    <span id="load_date">${code.localDateTime}</span>
    <br>
    <pre id="code_snippet"><code>${code.code}</code></pre>
    <br>
    <br>
</#list>
</body>
</html>