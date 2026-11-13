package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIssueBoardsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .name(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideBacklogListIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .hideBacklogList(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.hideBacklogList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideClosedListIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .hideClosedList(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.hideClosedList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .assigneeId(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .milestoneId(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .labels(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdatePayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload())
                        .weight(null);

        final GitLabGroupGroupIssueBoardsUpdatePayload built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIssueBoardsUpdatePayload value =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload();

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
        final GitLabGroupGroupIssueBoardsUpdatePayload original =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdatePayload();

        final GitLabGroupGroupIssueBoardsUpdatePayload rebuilt =
                GitLabGroupGroupIssueBoardsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIssueBoardsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "hideBacklogList", "hideClosedList", "assigneeId", "milestoneId", "labels", "weight");
    }
}
