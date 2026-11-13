package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDataManagementChecksumStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDataManagementChecksumState.values())
                .map(GitLabDataManagementChecksumState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("started", "succeeded", "failed", "disabled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDataManagementChecksumState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabDataManagementChecksumState constant) {
        final GitLabDataManagementChecksumState decoded =
                GitLabDataManagementChecksumState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabDataManagementChecksumState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabDataManagementChecksumState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
