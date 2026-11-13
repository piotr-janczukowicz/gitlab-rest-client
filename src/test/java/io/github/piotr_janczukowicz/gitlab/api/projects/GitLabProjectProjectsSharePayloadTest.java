package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsSharePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabProjectProjectsSharePayloadBuilder builder = GitLabProjectProjectsSharePayloadBuilder.builder(
                        ProjectsCatalogFixtures.projectProjectsSharePayload())
                .groupId(null);

        final GitLabProjectProjectsSharePayload built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupAccessIsNull() {
        final GitLabProjectProjectsSharePayloadBuilder builder = GitLabProjectProjectsSharePayloadBuilder.builder(
                        ProjectsCatalogFixtures.projectProjectsSharePayload())
                .groupAccess(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("groupAccess");
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectProjectsSharePayloadBuilder builder = GitLabProjectProjectsSharePayloadBuilder.builder(
                        ProjectsCatalogFixtures.projectProjectsSharePayload())
                .expiresAt(null);

        final GitLabProjectProjectsSharePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProjectProjectsSharePayloadBuilder builder = GitLabProjectProjectsSharePayloadBuilder.builder(
                        ProjectsCatalogFixtures.projectProjectsSharePayload())
                .memberRoleId(null);

        final GitLabProjectProjectsSharePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsSharePayload value = ProjectsCatalogFixtures.projectProjectsSharePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupAccess()).isEqualTo(GitLabProjectProjectsShareGroupAccess.N_10);
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsSharePayload original = ProjectsCatalogFixtures.projectProjectsSharePayload();

        final GitLabProjectProjectsSharePayload rebuilt =
                GitLabProjectProjectsSharePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsSharePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("groupId", "groupAccess", "expiresAt", "memberRoleId");
    }
}
