package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsAddSpentTimePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabProjectMergeRequestsAddSpentTimePayloadBuilder builder =
                GitLabProjectMergeRequestsAddSpentTimePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload())
                        .duration(null);

        final GitLabProjectMergeRequestsAddSpentTimePayload built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsAddSpentTimePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload();

        assertThat(value.duration()).isEqualTo("duration");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsAddSpentTimePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsAddSpentTimePayload();

        final GitLabProjectMergeRequestsAddSpentTimePayload rebuilt =
                GitLabProjectMergeRequestsAddSpentTimePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsAddSpentTimePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("duration");
    }
}
