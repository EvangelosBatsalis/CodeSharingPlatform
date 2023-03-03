# Welcome
"Code Sharing Platform" is a simple application from Hyperskill academy "Java project" from "Backend Development path" that allows you to share code, set views and time limits. Using Spring JVM and some business logic. H2 DB for persistent memory with JPA crud repository. View model through apache freemarker as java template engine and API endpoints (API tests through Postman).

Link for Deployed Spring Boot web application on Amazon EC2 on AWS: "Under Construction Soon it will be available"

## Hyperskill Project Description:
Sometimes, it's useful to have a tool that can help you share a piece of code with other programmers. Actually, there is a website called Pastebin that does exactly that. A huge downside of Pastebin is that every piece of code you share automatically becomes available for the public. This could present a problem since many programmers work under the NDA (Non-disclosure agreement) which prohibits the use of such services to prevent the source code from leaking.

If there is a team of programmers who work in the same company and want to exchange pieces of code, they can solve this problem by using their own implementation of Pastebin. Such a web service is supposed to be accessible only locally, not via the Internet. In this project, you will write a service just like that.

As you're working on the project, you will implement two types of interfaces: API and web interface. The API interface should be accessed through endpoints that start with /api while web interface endpoints should start with /. The API interface should return data as JSON, while the web interface should use HTML, JS, and CSS.


## API Reference:

#### Get item

```GET /api/code/{uuid}``` - return JSON with the following fields: 

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `CodeUUID`| `String` | UUID                              |
| `Code`    | `String` | Code (returns code from DB)       |
| `Date`    | `String` | returns Code creationLocal date time (format: dd-MM-yyyy HH:mm:ss)   |
| `Time`    | `Integer` | returns how long it will be reains stored to DB   |
| `Views`   | `Integer` | returns how many times permited to view the code   |

```GET /api/code/all``` - return JSON array with most 10 Code snippets stored in database in the format above.

```POST /api/code/new``` - create new snippet and return it UUID as String.

### RequestBody should be JSON with the following fields:
- Required: code, header as string
- Optional: viewsLimit, minutesLimit as number

### Web HTML:
```GET /code/{uuid}``` - return page with code snippet.

```GET /code/new``` - return page with submit form.

```GET /code/all``` - return page with all snippets stored in database

### Compile and Run:
```
git clone https://github.com/EvangelosBatsalis/CodeSharingPlatform
cd ./CodeSharingPlatform/
./gradlew.bat bootJar
java -jar ./build/libs/snippet.jar
```
