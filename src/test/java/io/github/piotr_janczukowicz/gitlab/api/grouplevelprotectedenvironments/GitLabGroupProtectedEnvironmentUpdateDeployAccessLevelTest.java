package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .userId(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .groupId(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .groupInheritanceType(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .id(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .destroy(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentUpdateDeployAccessLevel())
                        .accessLevel(null);

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateDeployAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentUpdateDeployAccessLevel();

        final GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel rebuilt =
                GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupProtectedEnvironmentUpdateDeployAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "groupId", "groupInheritanceType", "id", "destroy", "accessLevel");
    }
}
