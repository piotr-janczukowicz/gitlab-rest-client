package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .userId(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .groupId(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInheritanceTypeIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .groupInheritanceType(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.groupInheritanceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .id(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .destroy(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.destroy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder builder =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(
                                ProtectedenvironmentsCatalogFixtures
                                        .projectProtectedEnvironmentUpdateDeployAccessLevel())
                        .accessLevel(null);

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel value =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateDeployAccessLevel();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupInheritanceType())
                    .isEqualTo(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelGroupInheritanceType.N_0);
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.destroy()).isEqualTo(true);
            softly.assertThat(value.accessLevel())
                    .isEqualTo(GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel original =
                ProtectedenvironmentsCatalogFixtures.projectProtectedEnvironmentUpdateDeployAccessLevel();

        final GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel rebuilt =
                GitLabProjectProtectedEnvironmentUpdateDeployAccessLevelBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProtectedEnvironmentUpdateDeployAccessLevel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "groupId", "groupInheritanceType", "id", "destroy", "accessLevel");
    }
}
