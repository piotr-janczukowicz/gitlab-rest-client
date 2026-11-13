package io.github.piotr_janczukowicz.gitlab.api.issueboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssueBoardsCreateListPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelIdIsNullable() {
        final GitLabProjectIssueBoardsCreateListPayloadBuilder builder =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload())
                        .labelId(null);

        final GitLabProjectIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.labelId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectIssueBoardsCreateListPayloadBuilder builder =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload())
                        .milestoneId(null);

        final GitLabProjectIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIdIsNullable() {
        final GitLabProjectIssueBoardsCreateListPayloadBuilder builder =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload())
                        .iterationId(null);

        final GitLabProjectIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.iterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectIssueBoardsCreateListPayloadBuilder builder =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload())
                        .assigneeId(null);

        final GitLabProjectIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIdIsNullable() {
        final GitLabProjectIssueBoardsCreateListPayloadBuilder builder =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(
                                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload())
                        .statusId(null);

        final GitLabProjectIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.statusId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssueBoardsCreateListPayload value =
                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.labelId()).isEqualTo(1L);
            softly.assertThat(value.milestoneId()).isEqualTo(1L);
            softly.assertThat(value.iterationId()).isEqualTo(1L);
            softly.assertThat(value.assigneeId()).isEqualTo(1L);
            softly.assertThat(value.statusId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssueBoardsCreateListPayload original =
                IssueboardsCatalogFixtures.projectIssueBoardsCreateListPayload();

        final GitLabProjectIssueBoardsCreateListPayload rebuilt =
                GitLabProjectIssueBoardsCreateListPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssueBoardsCreateListPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelId", "milestoneId", "iterationId", "assigneeId", "statusId");
    }
}
