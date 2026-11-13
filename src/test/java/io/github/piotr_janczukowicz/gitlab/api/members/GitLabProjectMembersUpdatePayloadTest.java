package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMembersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectMembersUpdatePayloadBuilder builder = GitLabProjectMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersUpdatePayload())
                .accessLevel(null);

        final GitLabProjectMembersUpdatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectMembersUpdatePayloadBuilder builder = GitLabProjectMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersUpdatePayload())
                .expiresAt(null);

        final GitLabProjectMembersUpdatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProjectMembersUpdatePayloadBuilder builder = GitLabProjectMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersUpdatePayload())
                .memberRoleId(null);

        final GitLabProjectMembersUpdatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMembersUpdatePayload value = MembersCatalogFixtures.projectMembersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMembersUpdatePayload original = MembersCatalogFixtures.projectMembersUpdatePayload();

        final GitLabProjectMembersUpdatePayload rebuilt =
                GitLabProjectMembersUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMembersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "expiresAt", "memberRoleId");
    }
}
