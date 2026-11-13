package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectVulnerabilitiesAiDetectionFlagPayloadTest {

    @Test
    void constructor_shouldRefuse_whenConfidenceScoreIsBelowTheMinimum() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .confidenceScore(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenConfidenceScoreIsTheMinimum() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .confidenceScore(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenConfidenceScoreIsAboveTheMaximum() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .confidenceScore(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenConfidenceScoreIsTheMaximum() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .confidenceScore(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .description(null);

        final GitLabProjectVulnerabilitiesAiDetectionFlagPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder builder =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload())
                        .origin(null);

        final GitLabProjectVulnerabilitiesAiDetectionFlagPayload built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayload value =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.confidenceScore()).isEqualTo(1);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.origin()).isEqualTo("origin");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectVulnerabilitiesAiDetectionFlagPayload original =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesAiDetectionFlagPayload();

        final GitLabProjectVulnerabilitiesAiDetectionFlagPayload rebuilt =
                GitLabProjectVulnerabilitiesAiDetectionFlagPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectVulnerabilitiesAiDetectionFlagPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("confidenceScore", "description", "origin");
    }
}
