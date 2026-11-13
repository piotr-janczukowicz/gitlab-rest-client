package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .name(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalProjectRuleIdIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .approvalProjectRuleId(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.approvalProjectRuleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .userIds(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .groupIds(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .usernames(null);

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload value =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.approvalProjectRuleId()).isEqualTo(1L);
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.usernames()).isEqualTo(List.of("usernames"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload original =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload();

        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload rebuilt =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestApprovalsCreateMergeRequestsApprovalRulePayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "approvalsRequired", "approvalProjectRuleId", "userIds", "groupIds", "usernames");
    }
}
