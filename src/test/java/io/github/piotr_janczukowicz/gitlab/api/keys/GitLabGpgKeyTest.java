package io.github.piotr_janczukowicz.gitlab.api.keys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGpgKeyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGpgKeyBuilder builder =
                GitLabGpgKeyBuilder.builder(KeysCatalogFixtures.gpgKey()).id(null);

        final GitLabGpgKey built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGpgKeyBuilder builder =
                GitLabGpgKeyBuilder.builder(KeysCatalogFixtures.gpgKey()).key(null);

        final GitLabGpgKey built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGpgKeyBuilder builder =
                GitLabGpgKeyBuilder.builder(KeysCatalogFixtures.gpgKey()).createdAt(null);

        final GitLabGpgKey built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGpgKey value = KeysCatalogFixtures.gpgKey();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.key()).isEqualTo("-----BEGIN PGP PUBLIC KEY BLOCK-----");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGpgKey original = KeysCatalogFixtures.gpgKey();

        final GitLabGpgKey rebuilt = GitLabGpgKeyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGpgKey.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "key", "createdAt");
    }
}
