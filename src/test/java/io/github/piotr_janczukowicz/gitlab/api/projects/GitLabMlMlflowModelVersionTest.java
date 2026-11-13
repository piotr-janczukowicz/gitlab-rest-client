package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowModelVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .name(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .version(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreationTimestampIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .creationTimestamp(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.creationTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdatedTimestampIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .lastUpdatedTimestamp(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.lastUpdatedTimestamp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .userId(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentStageIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .currentStage(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.currentStage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .description(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .source(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunIdIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .runId(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.runId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .status(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusMessageIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .statusMessage(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.statusMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .tags(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunLinkIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .runLink(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.runLink()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAliasesIsNullable() {
        final GitLabMlMlflowModelVersionBuilder builder = GitLabMlMlflowModelVersionBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowModelVersion())
                .aliases(null);

        final GitLabMlMlflowModelVersion built = builder.build();

        assertThat(built.aliases()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowModelVersion value = ProjectsCatalogFixtures.mlMlflowModelVersion();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.creationTimestamp()).isEqualTo(1);
            softly.assertThat(value.lastUpdatedTimestamp()).isEqualTo(1);
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.currentStage()).isEqualTo("development");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.source()).isEqualTo("source");
            softly.assertThat(value.runId()).isEqualTo("run_id");
            softly.assertThat(value.status()).isEqualTo("READY");
            softly.assertThat(value.statusMessage()).isEqualTo("status_message");
            softly.assertThat(value.tags()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()));
            softly.assertThat(value.runLink()).isEqualTo("run_link");
            softly.assertThat(value.aliases()).isEqualTo(List.of("aliases"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowModelVersion original = ProjectsCatalogFixtures.mlMlflowModelVersion();

        final GitLabMlMlflowModelVersion rebuilt =
                GitLabMlMlflowModelVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowModelVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "version",
                        "creationTimestamp",
                        "lastUpdatedTimestamp",
                        "userId",
                        "currentStage",
                        "description",
                        "source",
                        "runId",
                        "status",
                        "statusMessage",
                        "tags",
                        "runLink",
                        "aliases");
    }
}
