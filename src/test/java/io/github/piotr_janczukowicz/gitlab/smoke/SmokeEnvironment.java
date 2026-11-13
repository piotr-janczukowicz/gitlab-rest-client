package io.github.piotr_janczukowicz.gitlab.smoke;

import static java.util.Objects.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.client.GitLabAuthenticationProviders;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClientConfiguration;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClients;
import java.net.URI;
import java.util.Map;
import org.junit.jupiter.api.Assumptions;

final class SmokeEnvironment {

    static final String TOKEN_VARIABLE = "SMOKE_GITLAB_TOKEN";
    static final String PROJECT_VARIABLE = "SMOKE_GITLAB_PROJECT";
    static final String URL_VARIABLE = "SMOKE_GITLAB_URL";

    private static final String DEFAULT_URL = "https://gitlab.com";
    private static final String USER_AGENT = "gitlab-api-smoke/1.0";
    private static final String RUN_ID = Long.toString(System.currentTimeMillis(), Character.MAX_RADIX);
    private static final SmokeEnvironment FROM_ENV = of(System.getenv());

    private final String token;
    private final String project;
    private final URI baseUri;
    private GitLabClient client;
    private GitLab gitLab;

    private SmokeEnvironment(final String token, final String project, final URI baseUri) {
        this.token = token;
        this.project = project;
        this.baseUri = baseUri;
    }

    static SmokeEnvironment fromEnv() {
        return FROM_ENV;
    }

    static SmokeEnvironment of(final Map<String, String> env) {
        requireNonNull(env, "env");
        final String project = env.getOrDefault(PROJECT_VARIABLE, "").strip();
        final URI baseUri =
                URI.create(env.getOrDefault(URL_VARIABLE, DEFAULT_URL).strip());
        return new SmokeEnvironment(env.getOrDefault(TOKEN_VARIABLE, "").strip(), project, baseUri);
    }

    boolean configured() {
        return !token.isBlank() && !project.isBlank();
    }

    String project() {
        return project;
    }

    String runId() {
        return RUN_ID;
    }

    String name(final String suffix) {
        return "smoke-" + RUN_ID + "-" + suffix;
    }

    void requireConfigured() {
        Assumptions.assumeTrue(configured(), TOKEN_VARIABLE + " and " + PROJECT_VARIABLE + " are not set");
        SandboxGuard.requireSandbox(this);
    }

    synchronized GitLabClient client() {
        if (client == null) {
            client = GitLabClients.create(
                    GitLabAuthenticationProviders.personalToken(token),
                    USER_AGENT,
                    GitLabClientConfiguration.builder().baseUri(baseUri).build());
        }
        return client;
    }

    synchronized GitLab gitLab() {
        if (gitLab == null) {
            gitLab = GitLab.of(client());
        }
        return gitLab;
    }

    GitLabCaller caller() {
        return GitLabCaller.of(client());
    }

    @Override
    public String toString() {
        return "SmokeEnvironment[" + baseUri + " " + project + ", run " + RUN_ID + "]";
    }
}
