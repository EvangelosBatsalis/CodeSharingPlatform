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
        <title>Code</title>
    </head>
    <body>
        <ul>
            <span id="load_date">${date}</span>
            <pre id="code_snippet"><code>${code.getCode()}</code></pre>
            <#if (code.remainingTime > 0)>
                <span id="time_restriction">The code will be available for ${code.getRemainingTime()} seconds </span>
            </#if>
            <br>
            <#if ( code.getRestrictionByViewsIsAccessible() && (code.remainingViews >= 0))>
                <span id="views_restriction">${code.getRemainingViews()} views remaining</span>
            </#if>


        </ul>
    </body>
</html>