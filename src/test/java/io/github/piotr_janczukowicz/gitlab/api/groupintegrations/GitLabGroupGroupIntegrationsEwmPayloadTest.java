package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsEwmPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsEwmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsEwmPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabGroupGroupIntegrationsEwmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload())
                        .issuesUrl(null);

        final GitLabGroupGroupIntegrationsEwmPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabGroupGroupIntegrationsEwmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload())
                        .newIssueUrl(null);

        final GitLabGroupGroupIntegrationsEwmPayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsEwmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsEwmPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsEwmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsEwmPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsEwmPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload();

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
        final GitLabGroupGroupIntegrationsEwmPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEwmPayload();

        final GitLabGroupGroupIntegrationsEwmPayload rebuilt =
                GitLabGroupGroupIntegrationsEwmPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsEwmPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
