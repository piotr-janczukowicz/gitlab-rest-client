package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateWikiPagesNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder builder =
                GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload())
                        .body(null);

        final GitLabProjectNotesUpdateWikiPagesNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder builder =
                GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload())
                        .confidential(null);

        final GitLabProjectNotesUpdateWikiPagesNotePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateWikiPagesNotePayload value =
                NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateWikiPagesNotePayload original =
                NotesCatalogFixtures.projectNotesUpdateWikiPagesNotePayload();

        final GitLabProjectNotesUpdateWikiPagesNotePayload rebuilt =
                GitLabProjectNotesUpdateWikiPagesNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesUpdateWikiPagesNotePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential");
    }
}
