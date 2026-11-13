package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMembersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupMembersUpdatePayloadBuilder builder = GitLabGroupMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersUpdatePayload())
                .accessLevel(null);

        final GitLabGroupMembersUpdatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupMembersUpdatePayloadBuilder builder = GitLabGroupMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersUpdatePayload())
                .expiresAt(null);

        final GitLabGroupMembersUpdatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupMembersUpdatePayloadBuilder builder = GitLabGroupMembersUpdatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersUpdatePayload())
                .memberRoleId(null);

        final GitLabGroupMembersUpdatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMembersUpdatePayload value = MembersCatalogFixtures.groupMembersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMembersUpdatePayload original = MembersCatalogFixtures.groupMembersUpdatePayload();

        final GitLabGroupMembersUpdatePayload rebuilt =
                GitLabGroupMembersUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMembersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "expiresAt", "memberRoleId");
    }
}
