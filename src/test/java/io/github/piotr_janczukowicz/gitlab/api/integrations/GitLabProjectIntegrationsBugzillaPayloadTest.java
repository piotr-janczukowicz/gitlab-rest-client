package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBugzillaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaPayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaPayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaPayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBugzillaPayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBugzillaPayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBugzillaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBugzillaPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.newIssueUrl()).isEqualTo("new_issue_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsBugzillaPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBugzillaPayload();

        final GitLabProjectIntegrationsBugzillaPayload rebuilt =
                GitLabProjectIntegrationsBugzillaPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsBugzillaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
