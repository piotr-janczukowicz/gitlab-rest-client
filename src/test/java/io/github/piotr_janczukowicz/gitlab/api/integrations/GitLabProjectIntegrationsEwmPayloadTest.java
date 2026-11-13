package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsEwmPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsEwmPayloadBuilder builder = GitLabProjectIntegrationsEwmPayloadBuilder.builder(
                        IntegrationsCatalogFixtures.projectIntegrationsEwmPayload())
                .projectUrl(null);

        final GitLabProjectIntegrationsEwmPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsEwmPayloadBuilder builder = GitLabProjectIntegrationsEwmPayloadBuilder.builder(
                        IntegrationsCatalogFixtures.projectIntegrationsEwmPayload())
                .issuesUrl(null);

        final GitLabProjectIntegrationsEwmPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsEwmPayloadBuilder builder = GitLabProjectIntegrationsEwmPayloadBuilder.builder(
                        IntegrationsCatalogFixtures.projectIntegrationsEwmPayload())
                .newIssueUrl(null);

        final GitLabProjectIntegrationsEwmPayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsEwmPayloadBuilder builder = GitLabProjectIntegrationsEwmPayloadBuilder.builder(
                        IntegrationsCatalogFixtures.projectIntegrationsEwmPayload())
                .pushEvents(null);

        final GitLabProjectIntegrationsEwmPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsEwmPayloadBuilder builder = GitLabProjectIntegrationsEwmPayloadBuilder.builder(
                        IntegrationsCatalogFixtures.projectIntegrationsEwmPayload())
                .useInheritedSettings(null);

        final GitLabProjectIntegrationsEwmPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsEwmPayload value = IntegrationsCatalogFixtures.projectIntegrationsEwmPayload();

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
        final GitLabProjectIntegrationsEwmPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsEwmPayload();

        final GitLabProjectIntegrationsEwmPayload rebuilt =
                GitLabProjectIntegrationsEwmPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsEwmPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
