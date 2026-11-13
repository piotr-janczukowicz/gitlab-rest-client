package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedEnvironmentsApprovalRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .id(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .userId(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .groupId(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .accessLevel(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelDescriptionIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .accessLevelDescription(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.accessLevelDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequiredApprovalsIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .requiredApprovals(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.requiredApprovals()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProtectedEnvironmentsApprovalRuleBuilder builder =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsApprovalRule())
                        .groupInheritanceType(null);

        final GitLabProtectedEnvironmentsApprovalRule built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedEnvironmentsApprovalRule value = CommonCatalogFixtures.protectedEnvironmentsApprovalRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.accessLevelDescription()).isEqualTo("access_level_description");
            softly.assertThat(value.requiredApprovals()).isEqualTo(1);
            softly.assertThat(value.groupInheritanceType()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedEnvironmentsApprovalRule original =
                CommonCatalogFixtures.protectedEnvironmentsApprovalRule();

        final GitLabProtectedEnvironmentsApprovalRule rebuilt =
                GitLabProtectedEnvironmentsApprovalRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedEnvironmentsApprovalRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "userId",
                        "groupId",
                        "accessLevel",
                        "accessLevelDescription",
                        "requiredApprovals",
                        "groupInheritanceType");
    }
}
