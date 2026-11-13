package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBroadcastMessagesUpdateBroadcastTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBroadcastMessagesUpdateBroadcastType.values())
                .map(GitLabBroadcastMessagesUpdateBroadcastType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("banner", "notification");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBroadcastMessagesUpdateBroadcastType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabBroadcastMessagesUpdateBroadcastType constant) {
        final GitLabBroadcastMessagesUpdateBroadcastType decoded =
                GitLabBroadcastMessagesUpdateBroadcastType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBroadcastMessagesUpdateBroadcastType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabBroadcastMessagesUpdateBroadcastType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
