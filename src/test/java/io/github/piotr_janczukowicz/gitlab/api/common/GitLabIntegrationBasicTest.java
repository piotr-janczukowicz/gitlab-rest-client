package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIntegrationBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .id(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .title(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .slug(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .createdAt(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .updatedAt(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .active(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .commitEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.commitEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .pushEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .issuesEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .incidentEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .alertEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .confidentialIssuesEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .mergeRequestsEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .tagPushEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .deploymentEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .noteEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .confidentialNoteEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .pipelineEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .wikiPageEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .jobEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentOnEventEnabledIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .commentOnEventEnabled(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.commentOnEventEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInheritedIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .inherited(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.inherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabIntegrationBasicBuilder builder = GitLabIntegrationBasicBuilder.builder(
                        CommonCatalogFixtures.integrationBasic())
                .vulnerabilityEvents(null);

        final GitLabIntegrationBasic built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIntegrationBasic value = CommonCatalogFixtures.integrationBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Jenkins CI");
            softly.assertThat(value.slug()).isEqualTo("jenkins");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.commitEvents()).isEqualTo(true);
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.incidentEvents()).isEqualTo(true);
            softly.assertThat(value.alertEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.deploymentEvents()).isEqualTo(true);
            softly.assertThat(value.noteEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialNoteEvents()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.wikiPageEvents()).isEqualTo(true);
            softly.assertThat(value.jobEvents()).isEqualTo(true);
            softly.assertThat(value.commentOnEventEnabled()).isEqualTo(true);
            softly.assertThat(value.inherited()).isEqualTo(true);
            softly.assertThat(value.vulnerabilityEvents()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIntegrationBasic original = CommonCatalogFixtures.integrationBasic();

        final GitLabIntegrationBasic rebuilt =
                GitLabIntegrationBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIntegrationBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "title",
                        "slug",
                        "createdAt",
                        "updatedAt",
                        "active",
                        "commitEvents",
                        "pushEvents",
                        "issuesEvents",
                        "incidentEvents",
                        "alertEvents",
                        "confidentialIssuesEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "deploymentEvents",
                        "noteEvents",
                        "confidentialNoteEvents",
                        "pipelineEvents",
                        "wikiPageEvents",
                        "jobEvents",
                        "commentOnEventEnabled",
                        "inherited",
                        "vulnerabilityEvents");
    }
}
