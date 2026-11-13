package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMemberTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).id(null);

        final GitLabMember built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).username(null);

        final GitLabMember built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).publicEmail(null);

        final GitLabMember built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).name(null);

        final GitLabMember built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).state(null);

        final GitLabMember built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).locked(null);

        final GitLabMember built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).avatarUrl(null);

        final GitLabMember built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).avatarPath(null);

        final GitLabMember built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).customAttributes(null);

        final GitLabMember built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).webUrl(null);

        final GitLabMember built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).accessLevel(null);

        final GitLabMember built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).createdAt(null);

        final GitLabMember built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).createdBy(null);

        final GitLabMember built = builder.build();

        assertThat(built.createdBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).expiresAt(null);

        final GitLabMember built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorEnabledIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).twoFactorEnabled(null);

        final GitLabMember built = builder.build();

        assertThat(built.twoFactorEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupSamlIdentityIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).groupSamlIdentity(null);

        final GitLabMember built = builder.build();

        assertThat(built.groupSamlIdentity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupScimIdentityIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).groupScimIdentity(null);

        final GitLabMember built = builder.build();

        assertThat(built.groupScimIdentity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).email(null);

        final GitLabMember built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsUsingSeatIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).isUsingSeat(null);

        final GitLabMember built = builder.build();

        assertThat(built.isUsingSeat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOverrideIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).override(null);

        final GitLabMember built = builder.build();

        assertThat(built.override()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembershipStateIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).membershipState(null);

        final GitLabMember built = builder.build();

        assertThat(built.membershipState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIsNullable() {
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).memberRole(null);

        final GitLabMember built = builder.build();

        assertThat(built.memberRole()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMember value = CommonCatalogFixtures.member();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("admin");
            softly.assertThat(value.publicEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.name()).isEqualTo("Administrator");
            softly.assertThat(value.state()).isEqualTo("active");
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.avatarUrl()).isEqualTo("https://gravatar.com/avatar/1");
            softly.assertThat(value.avatarPath()).isEqualTo("/user/avatar/28/The-Big-Lebowski-400-400.png");
            softly.assertThat(value.customAttributes()).isEqualTo(List.of(CommonCatalogFixtures.customAttribute()));
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/root");
            softly.assertThat(value.accessLevel()).isEqualTo(1);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.expiresAt()).isEqualTo("expires_at");
            softly.assertThat(value.twoFactorEnabled()).isEqualTo(true);
            softly.assertThat(value.groupSamlIdentity()).isEqualTo(CommonCatalogFixtures.identity());
            softly.assertThat(value.groupScimIdentity()).isEqualTo(CommonCatalogFixtures.scimIdentity());
            softly.assertThat(value.email()).isEqualTo("email");
            softly.assertThat(value.isUsingSeat()).isEqualTo("is_using_seat");
            softly.assertThat(value.override()).isEqualTo("override");
            softly.assertThat(value.membershipState()).isEqualTo("membership_state");
            softly.assertThat(value.memberRole()).isEqualTo(CommonCatalogFixtures.memberRole());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMember original = CommonCatalogFixtures.member();

        final GitLabMember rebuilt = GitLabMemberBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabMemberBuilder builder =
                GitLabMemberBuilder.builder(CommonCatalogFixtures.member()).createdAt(instant);

        final GitLabMember built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMember.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "username",
                        "publicEmail",
                        "name",
                        "state",
                        "locked",
                        "avatarUrl",
                        "avatarPath",
                        "customAttributes",
                        "webUrl",
                        "accessLevel",
                        "createdAt",
                        "createdBy",
                        "expiresAt",
                        "twoFactorEnabled",
                        "groupSamlIdentity",
                        "groupScimIdentity",
                        "email",
                        "isUsingSeat",
                        "override",
                        "membershipState",
                        "memberRole");
    }
}
