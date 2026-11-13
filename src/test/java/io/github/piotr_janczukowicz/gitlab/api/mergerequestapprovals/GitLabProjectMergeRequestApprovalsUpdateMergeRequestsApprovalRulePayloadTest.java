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
class GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .name(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .userIds(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .groupIds(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernamesIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .usernames(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.usernames()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveHiddenGroupsIsNullable() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder builder =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .removeHiddenGroups(null);

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built = builder.build();

        assertThat(built.removeHiddenGroups()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload value =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.usernames()).isEqualTo(List.of("usernames"));
            softly.assertThat(value.removeHiddenGroups()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload original =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload();

        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload rebuilt =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUsernamesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("usernames"));
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayloadBuilder.builder(
                                MergerequestapprovalsCatalogFixtures
                                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload())
                        .usernames(source)
                        .build();
        source.clear();

        assertThat(built.usernames()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUsernamesIsRead() {
        final GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload built =
                MergerequestapprovalsCatalogFixtures
                        .projectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload();
        final List<String> values = built.usernames();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeRequestApprovalsUpdateMergeRequestsApprovalRulePayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("name", "approvalsRequired", "userIds", "groupIds", "usernames", "removeHiddenGroups");
    }
}
