package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMembersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectMembersCreatePayloadBuilder builder = GitLabProjectMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersCreatePayload())
                .accessLevel(null);

        final GitLabProjectMembersCreatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectMembersCreatePayloadBuilder builder = GitLabProjectMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersCreatePayload())
                .userId(null);

        final GitLabProjectMembersCreatePayload built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectMembersCreatePayloadBuilder builder = GitLabProjectMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersCreatePayload())
                .username(null);

        final GitLabProjectMembersCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectMembersCreatePayloadBuilder builder = GitLabProjectMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersCreatePayload())
                .expiresAt(null);

        final GitLabProjectMembersCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteSourceIsNullable() {
        final GitLabProjectMembersCreatePayloadBuilder builder = GitLabProjectMembersCreatePayloadBuilder.builder(
                        MembersCatalogFixtures.projectMembersCreatePayload())
                .inviteSource(null);

        final GitLabProjectMembersCreatePayload built = builder.build();

        assertThat(built.inviteSource()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMembersCreatePayload value = MembersCatalogFixtures.projectMembersCreatePayload();

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
        final GitLabProjectMembersCreatePayload original = MembersCatalogFixtures.projectMembersCreatePayload();

        final GitLabProjectMembersCreatePayload rebuilt =
                GitLabProjectMembersCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMembersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "userId", "username", "expiresAt", "inviteSource");
    }
}
