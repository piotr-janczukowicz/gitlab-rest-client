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
class GitLabGroupGroupWebhooksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .url(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .name(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .description(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .pushEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .pushEventsBranchFilter(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .issuesEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .noteEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .confidentialNoteEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .jobEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .projectEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .wikiPageEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .deploymentEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .featureFlagEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .releasesEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .milestoneEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .subgroupEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .emojiEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .resourceAccessTokenEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .memberEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.memberEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .vulnerabilityEvents(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .token(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .signingToken(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .customWebhookTemplate(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .branchFilterStrategy(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .duoFlowCallbackEnabled(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .urlVariables(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabGroupGroupWebhooksCreatePayloadBuilder builder =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                        .customHeaders(null);

        final GitLabGroupGroupWebhooksCreatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksCreatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("http://example.com/hook");
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
                    .isEqualTo(GitLabGroupGroupWebhooksCreateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksCreatePayload original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();

        final GitLabGroupGroupWebhooksCreatePayload rebuilt =
                GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabGroupGroupWebhooksCreateUrlVariable> source =
                new ArrayList<>(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable()));
        final GitLabGroupGroupWebhooksCreatePayload built = GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                .urlVariables(source)
                .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabGroupGroupWebhooksCreatePayload built =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();
        final List<GitLabGroupGroupWebhooksCreateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabGroupGroupWebhooksCreateCustomHeader> source =
                new ArrayList<>(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader()));
        final GitLabGroupGroupWebhooksCreatePayload built = GitLabGroupGroupWebhooksCreatePayloadBuilder.builder(
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload())
                .customHeaders(source)
                .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabGroupGroupWebhooksCreatePayload built =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();
        final List<GitLabGroupGroupWebhooksCreateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupWebhooksCreatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabGroupGroupWebhooksCreatePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksCreatePayload.class.getRecordComponents())
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
