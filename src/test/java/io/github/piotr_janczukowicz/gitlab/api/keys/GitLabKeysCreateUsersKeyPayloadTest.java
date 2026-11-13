package io.github.piotr_janczukowicz.gitlab.api.keys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabKeysCreateUsersKeyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabKeysCreateUsersKeyPayloadBuilder builder = GitLabKeysCreateUsersKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUsersKeyPayload())
                .key(null);

        final GitLabKeysCreateUsersKeyPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabKeysCreateUsersKeyPayloadBuilder builder = GitLabKeysCreateUsersKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUsersKeyPayload())
                .title(null);

        final GitLabKeysCreateUsersKeyPayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabKeysCreateUsersKeyPayloadBuilder builder = GitLabKeysCreateUsersKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUsersKeyPayload())
                .expiresAt(null);

        final GitLabKeysCreateUsersKeyPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsageTypeIsNullable() {
        final GitLabKeysCreateUsersKeyPayloadBuilder builder = GitLabKeysCreateUsersKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUsersKeyPayload())
                .usageType(null);

        final GitLabKeysCreateUsersKeyPayload built = builder.build();

        assertThat(built.usageType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabKeysCreateUsersKeyPayload value = KeysCatalogFixtures.keysCreateUsersKeyPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.usageType()).isEqualTo(GitLabKeysCreateUsersKeyUsageType.AUTH_AND_SIGNING);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabKeysCreateUsersKeyPayload original = KeysCatalogFixtures.keysCreateUsersKeyPayload();

        final GitLabKeysCreateUsersKeyPayload rebuilt =
                GitLabKeysCreateUsersKeyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabKeysCreateUsersKeyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "title", "expiresAt", "usageType");
    }
}
