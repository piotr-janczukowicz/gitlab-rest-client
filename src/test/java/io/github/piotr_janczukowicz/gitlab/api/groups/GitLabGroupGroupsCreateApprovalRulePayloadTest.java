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
class GitLabGroupGroupsCreateApprovalRulePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupsCreateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .name(null);

        final GitLabGroupGroupsCreateApprovalRulePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsRequiredIsNullable() {
        final GitLabGroupGroupsCreateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .approvalsRequired(null);

        final GitLabGroupGroupsCreateApprovalRulePayload built = builder.build();

        assertThat(built.approvalsRequired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuleTypeIsNullable() {
        final GitLabGroupGroupsCreateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .ruleType(null);

        final GitLabGroupGroupsCreateApprovalRulePayload built = builder.build();

        assertThat(built.ruleType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabGroupGroupsCreateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .userIds(null);

        final GitLabGroupGroupsCreateApprovalRulePayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdsIsNullable() {
        final GitLabGroupGroupsCreateApprovalRulePayloadBuilder builder =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .groupIds(null);

        final GitLabGroupGroupsCreateApprovalRulePayload built = builder.build();

        assertThat(built.groupIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsCreateApprovalRulePayload value =
                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload();

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
        final GitLabGroupGroupsCreateApprovalRulePayload original =
                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload();

        final GitLabGroupGroupsCreateApprovalRulePayload rebuilt =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupGroupsCreateApprovalRulePayload built =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabGroupGroupsCreateApprovalRulePayload built =
                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGroupIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupGroupsCreateApprovalRulePayload built =
                GitLabGroupGroupsCreateApprovalRulePayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload())
                        .groupIds(source)
                        .build();
        source.clear();

        assertThat(built.groupIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGroupIdsIsRead() {
        final GitLabGroupGroupsCreateApprovalRulePayload built =
                GroupsCatalogFixtures.groupGroupsCreateApprovalRulePayload();
        final List<Long> values = built.groupIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsCreateApprovalRulePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "approvalsRequired", "ruleType", "userIds", "groupIds");
    }
}
