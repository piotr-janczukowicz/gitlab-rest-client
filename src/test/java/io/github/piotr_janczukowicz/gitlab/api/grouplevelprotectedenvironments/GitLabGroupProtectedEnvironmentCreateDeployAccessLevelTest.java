package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupProtectedEnvironmentCreateDeployAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateDeployAccessLevel())
                        .userId(null);

        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateDeployAccessLevel())
                        .groupId(null);

        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateDeployAccessLevel())
                        .groupInheritanceType(null);

        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                GrouplevelprotectedenvironmentsCatalogFixtures
                                        .groupProtectedEnvironmentCreateDeployAccessLevel())
                        .accessLevel(null);

        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel value =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateDeployAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabGroupProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.N_0);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabGroupProtectedEnvironmentCreateDeployAccessLevelAccessLevel.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel original =
                GrouplevelprotectedenvironmentsCatalogFixtures.groupProtectedEnvironmentCreateDeployAccessLevel();

        final GitLabGroupProtectedEnvironmentCreateDeployAccessLevel rebuilt =
                GitLabGroupProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupProtectedEnvironmentCreateDeployAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "groupId", "groupInheritanceType", "accessLevel");
    }
}
