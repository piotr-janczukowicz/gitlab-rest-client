package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

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
class GitLabProjectProjectWebhooksUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .url(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .name(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .description(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .pushEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .issuesEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .tagPushEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .noteEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .jobEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .pipelineEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .wikiPageEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .deploymentEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .featureFlagEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .releasesEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .milestoneEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .emojiEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .resourceAccessTokenEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceDeployTokenEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .resourceDeployTokenEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.resourceDeployTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .enableSslVerification(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .token(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .signingToken(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .pushEventsBranchFilter(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .customWebhookTemplate(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .branchFilterStrategy(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .duoFlowCallbackEnabled(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .urlVariables(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabProjectProjectWebhooksUpdatePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .customHeaders(null);

        final GitLabProjectProjectWebhooksUpdatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksUpdatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.jobEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.featureFlagEvents()).isEqualTo(true);
            softly.assertThat(value.releasesEvents()).isEqualTo(true);
            softly.assertThat(value.milestoneEvents()).isEqualTo(true);
            softly.assertThat(value.emojiEvents()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenEvents()).isEqualTo(true);
            softly.assertThat(value.resourceDeployTokenEvents()).isEqualTo(true);
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.signingToken()).isEqualTo("signing_token");
            softly.assertThat(value.pushEventsBranchFilter()).isEqualTo("push_events_branch_filter");
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("custom_webhook_template");
            softly.assertThat(value.branchFilterStrategy())
                    .isEqualTo(GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksUpdatePayload original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();

        final GitLabProjectProjectWebhooksUpdatePayload rebuilt =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabProjectProjectWebhooksUpdateUrlVariable> source =
                new ArrayList<>(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable()));
        final GitLabProjectProjectWebhooksUpdatePayload built =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .urlVariables(source)
                        .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabProjectProjectWebhooksUpdatePayload built =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();
        final List<GitLabProjectProjectWebhooksUpdateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabProjectProjectWebhooksUpdateCustomHeader> source =
                new ArrayList<>(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeader()));
        final GitLabProjectProjectWebhooksUpdatePayload built =
                GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload())
                        .customHeaders(source)
                        .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabProjectProjectWebhooksUpdatePayload built =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();
        final List<GitLabProjectProjectWebhooksUpdateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectProjectWebhooksUpdatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabProjectProjectWebhooksUpdatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "url",
                        "name",
                        "description",
                        "pushEvents",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "jobEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "deploymentEvents",
                        "featureFlagEvents",
                        "releasesEvents",
                        "milestoneEvents",
                        "emojiEvents",
                        "resourceAccessTokenEvents",
                        "resourceDeployTokenEvents",
                        "enableSslVerification",
                        "token",
                        "signingToken",
                        "pushEventsBranchFilter",
                        "customWebhookTemplate",
                        "branchFilterStrategy",
                        "vulnerabilityEvents",
                        "duoFlowCallbackEnabled",
                        "urlVariables",
                        "customHeaders");
    }
}
