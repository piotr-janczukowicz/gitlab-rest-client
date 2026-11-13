package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIntegrationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .id(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .title(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .slug(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .createdAt(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .updatedAt(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .active(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .commitEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.commitEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .pushEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .issuesEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncidentEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .incidentEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.incidentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .alertEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.alertEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .confidentialIssuesEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .mergeRequestsEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .tagPushEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeploymentEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .deploymentEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.deploymentEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .noteEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.noteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialNoteEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .confidentialNoteEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.confidentialNoteEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .pipelineEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .wikiPageEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.wikiPageEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .jobEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.jobEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommentOnEventEnabledIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .commentOnEventEnabled(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.commentOnEventEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInheritedIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .inherited(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.inherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityEventsIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .vulnerabilityEvents(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.vulnerabilityEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPropertiesIsNullable() {
        final GitLabIntegrationBuilder builder = GitLabIntegrationBuilder.builder(CommonCatalogFixtures.integration())
                .properties(null);

        final GitLabIntegration built = builder.build();

        assertThat(built.properties()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIntegration value = CommonCatalogFixtures.integration();

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
            softly.assertThat(value.properties()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIntegration original = CommonCatalogFixtures.integration();

        final GitLabIntegration rebuilt =
                GitLabIntegrationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIntegration.class.getRecordComponents())
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
                        "vulnerabilityEvents",
                        "properties");
    }
}
