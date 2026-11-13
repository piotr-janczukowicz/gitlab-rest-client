package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIidIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload())
                        .mergeRequestIid(null);

        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload built = builder.build();

        assertThat(built.mergeRequestIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewOutputIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload())
                        .reviewOutput(null);

        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload built = builder.build();

        assertThat(built.reviewOutput()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload())
                        .workflowId(null);

        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload built = builder.build();

        assertThat(built.workflowId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("project_id");
            softly.assertThat(value.mergeRequestIid()).isEqualTo(1L);
            softly.assertThat(value.reviewOutput()).isEqualTo("review_output");
            softly.assertThat(value.workflowId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateCodeReviewAddCommentPayload();

        final GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateCodeReviewAddCommentPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectId", "mergeRequestIid", "reviewOutput", "workflowId");
    }
}
