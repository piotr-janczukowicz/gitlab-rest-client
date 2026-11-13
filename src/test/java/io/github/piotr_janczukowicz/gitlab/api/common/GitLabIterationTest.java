package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIterationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .id(null);

        final GitLabIteration built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .iid(null);

        final GitLabIteration built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSequenceIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .sequence(null);

        final GitLabIteration built = builder.build();

        assertThat(built.sequence()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .groupId(null);

        final GitLabIteration built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .title(null);

        final GitLabIteration built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .description(null);

        final GitLabIteration built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .state(null);

        final GitLabIteration built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .createdAt(null);

        final GitLabIteration built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .updatedAt(null);

        final GitLabIteration built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .startDate(null);

        final GitLabIteration built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .dueDate(null);

        final GitLabIteration built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabIterationBuilder builder = GitLabIterationBuilder.builder(CommonCatalogFixtures.iteration())
                .webUrl(null);

        final GitLabIteration built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIteration value = CommonCatalogFixtures.iteration();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.sequence()).isEqualTo(1);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Iteration I");
            softly.assertThat(value.description()).isEqualTo("Iteration description");
            softly.assertThat(value.state()).isEqualTo(1);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/groups/gitlab-org/-/iterations/1");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIteration original = CommonCatalogFixtures.iteration();

        final GitLabIteration rebuilt = GitLabIterationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIteration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "sequence",
                        "groupId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "startDate",
                        "dueDate",
                        "webUrl");
    }
}
