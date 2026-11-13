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
class GitLabProjectProjectWebhooksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .url(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .name(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .description(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .pushEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .issuesEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .confidentialIssuesEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .tagPushEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .noteEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .confidentialNoteEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .jobEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .pipelineEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .wikiPageEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .deploymentEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .featureFlagEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .releasesEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .milestoneEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .emojiEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .resourceAccessTokenEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceDeployTokenEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .resourceDeployTokenEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.resourceDeployTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .enableSslVerification(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .token(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .signingToken(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .pushEventsBranchFilter(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .customWebhookTemplate(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .branchFilterStrategy(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .vulnerabilityEvents(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .duoFlowCallbackEnabled(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .urlVariables(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabProjectProjectWebhooksCreatePayloadBuilder builder =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .customHeaders(null);

        final GitLabProjectProjectWebhooksCreatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksCreatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("http://example.com/hook");
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
                    .isEqualTo(GitLabProjectProjectWebhooksCreateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksCreatePayload original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();

        final GitLabProjectProjectWebhooksCreatePayload rebuilt =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabProjectProjectWebhooksCreateUrlVariable> source =
                new ArrayList<>(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable()));
        final GitLabProjectProjectWebhooksCreatePayload built =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .urlVariables(source)
                        .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabProjectProjectWebhooksCreatePayload built =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();
        final List<GitLabProjectProjectWebhooksCreateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabProjectProjectWebhooksCreateCustomHeader> source =
                new ArrayList<>(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader()));
        final GitLabProjectProjectWebhooksCreatePayload built =
                GitLabProjectProjectWebhooksCreatePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload())
                        .customHeaders(source)
                        .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabProjectProjectWebhooksCreatePayload built =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();
        final List<GitLabProjectProjectWebhooksCreateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectProjectWebhooksCreatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabProjectProjectWebhooksCreatePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksCreatePayload.class.getRecordComponents())
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
