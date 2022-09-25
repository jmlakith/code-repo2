package examples;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        ExecutorService executors = Executors.newFixedThreadPool(3);
        System.out.println("Server started !");
        server.createContext("/ping", t -> {
            executors.submit(() -> {
                System.out.println("We are getting a request and response sent");
                String msg = "Ping";
                try {
                    t.sendResponseHeaders(200, msg.length());
                    OutputStream os = t.getResponseBody();
                    os.write(msg.getBytes(StandardCharsets.UTF_8));
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        server.createContext("/terminate", t -> {
            executors.submit(() -> {
                System.out.println("Server Shutdown initiated");
                server.stop(3);
                System.out.println("Server down");
                executors.shutdown();
                System.out.println("Executors down");
            });

        });
        server.setExecutor(null);
        server.start();

        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("Server Shutdown initiated");
            server.stop(3);

        }));

    }

}
