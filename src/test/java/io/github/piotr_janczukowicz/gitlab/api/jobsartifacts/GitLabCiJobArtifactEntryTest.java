package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobArtifactEntryTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobArtifactEntryBuilder builder = GitLabCiJobArtifactEntryBuilder.builder(
                        JobsartifactsCatalogFixtures.ciJobArtifactEntry())
                .name(null);

        final GitLabCiJobArtifactEntry built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabCiJobArtifactEntryBuilder builder = GitLabCiJobArtifactEntryBuilder.builder(
                        JobsartifactsCatalogFixtures.ciJobArtifactEntry())
                .path(null);

        final GitLabCiJobArtifactEntry built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabCiJobArtifactEntryBuilder builder = GitLabCiJobArtifactEntryBuilder.builder(
                        JobsartifactsCatalogFixtures.ciJobArtifactEntry())
                .type(null);

        final GitLabCiJobArtifactEntry built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabCiJobArtifactEntryBuilder builder = GitLabCiJobArtifactEntryBuilder.builder(
                        JobsartifactsCatalogFixtures.ciJobArtifactEntry())
                .size(null);

        final GitLabCiJobArtifactEntry built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModeIsNullable() {
        final GitLabCiJobArtifactEntryBuilder builder = GitLabCiJobArtifactEntryBuilder.builder(
                        JobsartifactsCatalogFixtures.ciJobArtifactEntry())
                .mode(null);

        final GitLabCiJobArtifactEntry built = builder.build();

        assertThat(built.mode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobArtifactEntry value = JobsartifactsCatalogFixtures.ciJobArtifactEntry();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("index.html");
            softly.assertThat(value.path()).isEqualTo("coverage/index.html");
            softly.assertThat(value.type()).isEqualTo(GitLabCiJobArtifactEntryType.FILE);
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.mode()).isEqualTo("100644");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobArtifactEntry original = JobsartifactsCatalogFixtures.ciJobArtifactEntry();

        final GitLabCiJobArtifactEntry rebuilt =
                GitLabCiJobArtifactEntryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobArtifactEntry.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "path", "type", "size", "mode");
    }
}
