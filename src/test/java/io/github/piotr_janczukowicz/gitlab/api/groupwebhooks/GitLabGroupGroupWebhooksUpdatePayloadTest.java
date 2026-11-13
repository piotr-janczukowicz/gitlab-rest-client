package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

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
class GitLabGroupGroupWebhooksUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .url(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .name(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .description(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .pushEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .pushEventsBranchFilter(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .issuesEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .noteEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .jobEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .projectEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .featureFlagEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .releasesEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .milestoneEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .subgroupEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .emojiEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .resourceAccessTokenEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .memberEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.memberEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .token(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .signingToken(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .customWebhookTemplate(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .branchFilterStrategy(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .duoFlowCallbackEnabled(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .urlVariables(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabGroupGroupWebhooksUpdatePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                        .customHeaders(null);

        final GitLabGroupGroupWebhooksUpdatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksUpdatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.pushEventsBranchFilter()).isEqualTo("push_events_branch_filter");
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.jobEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.projectEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.featureFlagEvents()).isEqualTo(true);
            softly.assertThat(value.releasesEvents()).isEqualTo(true);
            softly.assertThat(value.milestoneEvents()).isEqualTo(true);
            softly.assertThat(value.subgroupEvents()).isEqualTo(true);
            softly.assertThat(value.emojiEvents()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenEvents()).isEqualTo(true);
            softly.assertThat(value.memberEvents()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.signingToken()).isEqualTo("signing_token");
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("custom_webhook_template");
            softly.assertThat(value.branchFilterStrategy())
                    .isEqualTo(GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksUpdatePayload original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();

        final GitLabGroupGroupWebhooksUpdatePayload rebuilt =
                GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabGroupGroupWebhooksUpdateUrlVariable> source =
                new ArrayList<>(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable()));
        final GitLabGroupGroupWebhooksUpdatePayload built = GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                .urlVariables(source)
                .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabGroupGroupWebhooksUpdatePayload built =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();
        final List<GitLabGroupGroupWebhooksUpdateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabGroupGroupWebhooksUpdateCustomHeader> source =
                new ArrayList<>(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeader()));
        final GitLabGroupGroupWebhooksUpdatePayload built = GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder(
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload())
                .customHeaders(source)
                .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabGroupGroupWebhooksUpdatePayload built =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();
        final List<GitLabGroupGroupWebhooksUpdateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupWebhooksUpdatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabGroupGroupWebhooksUpdatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "url",
                        "name",
                        "description",
                        "pushEvents",
                        "pushEventsBranchFilter",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "jobEvents",
                        "pipelineEvents",
                        "projectEvents",
                        "wikiPageEvents",
                        "deploymentEvents",
                        "featureFlagEvents",
                        "releasesEvents",
                        "milestoneEvents",
                        "subgroupEvents",
                        "emojiEvents",
                        "resourceAccessTokenEvents",
                        "memberEvents",
                        "vulnerabilityEvents",
                        "enableSslVerification",
                        "token",
                        "signingToken",
                        "customWebhookTemplate",
                        "branchFilterStrategy",
                        "duoFlowCallbackEnabled",
                        "urlVariables",
                        "customHeaders");
    }
}
