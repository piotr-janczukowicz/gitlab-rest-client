package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIssueBoardsCreateListPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelIdIsNullable() {
        final GitLabGroupGroupIssueBoardsCreateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload())
                        .labelId(null);

        final GitLabGroupGroupIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.labelId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabGroupGroupIssueBoardsCreateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload())
                        .milestoneId(null);

        final GitLabGroupGroupIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIdIsNullable() {
        final GitLabGroupGroupIssueBoardsCreateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload())
                        .iterationId(null);

        final GitLabGroupGroupIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.iterationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabGroupGroupIssueBoardsCreateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload())
                        .assigneeId(null);

        final GitLabGroupGroupIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIdIsNullable() {
        final GitLabGroupGroupIssueBoardsCreateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload())
                        .statusId(null);

        final GitLabGroupGroupIssueBoardsCreateListPayload built = builder.build();

        assertThat(built.statusId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIssueBoardsCreateListPayload value =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload();

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
        final GitLabGroupGroupIssueBoardsCreateListPayload original =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsCreateListPayload();

        final GitLabGroupGroupIssueBoardsCreateListPayload rebuilt =
                GitLabGroupGroupIssueBoardsCreateListPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIssueBoardsCreateListPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelId", "milestoneId", "iterationId", "assigneeId", "statusId");
    }
}
