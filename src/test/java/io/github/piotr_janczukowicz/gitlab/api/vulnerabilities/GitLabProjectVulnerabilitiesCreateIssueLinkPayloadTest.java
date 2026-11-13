package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectVulnerabilitiesCreateIssueLinkPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetIssueIidIsNullable() {
        final GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder builder =
                GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload())
                        .targetIssueIid(null);

        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload built = builder.build();

        assertThat(built.targetIssueIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder builder =
                GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload())
                        .targetProjectId(null);

        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder builder =
                GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload())
                        .linkType(null);

        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload value =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.targetIssueIid()).isEqualTo(1L);
            softly.assertThat(value.targetProjectId()).isEqualTo("target_project_id");
            softly.assertThat(value.linkType()).isEqualTo("link_type");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload original =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesCreateIssueLinkPayload();

        final GitLabProjectVulnerabilitiesCreateIssueLinkPayload rebuilt =
                GitLabProjectVulnerabilitiesCreateIssueLinkPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectVulnerabilitiesCreateIssueLinkPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetIssueIid", "targetProjectId", "linkType");
    }
}
