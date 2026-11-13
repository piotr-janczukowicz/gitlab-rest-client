package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDeployKeysCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectDeployKeysCreatePayloadBuilder builder = GitLabProjectDeployKeysCreatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysCreatePayload())
                .key(null);

        final GitLabProjectDeployKeysCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectDeployKeysCreatePayloadBuilder builder = GitLabProjectDeployKeysCreatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysCreatePayload())
                .title(null);

        final GitLabProjectDeployKeysCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanPushIsNullable() {
        final GitLabProjectDeployKeysCreatePayloadBuilder builder = GitLabProjectDeployKeysCreatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysCreatePayload())
                .canPush(null);

        final GitLabProjectDeployKeysCreatePayload built = builder.build();

        assertThat(built.canPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectDeployKeysCreatePayloadBuilder builder = GitLabProjectDeployKeysCreatePayloadBuilder.builder(
                        DeploykeysCatalogFixtures.projectDeployKeysCreatePayload())
                .expiresAt(null);

        final GitLabProjectDeployKeysCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeployKeysCreatePayload value = DeploykeysCatalogFixtures.projectDeployKeysCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.canPush()).isEqualTo(true);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeployKeysCreatePayload original =
                DeploykeysCatalogFixtures.projectDeployKeysCreatePayload();

        final GitLabProjectDeployKeysCreatePayload rebuilt =
                GitLabProjectDeployKeysCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeployKeysCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "title", "canPush", "expiresAt");
    }
}
