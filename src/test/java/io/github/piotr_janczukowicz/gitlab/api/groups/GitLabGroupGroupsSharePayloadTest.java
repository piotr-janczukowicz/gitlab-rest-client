package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsSharePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupGroupsSharePayloadBuilder builder = GitLabGroupGroupsSharePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsSharePayload())
                .groupId(null);

        final GitLabGroupGroupsSharePayload built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenGroupAccessIsNull() {
        final GitLabGroupGroupsSharePayloadBuilder builder = GitLabGroupGroupsSharePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsSharePayload())
                .groupAccess(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("groupAccess");
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupGroupsSharePayloadBuilder builder = GitLabGroupGroupsSharePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsSharePayload())
                .expiresAt(null);

        final GitLabGroupGroupsSharePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupGroupsSharePayloadBuilder builder = GitLabGroupGroupsSharePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsSharePayload())
                .memberRoleId(null);

        final GitLabGroupGroupsSharePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsSharePayload value = GroupsCatalogFixtures.groupGroupsSharePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.groupAccess()).isEqualTo(GitLabGroupGroupsShareGroupAccess.N_5);
            softly.assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsSharePayload original = GroupsCatalogFixtures.groupGroupsSharePayload();

        final GitLabGroupGroupsSharePayload rebuilt =
                GitLabGroupGroupsSharePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsSharePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("groupId", "groupAccess", "expiresAt", "memberRoleId");
    }
}
