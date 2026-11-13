package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupMilestonesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupMilestonesCreatePayloadBuilder builder =
                GitLabGroupGroupMilestonesCreatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload())
                        .title(null);

        final GitLabGroupGroupMilestonesCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupMilestonesCreatePayloadBuilder builder =
                GitLabGroupGroupMilestonesCreatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload())
                        .description(null);

        final GitLabGroupGroupMilestonesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabGroupGroupMilestonesCreatePayloadBuilder builder =
                GitLabGroupGroupMilestonesCreatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload())
                        .dueDate(null);

        final GitLabGroupGroupMilestonesCreatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabGroupGroupMilestonesCreatePayloadBuilder builder =
                GitLabGroupGroupMilestonesCreatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload())
                        .startDate(null);

        final GitLabGroupGroupMilestonesCreatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupMilestonesCreatePayload value =
                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupMilestonesCreatePayload original =
                GroupmilestonesCatalogFixtures.groupGroupMilestonesCreatePayload();

        final GitLabGroupGroupMilestonesCreatePayload rebuilt =
                GitLabGroupGroupMilestonesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupMilestonesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "description", "dueDate", "startDate");
    }
}
