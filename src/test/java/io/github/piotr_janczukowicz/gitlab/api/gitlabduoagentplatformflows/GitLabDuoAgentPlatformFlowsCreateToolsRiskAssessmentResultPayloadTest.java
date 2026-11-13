package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .projectId(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIidIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .mergeRequestIid(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.mergeRequestIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffShaIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .diffSha(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.diffSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowIdIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .workflowId(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.workflowId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClaimsIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .claims(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.claims()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSummaryIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .summary(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built = builder.build();

        assertThat(built.summary()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenSummaryIsTooLong() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .summary("x".repeat(2049));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenSummaryHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .summary("x".repeat(2048));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload value =
                GitlabduoagentplatformflowsCatalogFixtures
                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectId()).isEqualTo("project_id");
            softly.assertThat(value.mergeRequestIid()).isEqualTo(1L);
            softly.assertThat(value.diffSha()).isEqualTo("0123456789abcdef0123456789abcdef01234567");
            softly.assertThat(value.workflowId()).isEqualTo(1L);
            softly.assertThat(value.claims())
                    .isEqualTo(List.of(
                            GitlabduoagentplatformflowsCatalogFixtures
                                    .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim()));
            softly.assertThat(value.summary()).isEqualTo("summary");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload original =
                GitlabduoagentplatformflowsCatalogFixtures
                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload();

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenClaimsSourceChangesLater() {
        final List<GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim> source = new ArrayList<>(List.of(
                GitlabduoagentplatformflowsCatalogFixtures
                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim()));
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload())
                        .claims(source)
                        .build();
        source.clear();

        assertThat(built.claims()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenClaimsIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload built =
                GitlabduoagentplatformflowsCatalogFixtures
                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload();
        final List<GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim> values = built.claims();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectId", "mergeRequestIid", "diffSha", "workflowId", "claims", "summary");
    }
}
