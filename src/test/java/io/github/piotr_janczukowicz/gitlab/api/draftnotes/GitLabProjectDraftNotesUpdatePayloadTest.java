package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabProjectDraftNotesUpdatePayloadBuilder builder = GitLabProjectDraftNotesUpdatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload())
                .note(null);

        final GitLabProjectDraftNotesUpdatePayload built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabProjectDraftNotesUpdatePayloadBuilder builder = GitLabProjectDraftNotesUpdatePayloadBuilder.builder(
                        DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload())
                .position(null);

        final GitLabProjectDraftNotesUpdatePayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesUpdatePayload value = DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.note()).isEqualTo("note");
            softly.assertThat(value.position()).isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesUpdatePosition());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesUpdatePayload original =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePayload();

        final GitLabProjectDraftNotesUpdatePayload rebuilt =
                GitLabProjectDraftNotesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("note", "position");
    }
}
