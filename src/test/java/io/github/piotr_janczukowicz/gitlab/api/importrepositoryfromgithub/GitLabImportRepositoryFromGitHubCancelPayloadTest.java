package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabImportRepositoryFromGitHubCancelPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabImportRepositoryFromGitHubCancelPayloadBuilder builder =
                GitLabImportRepositoryFromGitHubCancelPayloadBuilder.builder(
                                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload())
                        .projectId(null);

        final GitLabImportRepositoryFromGitHubCancelPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabImportRepositoryFromGitHubCancelPayload value =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload();

        assertThat(value.projectId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabImportRepositoryFromGitHubCancelPayload original =
                ImportrepositoryfromgithubCatalogFixtures.importRepositoryFromGitHubCancelPayload();

        final GitLabImportRepositoryFromGitHubCancelPayload rebuilt =
                GitLabImportRepositoryFromGitHubCancelPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabImportRepositoryFromGitHubCancelPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectId");
    }
}
