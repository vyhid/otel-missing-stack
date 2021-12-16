import io.opentelemetry.extension.annotations.WithSpan;
import org.springframework.web.reactive.function.client.WebClient;

public class ExceptionTest {
    //VM args
    //-javaagent:"/opentelemetry-javaagent.jar"
    //-Dotel.resource.attributes=service.name="my-app"
    //-Dotel.javaagent.debug=true

    // Evn
    // OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:8200
    public static void main(String[] args) {
        testSpan();
    }

    @WithSpan("Span test")
    private static void testSpan() {
        Object block = WebClient.create("http://localhost:8090")
                .get()
                .exchange()
                .block();

        System.out.println(block);
    }

}
