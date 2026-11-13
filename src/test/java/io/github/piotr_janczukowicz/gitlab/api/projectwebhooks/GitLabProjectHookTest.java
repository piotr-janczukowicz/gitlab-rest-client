package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectHookTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .id(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .url(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .name(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .description(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .createdAt(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .pushEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .tagPushEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .mergeRequestsEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUpdateEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .repositoryUpdateEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.repositoryUpdateEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .enableSslVerification(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .organizationId(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertStatusIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .alertStatus(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.alertStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledUntilIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .disabledUntil(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.disabledUntil()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .urlVariables(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .pushEventsBranchFilter(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .branchFilterStrategy(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .customWebhookTemplate(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .customHeaders(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenPresentIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .tokenPresent(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.tokenPresent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenPresentIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .signingTokenPresent(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.signingTokenPresent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .projectId(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .issuesEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .confidentialIssuesEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .noteEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .confidentialNoteEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .pipelineEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .wikiPageEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .deploymentEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .featureFlagEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .jobEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .releasesEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .milestoneEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .emojiEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .resourceAccessTokenEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceDeployTokenEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .resourceDeployTokenEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.resourceDeployTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .vulnerabilityEvents(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabProjectHookBuilder builder = GitLabProjectHookBuilder.builder(
                        ProjectwebhooksCatalogFixtures.projectHook())
                .duoFlowCallbackEnabled(null);

        final GitLabProjectHook built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectHook value = ProjectwebhooksCatalogFixtures.projectHook();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.url()).isEqualTo("https://webhook.site");
            softly.assertThat(value.name()).isEqualTo("Hook name");
            softly.assertThat(value.description()).isEqualTo("Hook description");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.repositoryUpdateEvents()).isEqualTo(true);
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.organizationId()).isEqualTo(1L);
            softly.assertThat(value.alertStatus()).isEqualTo("executable");
            softly.assertThat(value.disabledUntil()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.urlVariables()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.pushEventsBranchFilter()).isEqualTo("my-branch-*");
            softly.assertThat(value.branchFilterStrategy()).isEqualTo("wildcard");
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("{\"event\":\"{{object_kind}}\"}");
            softly.assertThat(value.customHeaders()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.tokenPresent()).isEqualTo(true);
            softly.assertThat(value.signingTokenPresent()).isEqualTo(true);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.featureFlagEvents()).isEqualTo(true);
            softly.assertThat(value.jobEvents()).isEqualTo(true);
            softly.assertThat(value.releasesEvents()).isEqualTo(true);
            softly.assertThat(value.milestoneEvents()).isEqualTo(true);
            softly.assertThat(value.emojiEvents()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenEvents()).isEqualTo(true);
            softly.assertThat(value.resourceDeployTokenEvents()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectHook original = ProjectwebhooksCatalogFixtures.projectHook();

        final GitLabProjectHook rebuilt =
                GitLabProjectHookBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectHook.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "url",
                        "name",
                        "description",
                        "createdAt",
                        "pushEvents",
                        "tagPushEvents",
                        "mergeRequestsEvents",
                        "repositoryUpdateEvents",
                        "enableSslVerification",
                        "organizationId",
                        "alertStatus",
                        "disabledUntil",
                        "urlVariables",
                        "pushEventsBranchFilter",
                        "branchFilterStrategy",
                        "customWebhookTemplate",
                        "customHeaders",
                        "tokenPresent",
                        "signingTokenPresent",
                        "projectId",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "deploymentEvents",
                        "featureFlagEvents",
                        "jobEvents",
                        "releasesEvents",
                        "milestoneEvents",
                        "emojiEvents",
                        "resourceAccessTokenEvents",
                        "resourceDeployTokenEvents",
                        "vulnerabilityEvents",
                        "duoFlowCallbackEnabled");
    }
}
