package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSSHKeyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).id(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).title(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).createdAt(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).expiresAt(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).lastUsedAt(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).key(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageTypeIsNullable() {
        final GitLabSSHKeyBuilder builder =
                GitLabSSHKeyBuilder.builder(CommonCatalogFixtures.sshkey()).usageType(null);

        final GitLabSSHKey built = builder.build();

        assertThat(built.usageType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSSHKey value = CommonCatalogFixtures.sshkey();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Sample key 25");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.key())
                    .isEqualTo(
                            "ssh-rsa AAAAB3NzaC1yc2EAAAABJQAAAIEAiPWx6WM4lhHNedGfBpPJNPpZ7yKu+dnn1SJejgt1256k6Yjz\\\n      GGphH2TUxwKzxcKDKKezwkpfnxPkSMkuEspGRt/aZZ9wa++Oi7Qkr8prgHc4soW6NUlfDzpvZK2H5E7eQaSeP3SAwGmQKUFHCdd\\\n      NaP0L+hM7zhFNzjFvpaMgJw0=");
            softly.assertThat(value.usageType()).isEqualTo("auth");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSSHKey original = CommonCatalogFixtures.sshkey();

        final GitLabSSHKey rebuilt = GitLabSSHKeyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSSHKey.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "title", "createdAt", "expiresAt", "lastUsedAt", "key", "usageType");
    }
}
