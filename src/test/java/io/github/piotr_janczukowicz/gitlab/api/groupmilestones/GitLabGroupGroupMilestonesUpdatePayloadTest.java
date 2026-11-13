package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupMilestonesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupMilestonesUpdatePayloadBuilder builder =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload())
                        .title(null);

        final GitLabGroupGroupMilestonesUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateEventIsNullable() {
        final GitLabGroupGroupMilestonesUpdatePayloadBuilder builder =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload())
                        .stateEvent(null);

        final GitLabGroupGroupMilestonesUpdatePayload built = builder.build();

        assertThat(built.stateEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupMilestonesUpdatePayloadBuilder builder =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload())
                        .description(null);

        final GitLabGroupGroupMilestonesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabGroupGroupMilestonesUpdatePayloadBuilder builder =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload())
                        .dueDate(null);

        final GitLabGroupGroupMilestonesUpdatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabGroupGroupMilestonesUpdatePayloadBuilder builder =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(
                                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload())
                        .startDate(null);

        final GitLabGroupGroupMilestonesUpdatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupMilestonesUpdatePayload value =
                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.stateEvent()).isEqualTo(GitLabGroupGroupMilestonesUpdateStateEvent.CLOSE);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupMilestonesUpdatePayload original =
                GroupmilestonesCatalogFixtures.groupGroupMilestonesUpdatePayload();

        final GitLabGroupGroupMilestonesUpdatePayload rebuilt =
                GitLabGroupGroupMilestonesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupMilestonesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "stateEvent", "description", "dueDate", "startDate");
    }
}
