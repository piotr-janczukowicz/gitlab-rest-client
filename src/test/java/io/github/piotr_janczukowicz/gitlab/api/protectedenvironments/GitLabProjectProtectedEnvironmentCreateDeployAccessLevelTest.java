package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedEnvironmentCreateDeployAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentCreateDeployAccessLevel())
                        .userId(null);

        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentCreateDeployAccessLevel())
                        .groupId(null);

        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentCreateDeployAccessLevel())
                        .groupInheritanceType(null);

        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentCreateDeployAccessLevel())
                        .accessLevel(null);

        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateDeployAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabProjectProtectedEnvironmentCreateDeployAccessLevelGroupInheritanceType.N_0);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabProjectProtectedEnvironmentCreateDeployAccessLevelAccessLevel.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentCreateDeployAccessLevel();

        final GitLabProjectProtectedEnvironmentCreateDeployAccessLevel rebuilt =
                GitLabProjectProtectedEnvironmentCreateDeployAccessLevelBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProtectedEnvironmentCreateDeployAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "groupId", "groupInheritanceType", "accessLevel");
    }
}
