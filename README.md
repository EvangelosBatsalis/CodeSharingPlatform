<h1 align="center"> Welcome </h1>
<p>"Code Sharing Platform" is a simple application from Hyperskill academy "Java project" from "Backend Development path" that allows you to share code, set views and time limits.
Using Spring JVM and some business logic. H2 DB for persistent memory with JPA crud repository. View model through apache freemarker as java template engine and API endpoints (API tests through Postman).
<br><br>Link for Deployed Spring Boot web application on Amazon EC2 on AWS: "Under Construction Soon it will be available"</p>
<h1>Hyperskill Description:</h1>
<p>Sometimes, it's useful to have a tool that can help you share a piece of code with other programmers. Actually, there is a website called Pastebin that does exactly that. A huge downside of Pastebin is that every piece of code you share automatically becomes available for the public. This could present a problem since many programmers work under the NDA (Non-disclosure agreement) which prohibits the use of such services to prevent the source code from leaking.

If there is a team of programmers who work in the same company and want to exchange pieces of code, they can solve this problem by using their own implementation of Pastebin. Such a web service is supposed to be accessible only locally, not via the Internet. In this project, you will write a service just like that.

As you're working on the project, you will implement two types of interfaces: API and web interface. The API interface should be accessed through endpoints that start with /api while web interface endpoints should start with /. The API interface should return data as JSON, while the web interface should use HTML, JS, and CSS.</p>
<hr>
<h1>Endpoints </h1>
<strong>API:</strong>
<ol>
<li>
<p><code>GET /api/code/{uuid}</code> - return JSON with the following fields:</p>
<ul>
<li><code>snippetUUID</code> - UUID (string)</li>
<li><code>code</code> - code (string)</li>
<li><code>header</code> - title (string)</li>
<li><code>createDate</code> - date of creation (string in <code>yyyy-MM-dd'T'HH-mm-ss</code> format)</li>
<li><code>views</code> - all views count (number)</li>
<li><code>deleteDate</code> - date until snippet will be available (string in <code>yyyy-MM-dd'T'HH-mm-ss</code> format or null if there is no limit)</li>
<li><code>viewsLimit</code> - allowed number of views (number or null if there is no limit)</li>
</ul>
</li>
<li>
<p><code>GET /api/code/all</code> - return JSON array with all snippets stored in database in the format above</p>
</li>
<li>
<p><code>POST /api/code/new</code> - create new snippet and return it UUID as String.<br>
RequestBody should be JSON with the following fields:</p>
<ul>
<li>Required: <code>code</code>, <code>header</code> as string</li>
<li>Optional: <code>viewsLimit</code>, <code>minutesLimit</code> as number</li>
</ul>
</li>
</ol>
<br><br>
<strong>Web HTML:</strong>
<li><code>GET /code/{uuid}</code> - return page with code snippet</li>
<li><code>GET /code/new</code> - return page with submit form</li>
<li><code>GET /code/all</code> - return page with all snippets stored in database</li>
</ol>
<hr>
<strong>Compile and Run:</strong>
<div class="snippet-clipboard-content notranslate position-relative overflow-auto" data-snippet-clipboard-copy-content="git clone https://github.com/Dalvikk/CodeSharingPlatform
cd ./CodeSharingPlatform/
./gradlew.bat bootJar
java -jar ./build/libs/snippet.jar"><pre class="notranslate"><code>git clone https://github.com/Dalvikk/CodeSharingPlatform
cd ./CodeSharingPlatform/
./gradlew.bat bootJar
java -jar ./build/libs/snippet.jar
</code></pre></div>
