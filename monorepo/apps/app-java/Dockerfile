# Dockerfile para HelloApp Java
# Use Eclipse Temurin 17 (imagem oficial multi-arch, compatível com buildx)
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# Copy relative to the build context (apps/java), not the repository root
# when building with: `docker build ... apps/java`
COPY src/main/java/com/example/HelloApp.java ./
RUN mkdir -p /app/classes && \
    javac -d /app/classes HelloApp.java
CMD ["java", "-cp", "/app/classes", "com.example.HelloApp"]
