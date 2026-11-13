package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd())
                        .lineCode(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd())
                        .type(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd())
                        .oldLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd())
                        .newLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd();

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd rebuilt =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEndBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
