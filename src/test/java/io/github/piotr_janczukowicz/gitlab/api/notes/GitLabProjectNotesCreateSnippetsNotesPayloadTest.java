package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesCreateSnippetsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .body(null);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .confidential(null);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .internal(null);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .createdAt(null);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffHeadShaIsNullable() {
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .mergeRequestDiffHeadSha(null);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.mergeRequestDiffHeadSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesCreateSnippetsNotesPayload value =
                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload();

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
        final GitLabProjectNotesCreateSnippetsNotesPayload original =
                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload();

        final GitLabProjectNotesCreateSnippetsNotesPayload rebuilt =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectNotesCreateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsNotesPayload())
                        .createdAt(instant);

        final GitLabProjectNotesCreateSnippetsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesCreateSnippetsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential", "internal", "createdAt", "mergeRequestDiffHeadSha");
    }
}
