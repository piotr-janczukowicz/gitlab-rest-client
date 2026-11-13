package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesCreatePositionLineRangeEndTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd())
                        .lineCode(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd())
                        .type(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd())
                        .oldLine(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd())
                        .newLine(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeEnd built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEnd value =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesCreatePositionLineRangeEnd original =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd();

        final GitLabProjectDraftNotesCreatePositionLineRangeEnd rebuilt =
                GitLabProjectDraftNotesCreatePositionLineRangeEndBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDraftNotesCreatePositionLineRangeEnd.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
