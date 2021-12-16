import io.opentelemetry.extension.annotations.WithSpan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionTest {
    //VM args
    //-javaagent:"/opentelemetry-javaagent-9.jar"
    //-Dotel.resource.attributes=service.name="otel-er-3"
    //-Dotel.exporter.otlp.endpoint=http://localhost:8200
    //-Dotel.javaagent.debug=true

    public static void main(String[] args) {
        testSpan();
    }

    @WithSpan("Span test")
    private static void testSpan() {
        ResponseEntity<Void> response = WebClient.create("http://localhost:8090")
                .get()
                .retrieve()
                .toBodilessEntity()
                .block();

        System.out.println(response.getStatusCode());
    }

}
