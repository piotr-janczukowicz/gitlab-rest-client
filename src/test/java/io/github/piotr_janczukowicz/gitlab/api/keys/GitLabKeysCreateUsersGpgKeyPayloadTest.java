package io.github.piotr_janczukowicz.gitlab.api.keys;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabKeysCreateUsersGpgKeyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabKeysCreateUsersGpgKeyPayloadBuilder builder = GitLabKeysCreateUsersGpgKeyPayloadBuilder.builder(
                        KeysCatalogFixtures.keysCreateUsersGpgKeyPayload())
                .key(null);

        final GitLabKeysCreateUsersGpgKeyPayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabKeysCreateUsersGpgKeyPayload value = KeysCatalogFixtures.keysCreateUsersGpgKeyPayload();

        assertThat(value.key()).isEqualTo("key");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabKeysCreateUsersGpgKeyPayload original = KeysCatalogFixtures.keysCreateUsersGpgKeyPayload();

        final GitLabKeysCreateUsersGpgKeyPayload rebuilt =
                GitLabKeysCreateUsersGpgKeyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabKeysCreateUsersGpgKeyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key");
    }
}
