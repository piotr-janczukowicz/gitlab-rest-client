package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBugzillaServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaServicePayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsBugzillaServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaServicePayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsBugzillaServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsBugzillaServicePayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsBugzillaServicePayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBugzillaServicePayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBugzillaServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBugzillaServicePayloadBuilder builder =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBugzillaServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBugzillaServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload();

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
        final GitLabProjectIntegrationsBugzillaServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBugzillaServicePayload();

        final GitLabProjectIntegrationsBugzillaServicePayload rebuilt =
                GitLabProjectIntegrationsBugzillaServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsBugzillaServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
