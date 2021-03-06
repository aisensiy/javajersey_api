package specs.example;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

@RunWith(ConcordionRunner.class)
@Ignore
public class ConcordionBaseTest {
    Client client;
    String cookie;

    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
    }

    public String getUrl(String path) {
        String entryPoint = System.getenv("ENTRYPOINT") != null ?
                System.getenv("ENTRYPOINT") : "http://localhost:8088";
        return entryPoint + path;
    }

    public Response get(String uri, String cookie){
        return client.target(getUrl(uri))
                .request()
                .header("Cookie", cookie)
                .get();
    }

    public Response post(String uri, String cookie, Form form) {
        return client.target(getUrl(uri))
                .request()
                .header("Cookie", cookie)
                .post(Entity.form(form));
    }

    public Response delete(String uri, String cookie) {
        return client.target(getUrl(uri)).request().header("Cookie", cookie).delete();
    }
}
