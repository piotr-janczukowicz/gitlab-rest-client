package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotesUpdateEpicsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabGroupNotesUpdateEpicsNotesPayloadBuilder builder =
                GitLabGroupNotesUpdateEpicsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload())
                        .body(null);

        final GitLabGroupNotesUpdateEpicsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupNotesUpdateEpicsNotesPayloadBuilder builder =
                GitLabGroupNotesUpdateEpicsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload())
                        .confidential(null);

        final GitLabGroupNotesUpdateEpicsNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesUpdateEpicsNotesPayload value = NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesUpdateEpicsNotesPayload original =
                NotesCatalogFixtures.groupNotesUpdateEpicsNotesPayload();

        final GitLabGroupNotesUpdateEpicsNotesPayload rebuilt =
                GitLabGroupNotesUpdateEpicsNotesPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesUpdateEpicsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential");
    }
}
