package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserPublic;
import io.github.piotr_janczukowicz.gitlab.api.metadata.GitLabMetadata;
import io.github.piotr_janczukowicz.gitlab.api.projects.GitLabProjectWithAccessAndCatalog;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class PingSmokeIT {

    private static final SmokeEnvironment ENV = SmokeEnvironment.fromEnv();

    @BeforeAll
    static void requireToken() {
        ENV.requireConfigured();
    }

    @Test
    void getUser_shouldReturnAUsername_whenTokenIsValid() throws IOException {
        final GitLabUserPublic user = ENV.gitLab().users().getUser();

        assertThat(user.username()).isNotBlank();
    }

    @Test
    void getVersion_shouldReturnAVersion_whenReadingMetadata() throws IOException {
        final GitLabMetadata metadata = ENV.gitLab().metadata().getVersion();

        assertThat(metadata.version()).isNotBlank();
    }

    @Test
    void get_shouldReturnTheSandbox_whenTokenHasAccess() throws IOException {
        final Optional<GitLabProjectWithAccessAndCatalog> project =
                ENV.gitLab().projects().project().get(ENV.project());

        assertThat(project)
                .map(GitLabProjectWithAccessAndCatalog::pathWithNamespace)
                .hasValueSatisfying(path -> assertThat(path).isEqualToIgnoringCase(ENV.project()));
    }
}
