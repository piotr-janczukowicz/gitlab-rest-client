package io.github.piotr_janczukowicz.gitlab.api.groups;

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
class GitLabGroupGroupsUpdateApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupsUpdateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .name(null);

        final GitLabGroupGroupsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabGroupGroupsUpdateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabGroupGroupsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabGroupGroupsUpdateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .ruleType(null);

        final GitLabGroupGroupsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabGroupGroupsUpdateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .userIds(null);

        final GitLabGroupGroupsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabGroupGroupsUpdateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .groupIds(null);

        final GitLabGroupGroupsUpdateApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateApprovalRulePayload value =
                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalsRequired()).isEqualTo(1);
            softly.assertThat(value.ruleType()).isEqualTo("regular");
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.groupIds()).isEqualTo(List.of(1L));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsUpdateApprovalRulePayload original =
                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload();

        final GitLabGroupGroupsUpdateApprovalRulePayload rebuilt =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupGroupsUpdateApprovalRulePayload built =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabGroupGroupsUpdateApprovalRulePayload built =
                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupGroupsUpdateApprovalRulePayload built =
                GitLabGroupGroupsUpdateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabGroupGroupsUpdateApprovalRulePayload built =
                GroupsCatalogFixtures.groupGroupsUpdateApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsUpdateApprovalRulePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "approvalsRequired", "ruleType", "userIds", "groupIds");
    }
}
