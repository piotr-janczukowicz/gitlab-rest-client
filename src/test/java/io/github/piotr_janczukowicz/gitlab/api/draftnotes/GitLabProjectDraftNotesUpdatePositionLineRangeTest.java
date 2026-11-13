package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesUpdatePositionLineRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenStartIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange())
                        .start(null);

        final GitLabProjectDraftNotesUpdatePositionLineRange built = builder.build();

        assertThat(built.start()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndIsNullable() {
        final GitLabProjectDraftNotesUpdatePositionLineRangeBuilder builder =
                GitLabProjectDraftNotesUpdatePositionLineRangeBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange())
                        .end(null);

        final GitLabProjectDraftNotesUpdatePositionLineRange built = builder.build();

        assertThat(built.end()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesUpdatePositionLineRange value =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange();

        assertSoftly(softly -> {
            softly.assertThat(value.start())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeStart());
            softly.assertThat(value.end())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRangeEnd());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesUpdatePositionLineRange original =
                DraftnotesCatalogFixtures.projectDraftNotesUpdatePositionLineRange();

        final GitLabProjectDraftNotesUpdatePositionLineRange rebuilt =
                GitLabProjectDraftNotesUpdatePositionLineRangeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesUpdatePositionLineRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("start", "end");
    }
}
