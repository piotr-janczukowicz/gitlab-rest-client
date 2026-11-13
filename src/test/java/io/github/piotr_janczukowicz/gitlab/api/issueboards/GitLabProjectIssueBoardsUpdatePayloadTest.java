package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssueBoardsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .name(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideBacklogListIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .hideBacklogList(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.hideBacklogList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideClosedListIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .hideClosedList(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.hideClosedList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .assigneeId(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .milestoneId(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .labels(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabProjectIssueBoardsUpdatePayloadBuilder builder =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload())
                        .weight(null);

        final GitLabProjectIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssueBoardsUpdatePayload value =
                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.hideBacklogList()).isEqualTo(true);
            softly.assertThat(value.hideClosedList()).isEqualTo(true);
            softly.assertThat(value.assigneeId()).isEqualTo(1L);
            softly.assertThat(value.milestoneId()).isEqualTo(1L);
            softly.assertThat(value.labels()).isEqualTo("labels");
            softly.assertThat(value.weight()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssueBoardsUpdatePayload original =
                IssueboardsCatalogFixtures.projectIssueBoardsUpdatePayload();

        final GitLabProjectIssueBoardsUpdatePayload rebuilt =
                GitLabProjectIssueBoardsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssueBoardsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "hideBacklogList", "hideClosedList", "assigneeId", "milestoneId", "labels", "weight");
    }
}
