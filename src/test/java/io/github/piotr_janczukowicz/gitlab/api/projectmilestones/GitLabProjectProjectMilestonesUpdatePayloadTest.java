package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectMilestonesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectMilestonesUpdatePayloadBuilder builder =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload())
                        .title(null);

        final GitLabProjectProjectMilestonesUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateEventIsNullable() {
        final GitLabProjectProjectMilestonesUpdatePayloadBuilder builder =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload())
                        .stateEvent(null);

        final GitLabProjectProjectMilestonesUpdatePayload built = builder.build();

        assertThat(built.stateEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectMilestonesUpdatePayloadBuilder builder =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload())
                        .description(null);

        final GitLabProjectProjectMilestonesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabProjectProjectMilestonesUpdatePayloadBuilder builder =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload())
                        .dueDate(null);

        final GitLabProjectProjectMilestonesUpdatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabProjectProjectMilestonesUpdatePayloadBuilder builder =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload())
                        .startDate(null);

        final GitLabProjectProjectMilestonesUpdatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectMilestonesUpdatePayload value =
                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.stateEvent()).isEqualTo(GitLabProjectProjectMilestonesUpdateStateEvent.CLOSE);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectMilestonesUpdatePayload original =
                ProjectmilestonesCatalogFixtures.projectProjectMilestonesUpdatePayload();

        final GitLabProjectProjectMilestonesUpdatePayload rebuilt =
                GitLabProjectProjectMilestonesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectMilestonesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "stateEvent", "description", "dueDate", "startDate");
    }
}
