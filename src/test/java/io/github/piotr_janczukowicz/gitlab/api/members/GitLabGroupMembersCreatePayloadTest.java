package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMembersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupMembersCreatePayloadBuilder builder = GitLabGroupMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersCreatePayload())
                .accessLevel(null);

        final GitLabGroupMembersCreatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupMembersCreatePayloadBuilder builder = GitLabGroupMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersCreatePayload())
                .userId(null);

        final GitLabGroupMembersCreatePayload built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupMembersCreatePayloadBuilder builder = GitLabGroupMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersCreatePayload())
                .username(null);

        final GitLabGroupMembersCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupMembersCreatePayloadBuilder builder = GitLabGroupMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersCreatePayload())
                .expiresAt(null);

        final GitLabGroupMembersCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteSourceIsNullable() {
        final GitLabGroupMembersCreatePayloadBuilder builder = GitLabGroupMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersCreatePayload())
                .inviteSource(null);

        final GitLabGroupMembersCreatePayload built = builder.build();

        assertThat(built.inviteSource()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMembersCreatePayload value = MembersCatalogFixtures.groupMembersCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.userId()).isEqualTo("text");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.inviteSource()).isEqualTo("invite_source");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMembersCreatePayload original = MembersCatalogFixtures.groupMembersCreatePayload();

        final GitLabGroupMembersCreatePayload rebuilt =
                GitLabGroupMembersCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMembersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "userId", "username", "expiresAt", "inviteSource");
    }
}
