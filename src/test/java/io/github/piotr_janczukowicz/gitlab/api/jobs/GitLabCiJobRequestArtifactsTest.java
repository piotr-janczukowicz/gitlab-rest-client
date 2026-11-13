package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestArtifactsTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .name(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUntrackedIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .untracked(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.untracked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathsIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .paths(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.paths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .exclude(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.exclude()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhenIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .when(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.when()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpireInIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .expireIn(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.expireIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactTypeIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .artifactType(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.artifactType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactFormatIsNullable() {
        final GitLabCiJobRequestArtifactsBuilder builder = GitLabCiJobRequestArtifactsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestArtifacts())
                .artifactFormat(null);

        final GitLabCiJobRequestArtifacts built = builder.build();

        assertThat(built.artifactFormat()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestArtifacts value = JobsCatalogFixtures.ciJobRequestArtifacts();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.untracked()).isEqualTo(true);
            softly.assertThat(value.paths()).isEqualTo(List.of("paths"));
            softly.assertThat(value.exclude()).isEqualTo(List.of("exclude"));
            softly.assertThat(value.when()).isEqualTo("when");
            softly.assertThat(value.expireIn()).isEqualTo("expire_in");
            softly.assertThat(value.artifactType()).isEqualTo("artifact_type");
            softly.assertThat(value.artifactFormat()).isEqualTo("artifact_format");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestArtifacts original = JobsCatalogFixtures.ciJobRequestArtifacts();

        final GitLabCiJobRequestArtifacts rebuilt =
                GitLabCiJobRequestArtifactsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestArtifacts.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "untracked", "paths", "exclude", "when", "expireIn", "artifactType", "artifactFormat");
    }
}
