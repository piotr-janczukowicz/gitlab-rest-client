package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesCreateIssuesNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .body(null);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .confidential(null);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .internal(null);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .createdAt(null);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffHeadShaIsNullable() {
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .mergeRequestDiffHeadSha(null);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.mergeRequestDiffHeadSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesCreateIssuesNotesPayload value =
                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload();

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
        final GitLabProjectNotesCreateIssuesNotesPayload original =
                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload();

        final GitLabProjectNotesCreateIssuesNotesPayload rebuilt =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectNotesCreateIssuesNotesPayloadBuilder builder =
                GitLabProjectNotesCreateIssuesNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateIssuesNotesPayload())
                        .createdAt(instant);

        final GitLabProjectNotesCreateIssuesNotesPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesCreateIssuesNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential", "internal", "createdAt", "mergeRequestDiffHeadSha");
    }
}
