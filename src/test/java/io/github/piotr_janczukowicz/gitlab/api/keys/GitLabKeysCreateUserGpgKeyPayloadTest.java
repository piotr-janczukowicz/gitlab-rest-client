package io.github.piotr_janczukowicz.gitlab.api.keys;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabKeysCreateUserGpgKeyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabKeysCreateUserGpgKeyPayloadBuilder builder = GitLabKeysCreateUserGpgKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUserGpgKeyPayload())
                .key(null);

        final GitLabKeysCreateUserGpgKeyPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabKeysCreateUserGpgKeyPayload value = KeysCatalogFixtures.keysCreateUserGpgKeyPayload();

        assertThat(value.key()).isEqualTo("key");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabKeysCreateUserGpgKeyPayload original = KeysCatalogFixtures.keysCreateUserGpgKeyPayload();

        final GitLabKeysCreateUserGpgKeyPayload rebuilt =
                GitLabKeysCreateUserGpgKeyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabKeysCreateUserGpgKeyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key");
    }
}
