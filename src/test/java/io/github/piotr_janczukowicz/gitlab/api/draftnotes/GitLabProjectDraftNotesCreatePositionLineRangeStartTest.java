package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesCreatePositionLineRangeStartTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart())
                        .lineCode(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeStart built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart())
                        .type(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeStart built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart())
                        .oldLine(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeStart built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart())
                        .newLine(null);

        final GitLabProjectDraftNotesCreatePositionLineRangeStart built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStart value =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesCreatePositionLineRangeStart original =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart();

        final GitLabProjectDraftNotesCreatePositionLineRangeStart rebuilt =
                GitLabProjectDraftNotesCreatePositionLineRangeStartBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDraftNotesCreatePositionLineRangeStart.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
