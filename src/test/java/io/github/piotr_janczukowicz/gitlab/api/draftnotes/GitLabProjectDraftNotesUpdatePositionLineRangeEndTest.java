package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesUpdatePositionLineRangeEndTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd())
                        .lineCode(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd())
                        .type(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd())
                        .oldLine(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd())
                        .newLine(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd value =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd original =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd();

        final GitLabProjectDraftNotesUpdatePositionLineRangeEnd rebuilt =
                GitLabProjectDraftNotesUpdatePositionLineRangeEndBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDraftNotesUpdatePositionLineRangeEnd.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
