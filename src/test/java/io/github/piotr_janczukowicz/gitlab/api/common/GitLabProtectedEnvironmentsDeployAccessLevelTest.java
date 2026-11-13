package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedEnvironmentsDeployAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .id(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .accessLevel(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelDescriptionIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .accessLevelDescription(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.accessLevelDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployKeyIdIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .deployKeyId(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.deployKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .userId(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .groupId(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .memberRoleId(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleNameIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .memberRoleName(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.memberRoleName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProtectedEnvironmentsDeployAccessLevelBuilder builder =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(
                                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel())
                        .groupInheritanceType(null);

        final GitLabProtectedEnvironmentsDeployAccessLevel built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedEnvironmentsDeployAccessLevel value =
                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.accessLevelDescription()).isEqualTo("Maintainers");
            softly.assertThat(value.deployKeyId()).isEqualTo(1L);
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
            softly.assertThat(value.memberRoleName()).isEqualTo("Lead Developer");
            softly.assertThat(value.groupInheritanceType()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedEnvironmentsDeployAccessLevel original =
                CommonCatalogFixtures.protectedEnvironmentsDeployAccessLevel();

        final GitLabProtectedEnvironmentsDeployAccessLevel rebuilt =
                GitLabProtectedEnvironmentsDeployAccessLevelBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedEnvironmentsDeployAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "accessLevel",
                        "accessLevelDescription",
                        "deployKeyId",
                        "userId",
                        "groupId",
                        "memberRoleId",
                        "memberRoleName",
                        "groupInheritanceType");
    }
}
