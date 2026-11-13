package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .name(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNameIsTooLong() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .name("x".repeat(65));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNameHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .name("x".repeat(64));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .value(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenValueIsTooLong() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .value("x".repeat(257));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenValueHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .value("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEvidenceIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .evidence(null);

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim built = builder.build();

        assertThat(built.evidence()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenEvidenceIsTooLong() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .evidence("x".repeat(257));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenEvidenceHasTheMaximumLength() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim())
                        .evidence("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.evidence()).isEqualTo("evidence");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim();

        final GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim rebuilt =
                GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaimBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "value", "evidence");
    }
}
