# Multi-stage build for a small .NET console app image
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

# Copy csproj and restore dependencies
COPY ["AppDotnet.csproj", "./"]
RUN dotnet restore "./AppDotnet.csproj"

# Copy everything else and publish
COPY . .
RUN dotnet publish "AppDotnet.csproj" -c Release -o /app/publish --no-restore

# Runtime image
FROM mcr.microsoft.com/dotnet/runtime:8.0
WORKDIR /app
COPY --from=build /app/publish .
ENTRYPOINT ["dotnet", "AppDotnet.dll"]
