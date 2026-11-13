package io.github.piotr_janczukowicz.gitlab.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClientConfiguration;
import io.github.piotr_janczukowicz.gitlab.client.GitLabFlavor;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.internal.ClientStacks;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.jspecify.annotations.Nullable;
import org.mockito.ArgumentCaptor;

/**
 * Callers over a mocked {@link HttpTransport} for the generated {@code *ApiTest} classes. The client is a self-managed
 * one at {@code https://gitlab.example.test}, so a tier can be set; the transport stack has no retry.
 */
public final class GitLabApiTestClients {

    /** The root of the GitLab instance that the callers talk to. */
    public static final URI BASE = URI.create("https://gitlab.example.test");

    private GitLabApiTestClients() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * A caller over {@code transport} with no tier configured, so no tier guard refuses.
     *
     * @param transport the transport that answers
     * @return the caller
     */
    public static GitLabCaller caller(final HttpTransport transport) {
        return caller(transport, null);
    }

    /**
     * A caller over {@code transport} configured for {@code tier}.
     *
     * @param transport the transport that answers
     * @param tier the tier of the instance, or {@code null} for none
     * @return the caller
     */
    public static GitLabCaller caller(final HttpTransport transport, final @Nullable GitLabTier tier) {
        final GitLabClientConfiguration configuration = GitLabClientConfiguration.builder()
                .baseUri(BASE)
                .flavor(GitLabFlavor.SELF_MANAGED)
                .tier(tier)
                .build();
        final GitLabClient client = ClientStacks.assemble(
                        transport,
                        AuthenticationProviders.bearer("token"),
                        "gitlab-test/1.0",
                        configuration,
                        (stack, retry) -> stack)
                .build();
        return GitLabCaller.of(client);
    }

    /**
     * The one request that the transport received.
     *
     * @param transport the mocked transport
     * @return the request
     * @throws IOException never; the signature follows {@code HttpTransport.execute}
     */
    public static HttpRequest singleRequest(final HttpTransport transport) throws IOException {
        final ArgumentCaptor<HttpRequest> captor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(transport).execute(captor.capture());
        return captor.getValue();
    }

    /**
     * The method and the encoded path of a request, for example {@code GET /api/v4/projects/group%2Fproject/issues}.
     *
     * @param request the request
     * @return the line
     */
    public static String line(final HttpRequest request) {
        return request.method() + " " + request.uri().getRawPath();
    }

    /**
     * The body of a request as text, or an empty text when it has none.
     *
     * @param request the request
     * @return the text
     */
    public static String bodyText(final HttpRequest request) {
        return request.mapBody(bytes -> new String(bytes, StandardCharsets.UTF_8), () -> "");
    }

    /**
     * Verifies that the transport was never asked to send anything.
     *
     * @param transport the mocked transport
     * @throws IOException never; the signature follows {@code HttpTransport.execute}
     */
    public static void verifyNoRequest(final HttpTransport transport) throws IOException {
        verify(transport, org.mockito.Mockito.never()).execute(any());
    }
}
