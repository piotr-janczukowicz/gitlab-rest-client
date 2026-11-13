package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersUpdatePreferenceEmojiSkinToneTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersUpdatePreferenceEmojiSkinTone.values())
                .map(GitLabUsersUpdatePreferenceEmojiSkinTone::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("default", "light", "medium_light", "medium", "medium_dark", "dark");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersUpdatePreferenceEmojiSkinTone.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabUsersUpdatePreferenceEmojiSkinTone constant) {
        final GitLabUsersUpdatePreferenceEmojiSkinTone decoded =
                GitLabUsersUpdatePreferenceEmojiSkinTone.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersUpdatePreferenceEmojiSkinTone.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabUsersUpdatePreferenceEmojiSkinTone.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
