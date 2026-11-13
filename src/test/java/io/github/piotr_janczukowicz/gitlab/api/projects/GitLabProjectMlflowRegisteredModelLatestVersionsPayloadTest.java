package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMlflowRegisteredModelLatestVersionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectMlflowRegisteredModelLatestVersionsPayloadBuilder builder =
                GitLabProjectMlflowRegisteredModelLatestVersionsPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload())
                        .name(null);

        final GitLabProjectMlflowRegisteredModelLatestVersionsPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMlflowRegisteredModelLatestVersionsPayload value =
                ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMlflowRegisteredModelLatestVersionsPayload original =
                ProjectsCatalogFixtures.projectMlflowRegisteredModelLatestVersionsPayload();

        final GitLabProjectMlflowRegisteredModelLatestVersionsPayload rebuilt =
                GitLabProjectMlflowRegisteredModelLatestVersionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMlflowRegisteredModelLatestVersionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
