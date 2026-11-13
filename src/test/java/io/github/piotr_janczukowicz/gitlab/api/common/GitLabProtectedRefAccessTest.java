package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedRefAccessTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .id(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .accessLevel(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelDescriptionIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .accessLevelDescription(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.accessLevelDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployKeyIdIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .deployKeyId(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.deployKeyId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .userId(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .groupId(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .memberRoleId(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleNameIsNullable() {
        final GitLabProtectedRefAccessBuilder builder = GitLabProtectedRefAccessBuilder.builder(
                        CommonCatalogFixtures.protectedRefAccess())
                .memberRoleName(null);

        final GitLabProtectedRefAccess built = builder.build();

        assertThat(built.memberRoleName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedRefAccess value = CommonCatalogFixtures.protectedRefAccess();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.accessLevelDescription()).isEqualTo("Maintainers");
            softly.assertThat(value.deployKeyId()).isEqualTo(1L);
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
            softly.assertThat(value.memberRoleName()).isEqualTo("Lead Developer");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedRefAccess original = CommonCatalogFixtures.protectedRefAccess();

        final GitLabProtectedRefAccess rebuilt =
                GitLabProtectedRefAccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedRefAccess.class.getRecordComponents())
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
                        "memberRoleName");
    }
}
