package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateRequestsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload())
                        .body(null);

        final GitLabProjectNotesUpdateRequestsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesUpdateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload())
                        .confidential(null);

        final GitLabProjectNotesUpdateRequestsNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateRequestsNotesPayload value =
                NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateRequestsNotesPayload original =
                NotesCatalogFixtures.projectNotesUpdateRequestsNotesPayload();

        final GitLabProjectNotesUpdateRequestsNotesPayload rebuilt =
                GitLabProjectNotesUpdateRequestsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesUpdateRequestsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential");
    }
}
