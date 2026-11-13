package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedEnvironmentUpdateApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .userId(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .groupId(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .groupInheritanceType(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .id(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .destroy(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .accessLevel(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule())
                        .requiredApprovals(null);

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRule value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabProjectProtectedEnvironmentUpdateApprovalRuleGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.MAINTAINER);
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentUpdateApprovalRule original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateApprovalRule();

        final GitLabProjectProtectedEnvironmentUpdateApprovalRule rebuilt =
                GitLabProjectProtectedEnvironmentUpdateApprovalRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProtectedEnvironmentUpdateApprovalRule.class.getRecordComponents())
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
