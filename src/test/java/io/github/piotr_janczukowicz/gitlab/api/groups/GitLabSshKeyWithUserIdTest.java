package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSshKeyWithUserIdTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .id(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .title(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .createdAt(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .expiresAt(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .lastUsedAt(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageTypeIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .usageType(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.usageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabSshKeyWithUserIdBuilder builder = GitLabSshKeyWithUserIdBuilder.builder(
                        GroupsCatalogFixtures.sshKeyWithUserId())
                .userId(null);

        final GitLabSshKeyWithUserId built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSshKeyWithUserId value = GroupsCatalogFixtures.sshKeyWithUserId();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Sample key 25");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.usageType()).isEqualTo("auth");
            softly.assertThat(value.userId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSshKeyWithUserId original = GroupsCatalogFixtures.sshKeyWithUserId();

        final GitLabSshKeyWithUserId rebuilt =
                GitLabSshKeyWithUserIdBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSshKeyWithUserId.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "title", "createdAt", "expiresAt", "lastUsedAt", "usageType", "userId");
    }
}
