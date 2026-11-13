package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedEnvironmentUpdateApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .userId(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .groupId(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .groupInheritanceType(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .id(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .destroy(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .accessLevel(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateApprovalRule())
                        .requiredApprovals(null);

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRule value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabGroupProtectedEnvironmentUpdateApprovalRuleGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabGroupProtectedEnvironmentUpdateApprovalRuleAccessLevel.MAINTAINER);
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentUpdateApprovalRule original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateApprovalRule();

        final GitLabGroupProtectedEnvironmentUpdateApprovalRule rebuilt =
                GitLabGroupProtectedEnvironmentUpdateApprovalRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupProtectedEnvironmentUpdateApprovalRule.class.getRecordComponents())
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
