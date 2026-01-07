# spring-boot-demo ✅

A simple Spring Boot demo application that demonstrates REST controllers and JPA integration with MySQL.

## Table of Contents
- **Prerequisites**
- **Quick start**
- **Database setup**
- **Run locally**
- **Build & package**
- **Tests**
- **Configuration**
- **Troubleshooting & minor steps**
- **Useful commands**

---

## Prerequisites ⚙️

- Java 21 (as set by `maven.compiler` / `java.version` in `pom.xml`)
- Maven or the included wrapper (`./mvnw` on Unix)
- MySQL server (or use embedded H2 if you switch configuration)

Make sure Java and Maven are available on your PATH:

```bash
java -version
mvn -v      # or use ./mvnw -v inside the project
```

---

## Quick start ▶️

1. Clone the repo and change to the project directory:

```bash
git clone <repo-url>
cd spring-boot-demo
```

2. Ensure `src/main/resources/application.properties` contains the correct DB settings (example below).

3. Start the application:

```bash
./mvnw spring-boot:run
# or
mvn spring-boot:run
```

The app will start on port 8080 by default.

---

## Database setup (MySQL) 🛠️

Example commands to create the database used by the app:

```sql
CREATE DATABASE spring_boot_java;
CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'yourpassword';
GRANT ALL PRIVILEGES ON spring_boot_java.* TO 'springuser'@'localhost';
FLUSH PRIVILEGES;
```

Update `src/main/resources/application.properties` with your connection values:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot_java?useSSL=false&serverTimezone=UTC
spring.datasource.username=springuser
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Tip: You can also set these values via environment variables (e.g. `SPRING_DATASOURCE_URL`).

---

## Run locally & test endpoints 🧪

After starting the app, a few sample endpoints are available (see controllers):

- `GET /` or `GET /hello` - basic hello endpoint
- `GET /api/persons` - list persons (if implemented)
- `POST /api/persons` - create a person (JSON body)

Example curl:

```bash
curl -s http://localhost:8080/hello

curl -X POST http://localhost:8080/api/persons \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice","age":30}'
```

---

## Build & package 📦

Package the jar:

```bash
./mvnw package
# or
mvn package

# Run the produced jar
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## Tests ✅

Run unit tests:

```bash
./mvnw test
```

---

## Configuration & properties 🔧

- Development properties live in `src/main/resources/application.properties`
- To enable debug auto-configuration reports, start the app with `--debug` or set `logging.level.org.springframework=DEBUG`.
- Use Spring profiles (`application-dev.properties`) for environment-specific configs.

---

## Troubleshooting & minor steps ⚠️

- "Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured." — Ensure:
  - `src/main/resources/application.properties` exists and has `spring.datasource.url` and credentials set.
  - The JDBC driver dependency (`mysql-connector-j`) is present in `pom.xml` (it is included with `<scope>runtime</scope>`).
  - If using MySQL, the server is running and reachable (check `systemctl status mysql` or `sudo service mysql status`).

- If you see "Failed to determine a suitable driver class": ensure the connector dependency exists and is on the runtime classpath.

- If `./mvnw` is not executable on Unix, make it executable:

```bash
chmod +x mvnw
```

- For quick local testing without MySQL, you can enable H2 (in-memory) by adding the H2 dependency and switching `application.properties` to the H2 settings (example commented in the codebase).

---

## Useful commands 📋

- Start: `./mvnw spring-boot:run`
- Package: `./mvnw package`
- Test: `./mvnw test`
- Run jar: `java -jar target/demo-*.jar`

---

If you'd like, I can also add a short `docker-compose.yml` to run MySQL locally for development, or add a `Makefile` with common commands. 💡

---

Happy coding! ✨
