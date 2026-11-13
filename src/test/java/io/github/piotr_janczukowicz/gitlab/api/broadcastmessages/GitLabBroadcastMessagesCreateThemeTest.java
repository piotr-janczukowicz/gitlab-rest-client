package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBroadcastMessagesCreateThemeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBroadcastMessagesCreateTheme.values())
                .map(GitLabBroadcastMessagesCreateTheme::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "indigo",
                        "light-indigo",
                        "blue",
                        "light-blue",
                        "green",
                        "light-green",
                        "red",
                        "light-red",
                        "dark",
                        "light");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBroadcastMessagesCreateTheme.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabBroadcastMessagesCreateTheme constant) {
        final GitLabBroadcastMessagesCreateTheme decoded =
                GitLabBroadcastMessagesCreateTheme.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBroadcastMessagesCreateTheme.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabBroadcastMessagesCreateTheme.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
