package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraForgeInstallationUpdateInstallationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenInstanceUrlIsNullable() {
        final GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder builder =
                GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder.builder(
                                JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload())
                        .instanceUrl(null);

        final GitLabJiraForgeInstallationUpdateInstallationPayload built = builder.build();

        assertThat(built.instanceUrl()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenInstanceUrlIsTooLong() {
        final GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder builder =
                GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder.builder(
                                JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload())
                        .instanceUrl("x".repeat(1025));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenInstanceUrlHasTheMaximumLength() {
        final GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder builder =
                GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder.builder(
                                JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload())
                        .instanceUrl("x".repeat(1024));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraForgeInstallationUpdateInstallationPayload value =
                JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload();

        assertThat(value.instanceUrl()).isEqualTo("instance_url");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraForgeInstallationUpdateInstallationPayload original =
                JiraforgeinstallationCatalogFixtures.jiraForgeInstallationUpdateInstallationPayload();

        final GitLabJiraForgeInstallationUpdateInstallationPayload rebuilt =
                GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabJiraForgeInstallationUpdateInstallationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("instanceUrl");
    }
}
