package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsCreatePipelinePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAsyncValueIsNullable() {
        final GitLabProjectMergeRequestsCreatePipelinePayloadBuilder builder =
                GitLabProjectMergeRequestsCreatePipelinePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload())
                        .asyncValue(null);

        final GitLabProjectMergeRequestsCreatePipelinePayload built = builder.build();

        assertThat(built.asyncValue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsCreatePipelinePayload value =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload();

        assertThat(value.asyncValue()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsCreatePipelinePayload original =
                MergerequestsCatalogFixtures.projectMergeRequestsCreatePipelinePayload();

        final GitLabProjectMergeRequestsCreatePipelinePayload rebuilt =
                GitLabProjectMergeRequestsCreatePipelinePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestsCreatePipelinePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("asyncValue");
    }
}
