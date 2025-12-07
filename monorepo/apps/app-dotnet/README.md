# app-dotnet

Minimal .NET console "Hello World" application.

Build and run locally:

```bash
dotnet build AppDotnet.csproj -c Release
dotnet run --project AppDotnet.csproj
```

Build and run with Docker (requires Docker):

```bash
docker build -t app-dotnet:latest .
docker run --rm app-dotnet:latest
```
