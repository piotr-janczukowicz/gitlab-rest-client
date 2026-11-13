package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

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
class GitLabGroupHookTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .id(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .url(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .name(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .description(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .createdAt(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .pushEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .tagPushEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .mergeRequestsEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUpdateEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .repositoryUpdateEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.repositoryUpdateEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .enableSslVerification(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .organizationId(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertStatusIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .alertStatus(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.alertStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledUntilIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .disabledUntil(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.disabledUntil()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .urlVariables(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .pushEventsBranchFilter(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .branchFilterStrategy(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .customWebhookTemplate(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .customHeaders(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenPresentIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .tokenPresent(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.tokenPresent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenPresentIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .signingTokenPresent(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.signingTokenPresent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .groupId(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .issuesEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .confidentialIssuesEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .noteEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .confidentialNoteEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .pipelineEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .wikiPageEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .jobEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .deploymentEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .featureFlagEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.featureFlagEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .releasesEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.releasesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .milestoneEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.milestoneEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .subgroupEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.subgroupEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmojiEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .emojiEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.emojiEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .resourceAccessTokenEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.resourceAccessTokenEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .memberEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.memberEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .vulnerabilityEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectEventsIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .projectEvents(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.projectEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFlowCallbackEnabledIsNullable() {
        final GitLabGroupHookBuilder builder = GitLabGroupHookBuilder.builder(GroupwebhooksCatalogFixtures.groupHook())
                .duoFlowCallbackEnabled(null);

        final GitLabGroupHook built = builder.build();

        assertThat(built.duoFlowCallbackEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupHook value = GroupwebhooksCatalogFixtures.groupHook();

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
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.jobEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.featureFlagEvents()).isEqualTo(true);
            softly.assertThat(value.releasesEvents()).isEqualTo(true);
            softly.assertThat(value.milestoneEvents()).isEqualTo(true);
            softly.assertThat(value.subgroupEvents()).isEqualTo(true);
            softly.assertThat(value.emojiEvents()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenEvents()).isEqualTo(true);
            softly.assertThat(value.memberEvents()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
            softly.assertThat(value.projectEvents()).isEqualTo(true);
            softly.assertThat(value.duoFlowCallbackEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupHook original = GroupwebhooksCatalogFixtures.groupHook();

        final GitLabGroupHook rebuilt = GitLabGroupHookBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupHook.class.getRecordComponents())
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
                        "groupId",
                        "issuesEvents",
                        "confidentialIssuesEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "jobEvents",
                        "deploymentEvents",
                        "featureFlagEvents",
                        "releasesEvents",
                        "milestoneEvents",
                        "subgroupEvents",
                        "emojiEvents",
                        "resourceAccessTokenEvents",
                        "memberEvents",
                        "vulnerabilityEvents",
                        "projectEvents",
                        "duoFlowCallbackEnabled");
    }
}
