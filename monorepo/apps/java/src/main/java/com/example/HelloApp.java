package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.net.InetSocketAddress;
import java.io.IOException;
import java.io.OutputStream;

public class HelloApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/api", new ApiHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }

    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String resp = "Hello World";
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            byte[] bytes = resp.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    static class ApiHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String resp = "ok";
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");
            byte[] bytes = resp.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }
}
