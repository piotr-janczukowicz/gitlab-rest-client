package io.github.piotr_janczukowicz.gitlab.test;

import static io.github.piotr_janczukowicz.http.HttpHeaderNames.CONTENT_TYPE;
import static io.github.piotr_janczukowicz.test.http.StubHttpServer.status;

import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClientConfiguration;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClients;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import java.nio.charset.StandardCharsets;

/** Clients and canned answers for the generated {@code *ApiIntegrationTest} classes, over a {@link StubHttpServer}. */
public final class GitLabApiStubSupport {

    private GitLabApiStubSupport() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * A client that talks to {@code server}.
     *
     * @param server the stub server
     * @return the client; close it when the test is done
     */
    public static GitLabClient client(final StubHttpServer server) {
        final GitLabClientConfiguration configuration =
                GitLabClientConfiguration.builder().baseUri(server.baseUri()).build();
        return GitLabClients.create(AuthenticationProviders.bearer("token"), "gitlab-test/1.0", configuration);
    }

    /**
     * A {@code 200} answer with a JSON body.
     *
     * @param body the JSON text
     * @return the answer
     */
    public static StubHttpServer.StubResponse okJson(final String body) {
        return status(200).header(CONTENT_TYPE, "application/json").body(body.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * A {@code 204} answer.
     *
     * @return the answer
     */
    public static StubHttpServer.StubResponse noContent() {
        return status(204);
    }

    /**
     * A {@code 404} answer.
     *
     * @return the answer
     */
    public static StubHttpServer.StubResponse notFound() {
        return status(404);
    }
}
