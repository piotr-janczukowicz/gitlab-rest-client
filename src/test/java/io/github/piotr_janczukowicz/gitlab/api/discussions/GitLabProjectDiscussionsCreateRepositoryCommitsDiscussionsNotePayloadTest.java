package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder builder =
                GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload())
                        .body(null);

        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder builder =
                GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload())
                        .createdAt(null);

        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload();

        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload rebuilt =
                GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder builder =
                GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload())
                        .createdAt(instant);

        final GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRepositoryCommitsDiscussionsNotePayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt");
    }
}
