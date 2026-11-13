package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceDeployKeysCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabInstanceDeployKeysCreatePayloadBuilder builder =
                GitLabInstanceDeployKeysCreatePayloadBuilder.builder(
                                DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload())
                        .key(null);

        final GitLabInstanceDeployKeysCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabInstanceDeployKeysCreatePayloadBuilder builder =
                GitLabInstanceDeployKeysCreatePayloadBuilder.builder(
                                DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload())
                        .title(null);

        final GitLabInstanceDeployKeysCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabInstanceDeployKeysCreatePayloadBuilder builder =
                GitLabInstanceDeployKeysCreatePayloadBuilder.builder(
                                DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload())
                        .expiresAt(null);

        final GitLabInstanceDeployKeysCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceDeployKeysCreatePayload value = DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceDeployKeysCreatePayload original =
                DeploykeysCatalogFixtures.instanceDeployKeysCreatePayload();

        final GitLabInstanceDeployKeysCreatePayload rebuilt =
                GitLabInstanceDeployKeysCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceDeployKeysCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "title", "expiresAt");
    }
}
