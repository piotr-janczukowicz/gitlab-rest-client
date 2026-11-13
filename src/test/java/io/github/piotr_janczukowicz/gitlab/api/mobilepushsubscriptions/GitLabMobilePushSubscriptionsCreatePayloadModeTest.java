package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabMobilePushSubscriptionsCreatePayloadModeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabMobilePushSubscriptionsCreatePayloadMode.values())
                .map(GitLabMobilePushSubscriptionsCreatePayloadMode::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("full", "id_only");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabMobilePushSubscriptionsCreatePayloadMode.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabMobilePushSubscriptionsCreatePayloadMode constant) {
        final GitLabMobilePushSubscriptionsCreatePayloadMode decoded =
                GitLabMobilePushSubscriptionsCreatePayloadMode.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabMobilePushSubscriptionsCreatePayloadMode.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabMobilePushSubscriptionsCreatePayloadMode.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
