package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserSSHAndGPGKeysCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabUserSSHAndGPGKeysCreatePayloadBuilder builder = GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder(
                        UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload())
                .key(null);

        final GitLabUserSSHAndGPGKeysCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabUserSSHAndGPGKeysCreatePayloadBuilder builder = GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder(
                        UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload())
                .title(null);

        final GitLabUserSSHAndGPGKeysCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabUserSSHAndGPGKeysCreatePayloadBuilder builder = GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder(
                        UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload())
                .expiresAt(null);

        final GitLabUserSSHAndGPGKeysCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageTypeIsNullable() {
        final GitLabUserSSHAndGPGKeysCreatePayloadBuilder builder = GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder(
                        UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload())
                .usageType(null);

        final GitLabUserSSHAndGPGKeysCreatePayload built = builder.build();

        assertThat(built.usageType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserSSHAndGPGKeysCreatePayload value =
                UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.usageType()).isEqualTo(GitLabUserSSHAndGPGKeysCreateUsageType.AUTH_AND_SIGNING);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserSSHAndGPGKeysCreatePayload original =
                UsersshandgpgkeysCatalogFixtures.userSSHAndGPGKeysCreatePayload();

        final GitLabUserSSHAndGPGKeysCreatePayload rebuilt =
                GitLabUserSSHAndGPGKeysCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserSSHAndGPGKeysCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "title", "expiresAt", "usageType");
    }
}
