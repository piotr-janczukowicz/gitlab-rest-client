package io.github.piotr_janczukowicz.gitlab.api.integrations;

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
class GitLabProjectIntegrationsJiraServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .url(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAuthTypeIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraAuthType(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraAuthType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .password(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssueRegexIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraIssueRegex(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraIssueRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssuePrefixIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraIssuePrefix(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraIssuePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssueTransitionIdIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraIssueTransitionId(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraIssueTransitionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .issuesEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectKeysIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .projectKeys(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.projectKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .vulnerabilitiesEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.vulnerabilitiesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesIssuetypeIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .vulnerabilitiesIssuetype(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.vulnerabilitiesIssuetype()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectKeyIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .projectKey(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.projectKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomizeJiraIssueEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .customizeJiraIssueEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.customizeJiraIssueEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCheckEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraCheckEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraExistsCheckEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraExistsCheckEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraExistsCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAssigneeCheckEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraAssigneeCheckEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraAssigneeCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraStatusCheckEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraStatusCheckEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraStatusCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAllowedStatusesAsStringIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .jiraAllowedStatusesAsString(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.jiraAllowedStatusesAsString()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentOnEventEnabledIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .commentOnEventEnabled(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.commentOnEventEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEventsIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .commitEvents(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.commitEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsJiraServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsJiraServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsJiraServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.jiraAuthType()).isEqualTo(1);
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.jiraIssueRegex()).isEqualTo("jira_issue_regex");
            softly.assertThat(value.jiraIssuePrefix()).isEqualTo("jira_issue_prefix");
            softly.assertThat(value.jiraIssueTransitionId()).isEqualTo("jira_issue_transition_id");
            softly.assertThat(value.issuesEnabled()).isEqualTo("issues_enabled");
            softly.assertThat(value.projectKeys()).isEqualTo(List.of("project_keys"));
            softly.assertThat(value.vulnerabilitiesEnabled()).isEqualTo(true);
            softly.assertThat(value.vulnerabilitiesIssuetype()).isEqualTo("vulnerabilities_issuetype");
            softly.assertThat(value.projectKey()).isEqualTo("project_key");
            softly.assertThat(value.customizeJiraIssueEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraCheckEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraExistsCheckEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraAssigneeCheckEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraStatusCheckEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraAllowedStatusesAsString()).isEqualTo("jira_allowed_statuses_as_string");
            softly.assertThat(value.commentOnEventEnabled()).isEqualTo(true);
            softly.assertThat(value.commitEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsJiraServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload();

        final GitLabProjectIntegrationsJiraServicePayload rebuilt =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenProjectKeysSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("project_keys"));
        final GitLabProjectIntegrationsJiraServicePayload built =
                GitLabProjectIntegrationsJiraServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload())
                        .projectKeys(source)
                        .build();
        source.clear();

        assertThat(built.projectKeys()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProjectKeysIsRead() {
        final GitLabProjectIntegrationsJiraServicePayload built =
                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload();
        final List<String> values = built.projectKeys();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsJiraServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsJiraServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsJiraServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "url",
                        "apiUrl",
                        "jiraAuthType",
                        "username",
                        "password",
                        "jiraIssueRegex",
                        "jiraIssuePrefix",
                        "jiraIssueTransitionId",
                        "issuesEnabled",
                        "projectKeys",
                        "vulnerabilitiesEnabled",
                        "vulnerabilitiesIssuetype",
                        "projectKey",
                        "customizeJiraIssueEnabled",
                        "jiraCheckEnabled",
                        "jiraExistsCheckEnabled",
                        "jiraAssigneeCheckEnabled",
                        "jiraStatusCheckEnabled",
                        "jiraAllowedStatusesAsString",
                        "commentOnEventEnabled",
                        "commitEvents",
                        "mergeRequestsEvents",
                        "useInheritedSettings");
    }
}
