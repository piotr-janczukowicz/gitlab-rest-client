package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicBaseEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .id(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .iid(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .title(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .url(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .groupId(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanReadableEndDateIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .humanReadableEndDate(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.humanReadableEndDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanReadableTimestampIsNullable() {
        final GitLabEpicBaseEntityBuilder builder = GitLabEpicBaseEntityBuilder.builder(
                        CommonCatalogFixtures.epicBaseEntity())
                .humanReadableTimestamp(null);

        final GitLabEpicBaseEntity built = builder.build();

        assertThat(built.humanReadableTimestamp()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicBaseEntity value = CommonCatalogFixtures.epicBaseEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.humanReadableEndDate()).isEqualTo("human_readable_end_date");
            softly.assertThat(value.humanReadableTimestamp()).isEqualTo("human_readable_timestamp");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicBaseEntity original = CommonCatalogFixtures.epicBaseEntity();

        final GitLabEpicBaseEntity rebuilt =
                GitLabEpicBaseEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicBaseEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "iid", "title", "url", "groupId", "humanReadableEndDate", "humanReadableTimestamp");
    }
}
