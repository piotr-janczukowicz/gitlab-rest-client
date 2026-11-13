package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGroupLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .id(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .projectId(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .groupId(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAccessIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .groupAccess(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.groupAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .expiresAt(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProjectGroupLinkBuilder builder = GitLabProjectGroupLinkBuilder.builder(
                        ProjectsCatalogFixtures.projectGroupLink())
                .memberRoleId(null);

        final GitLabProjectGroupLink built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectGroupLink value = ProjectsCatalogFixtures.projectGroupLink();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupAccess()).isEqualTo(1);
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectGroupLink original = ProjectsCatalogFixtures.projectGroupLink();

        final GitLabProjectGroupLink rebuilt =
                GitLabProjectGroupLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectGroupLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "projectId", "groupId", "groupAccess", "expiresAt", "memberRoleId");
    }
}
