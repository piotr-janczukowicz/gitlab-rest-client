package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedEnvironmentCreateApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .userId(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .groupId(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .groupInheritanceType(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .id(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .destroy(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .accessLevel(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateApprovalRule())
                        .requiredApprovals(null);

        final GitLabGroupProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRule value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabGroupProtectedEnvironmentCreateApprovalRuleAccessLevel.MAINTAINER);
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentCreateApprovalRule original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateApprovalRule();

        final GitLabGroupProtectedEnvironmentCreateApprovalRule rebuilt =
                GitLabGroupProtectedEnvironmentCreateApprovalRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupProtectedEnvironmentCreateApprovalRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "userId",
                        "groupId",
                        "groupInheritanceType",
                        "id",
                        "destroy",
                        "accessLevel",
                        "requiredApprovals");
    }
}
