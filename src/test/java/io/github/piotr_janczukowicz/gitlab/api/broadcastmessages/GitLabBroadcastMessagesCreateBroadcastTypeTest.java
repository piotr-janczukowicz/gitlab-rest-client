package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBroadcastMessagesCreateBroadcastTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBroadcastMessagesCreateBroadcastType.values())
                .map(GitLabBroadcastMessagesCreateBroadcastType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("banner", "notification");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBroadcastMessagesCreateBroadcastType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabBroadcastMessagesCreateBroadcastType constant) {
        final GitLabBroadcastMessagesCreateBroadcastType decoded =
                GitLabBroadcastMessagesCreateBroadcastType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBroadcastMessagesCreateBroadcastType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabBroadcastMessagesCreateBroadcastType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
