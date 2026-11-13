package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotesCreateWikiPagesNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .body(null);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .confidential(null);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .internal(null);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .createdAt(null);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffHeadShaIsNullable() {
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .mergeRequestDiffHeadSha(null);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.mergeRequestDiffHeadSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesCreateWikiPagesNotePayload value =
                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.internal()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeRequestDiffHeadSha()).isEqualTo("merge_request_diff_head_sha");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesCreateWikiPagesNotePayload original =
                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload();

        final GitLabGroupNotesCreateWikiPagesNotePayload rebuilt =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGroupNotesCreateWikiPagesNotePayloadBuilder builder =
                GitLabGroupNotesCreateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesCreateWikiPagesNotePayload())
                        .createdAt(instant);

        final GitLabGroupNotesCreateWikiPagesNotePayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesCreateWikiPagesNotePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential", "internal", "createdAt", "mergeRequestDiffHeadSha");
    }
}
