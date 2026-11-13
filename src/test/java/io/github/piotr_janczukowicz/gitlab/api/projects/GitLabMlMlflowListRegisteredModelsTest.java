package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowListRegisteredModelsTest {

    @Test
    void constructor_shouldAcceptNull_whenRegisteredModelsIsNullable() {
        final GitLabMlMlflowListRegisteredModelsBuilder builder = GitLabMlMlflowListRegisteredModelsBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowListRegisteredModels())
                .registeredModels(null);

        final GitLabMlMlflowListRegisteredModels built = builder.build();

        assertThat(built.registeredModels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextPageTokenIsNullable() {
        final GitLabMlMlflowListRegisteredModelsBuilder builder = GitLabMlMlflowListRegisteredModelsBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowListRegisteredModels())
                .nextPageToken(null);

        final GitLabMlMlflowListRegisteredModels built = builder.build();

        assertThat(built.nextPageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowListRegisteredModels value = ProjectsCatalogFixtures.mlMlflowListRegisteredModels();

        assertSoftly(softly -> {
            softly.assertThat(value.registeredModels())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowRegisteredModel()));
            softly.assertThat(value.nextPageToken()).isEqualTo("next_page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowListRegisteredModels original = ProjectsCatalogFixtures.mlMlflowListRegisteredModels();

        final GitLabMlMlflowListRegisteredModels rebuilt =
                GitLabMlMlflowListRegisteredModelsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenNextPageTokenIsACredential() {
        final GitLabMlMlflowListRegisteredModels value = ProjectsCatalogFixtures.mlMlflowListRegisteredModels();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowListRegisteredModels.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("registeredModels", "nextPageToken");
    }
}
