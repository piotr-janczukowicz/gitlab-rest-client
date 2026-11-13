package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMirrorHostKeyTest {

    @Test
    void constructor_shouldAcceptNull_whenFingerprintSha256IsNullable() {
        final GitLabMirrorHostKeyBuilder builder = GitLabMirrorHostKeyBuilder.builder(
                        RemotemirrorsCatalogFixtures.mirrorHostKey())
                .fingerprintSha256(null);

        final GitLabMirrorHostKey built = builder.build();

        assertThat(built.fingerprintSha256()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMirrorHostKey value = RemotemirrorsCatalogFixtures.mirrorHostKey();

        assertThat(value.fingerprintSha256()).isEqualTo("SHA256:abcd1234");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMirrorHostKey original = RemotemirrorsCatalogFixtures.mirrorHostKey();

        final GitLabMirrorHostKey rebuilt =
                GitLabMirrorHostKeyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMirrorHostKey.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fingerprintSha256");
    }
}
