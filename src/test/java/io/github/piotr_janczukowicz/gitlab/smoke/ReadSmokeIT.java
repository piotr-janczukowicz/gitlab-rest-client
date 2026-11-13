package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.api.branches.GitLabBranch;
import io.github.piotr_janczukowicz.gitlab.api.projects.GitLabProjectWithAccessAndCatalog;
import io.github.piotr_janczukowicz.gitlab.client.GitLabAuthenticationProviders;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClientConfiguration;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClients;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabUnauthorizedException;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class ReadSmokeIT {

    private static final SmokeEnvironment ENV = SmokeEnvironment.fromEnv();
    private static final String BASE_URI_VARIABLE = SmokeEnvironment.URL_VARIABLE;

    @BeforeAll
    static void requireToken() {
        ENV.requireConfigured();
    }

    @Test
    void list_shouldContainTheDefaultBranch_whenReadingTheSandbox() throws IOException {
        final GitLab gitLab = ENV.gitLab();
        final String defaultBranch = gitLab.projects()
                .project()
                .get(ENV.project())
                .map(GitLabProjectWithAccessAndCatalog::defaultBranch)
                .orElseThrow();

        final List<GitLabBranch> branches =
                gitLab.branches().list(ENV.project()).all();

        assertThat(branches).extracting(GitLabBranch::name).contains(defaultBranch);
    }

    @Test
    void get_shouldBeEmpty_whenTheProjectDoesNotExist() throws IOException {
        final String missing = "smoke-" + ENV.runId() + "/does-not-exist";

        final Optional<GitLabProjectWithAccessAndCatalog> project =
                ENV.gitLab().projects().project().get(missing);

        assertThat(project).isEmpty();
    }

    @Test
    void get_shouldBeEmpty_whenTheBranchDoesNotExist() throws IOException {
        final Optional<GitLabBranch> branch = ENV.gitLab().branches().get(ENV.project(), ENV.name("absent"));

        assertThat(branch).isEmpty();
    }

    @Test
    void getUser_shouldRaiseUnauthorized_whenTheTokenIsInvalid() throws IOException {
        final String baseUri = System.getenv().getOrDefault(BASE_URI_VARIABLE, "https://gitlab.com");
        try (GitLabClient invalid = GitLabClients.create(
                GitLabAuthenticationProviders.personalToken("glpat-invalid-smoke-token"),
                "gitlab-api-smoke/1.0",
                GitLabClientConfiguration.builder().baseUri(URI.create(baseUri)).build())) {
            final GitLab gitLab = GitLab.of(invalid);

            final Throwable thrown = catchThrowable(() -> gitLab.users().getUser());

            assertThat(thrown).isInstanceOf(GitLabUnauthorizedException.class);
        }
    }
}
