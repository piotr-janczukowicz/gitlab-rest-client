package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabMobilePushSubscriptionsCreatePlatformTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabMobilePushSubscriptionsCreatePlatform.values())
                .map(GitLabMobilePushSubscriptionsCreatePlatform::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ios", "macos");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabMobilePushSubscriptionsCreatePlatform.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabMobilePushSubscriptionsCreatePlatform constant) {
        final GitLabMobilePushSubscriptionsCreatePlatform decoded =
                GitLabMobilePushSubscriptionsCreatePlatform.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabMobilePushSubscriptionsCreatePlatform.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabMobilePushSubscriptionsCreatePlatform.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
