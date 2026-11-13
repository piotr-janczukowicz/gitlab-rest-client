package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectMilestonesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectMilestonesCreatePayloadBuilder builder =
                GitLabProjectProjectMilestonesCreatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload())
                        .title(null);

        final GitLabProjectProjectMilestonesCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectMilestonesCreatePayloadBuilder builder =
                GitLabProjectProjectMilestonesCreatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload())
                        .description(null);

        final GitLabProjectProjectMilestonesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabProjectProjectMilestonesCreatePayloadBuilder builder =
                GitLabProjectProjectMilestonesCreatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload())
                        .dueDate(null);

        final GitLabProjectProjectMilestonesCreatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabProjectProjectMilestonesCreatePayloadBuilder builder =
                GitLabProjectProjectMilestonesCreatePayloadBuilder.builder(
                                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload())
                        .startDate(null);

        final GitLabProjectProjectMilestonesCreatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectMilestonesCreatePayload value =
                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectMilestonesCreatePayload original =
                ProjectmilestonesCatalogFixtures.projectProjectMilestonesCreatePayload();

        final GitLabProjectProjectMilestonesCreatePayload rebuilt =
                GitLabProjectProjectMilestonesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectMilestonesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "description", "dueDate", "startDate");
    }
}
