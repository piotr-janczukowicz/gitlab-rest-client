package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceRunnersListAllStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceRunnersListAllStatus.values())
                .map(GitLabInstanceRunnersListAllStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("active", "paused", "online", "offline", "never_contacted", "stale");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceRunnersListAllStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceRunnersListAllStatus constant) {
        final GitLabInstanceRunnersListAllStatus decoded =
                GitLabInstanceRunnersListAllStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceRunnersListAllStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceRunnersListAllStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
