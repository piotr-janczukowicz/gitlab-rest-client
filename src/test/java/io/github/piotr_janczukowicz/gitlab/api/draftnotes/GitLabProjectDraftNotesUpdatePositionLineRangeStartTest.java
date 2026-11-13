package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesUpdatePositionLineRangeStartTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart())
                        .lineCode(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeStart built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart())
                        .type(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeStart built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart())
                        .oldLine(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeStart built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart())
                        .newLine(null);

        final GitLabProjectDraftNotesUpdatePositionLineRangeStart built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStart value =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeStart original =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart();

        final GitLabProjectDraftNotesUpdatePositionLineRangeStart rebuilt =
                GitLabProjectDraftNotesUpdatePositionLineRangeStartBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDraftNotesUpdatePositionLineRangeStart.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
