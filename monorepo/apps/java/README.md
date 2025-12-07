# Hello App (Java)

Small Java app that prints "Hello World" at startup and exposes two HTTP endpoints:

- `/` -> returns `Hello World`
- `/api` -> returns `ok`

Requirements:

- JDK 11+
- Maven (optional)

Build:

```bash
mvn package
```

Run:

```bash
java -jar target/hello-app.jar
```

Server listens on port 8080.
