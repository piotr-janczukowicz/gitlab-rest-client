package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImportRepositoryFromGitHubCreateGistPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPersonalAccessTokenIsNullable() {
        final GitLabImportRepositoryFromGitHubCreateGistPayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCreateGistPayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload())
                        .personalAccessToken(null);

        final GitLabImportRepositoryFromGitHubCreateGistPayload built = builder.build();

        assertThat(built.personalAccessToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImportRepositoryFromGitHubCreateGistPayload value =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload();

        assertThat(value.personalAccessToken()).isEqualTo("personal_access_token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImportRepositoryFromGitHubCreateGistPayload original =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload();

        final GitLabImportRepositoryFromGitHubCreateGistPayload rebuilt =
                GitLabImportRepositoryFromGitHubCreateGistPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPersonalAccessTokenIsACredential() {
        final GitLabImportRepositoryFromGitHubCreateGistPayload value =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCreateGistPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabImportRepositoryFromGitHubCreateGistPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("personalAccessToken");
    }
}
