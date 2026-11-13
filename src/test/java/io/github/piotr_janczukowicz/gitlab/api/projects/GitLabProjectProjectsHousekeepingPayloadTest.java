package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsHousekeepingPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTaskIsNullable() {
        final GitLabProjectProjectsHousekeepingPayloadBuilder builder =
                GitLabProjectProjectsHousekeepingPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsHousekeepingPayload())
                        .task(null);

        final GitLabProjectProjectsHousekeepingPayload built = builder.build();

        assertThat(built.task()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsHousekeepingPayload value =
                ProjectsCatalogFixtures.projectProjectsHousekeepingPayload();

        assertThat(value.task()).isEqualTo(GitLabProjectProjectsHousekeepingTask.EAGER);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsHousekeepingPayload original =
                ProjectsCatalogFixtures.projectProjectsHousekeepingPayload();

        final GitLabProjectProjectsHousekeepingPayload rebuilt =
                GitLabProjectProjectsHousekeepingPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsHousekeepingPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("task");
    }
}
