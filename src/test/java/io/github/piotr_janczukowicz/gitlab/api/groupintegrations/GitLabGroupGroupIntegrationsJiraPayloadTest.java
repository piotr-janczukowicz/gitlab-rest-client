package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

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
class GitLabGroupGroupIntegrationsJiraPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .url(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .apiUrl(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAuthTypeIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraAuthType(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraAuthType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .password(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssueRegexIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraIssueRegex(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraIssueRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssuePrefixIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraIssuePrefix(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraIssuePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraIssueTransitionIdIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraIssueTransitionId(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraIssueTransitionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .issuesEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectKeysIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .projectKeys(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.projectKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .vulnerabilitiesEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.vulnerabilitiesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesIssuetypeIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .vulnerabilitiesIssuetype(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.vulnerabilitiesIssuetype()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectKeyIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .projectKey(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.projectKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomizeJiraIssueEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .customizeJiraIssueEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.customizeJiraIssueEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCheckEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraCheckEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraExistsCheckEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraExistsCheckEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraExistsCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAssigneeCheckEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraAssigneeCheckEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraAssigneeCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraStatusCheckEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraStatusCheckEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraStatusCheckEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraAllowedStatusesAsStringIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .jiraAllowedStatusesAsString(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.jiraAllowedStatusesAsString()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentOnEventEnabledIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .commentOnEventEnabled(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.commentOnEventEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEventsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .commitEvents(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.commitEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsJiraPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsJiraPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload();

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
        final GitLabGroupGroupIntegrationsJiraPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload();

        final GitLabGroupGroupIntegrationsJiraPayload rebuilt =
                GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenProjectKeysSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("project_keys"));
        final GitLabGroupGroupIntegrationsJiraPayload built = GitLabGroupGroupIntegrationsJiraPayloadBuilder.builder(
                        GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload())
                .projectKeys(source)
                .build();
        source.clear();

        assertThat(built.projectKeys()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenProjectKeysIsRead() {
        final GitLabGroupGroupIntegrationsJiraPayload built =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload();
        final List<String> values = built.projectKeys();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabGroupGroupIntegrationsJiraPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsJiraPayload.class.getRecordComponents())
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
