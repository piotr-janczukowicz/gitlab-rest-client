package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotesCreateDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder builder =
                GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload())
                        .body(null);

        final GitLabGroupNotesCreateDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder builder =
                GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload())
                        .createdAt(null);

        final GitLabGroupNotesCreateDiscussionsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesCreateDiscussionsNotesPayload value =
                NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesCreateDiscussionsNotesPayload original =
                NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload();

        final GitLabGroupNotesCreateDiscussionsNotesPayload rebuilt =
                GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder builder =
                GitLabGroupNotesCreateDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateDiscussionsNotesPayload())
                        .createdAt(instant);

        final GitLabGroupNotesCreateDiscussionsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesCreateDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt");
    }
}
