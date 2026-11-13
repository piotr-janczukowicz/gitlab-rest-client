package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedEnvironmentCreateApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .userId(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .groupId(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .groupInheritanceType(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .id(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .destroy(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .accessLevel(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule())
                        .requiredApprovals(null);

        final GitLabProjectProtectedEnvironmentCreateApprovalRule built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRule value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabProjectProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabProjectProtectedEnvironmentCreateApprovalRuleAccessLevel.MAINTAINER);
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentCreateApprovalRule original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateApprovalRule();

        final GitLabProjectProtectedEnvironmentCreateApprovalRule rebuilt =
                GitLabProjectProtectedEnvironmentCreateApprovalRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProtectedEnvironmentCreateApprovalRule.class.getRecordComponents())
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
