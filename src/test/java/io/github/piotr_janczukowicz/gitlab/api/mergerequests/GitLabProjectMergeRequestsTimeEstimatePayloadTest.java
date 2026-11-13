package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsTimeEstimatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabProjectMergeRequestsTimeEstimatePayloadBuilder builder =
                GitLabProjectMergeRequestsTimeEstimatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload())
                        .duration(null);

        final GitLabProjectMergeRequestsTimeEstimatePayload built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsTimeEstimatePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload();

        assertThat(value.duration()).isEqualTo("3h30m");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsTimeEstimatePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsTimeEstimatePayload();

        final GitLabProjectMergeRequestsTimeEstimatePayload rebuilt =
                GitLabProjectMergeRequestsTimeEstimatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsTimeEstimatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("duration");
    }
}
