package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectResourceGroupUpdateProcessModeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectResourceGroupUpdateProcessMode.values())
                .map(GitLabProjectResourceGroupUpdateProcessMode::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("unordered", "oldest_first", "newest_first", "newest_ready_first");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectResourceGroupUpdateProcessMode.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectResourceGroupUpdateProcessMode constant) {
        final GitLabProjectResourceGroupUpdateProcessMode decoded =
                GitLabProjectResourceGroupUpdateProcessMode.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectResourceGroupUpdateProcessMode.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectResourceGroupUpdateProcessMode.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
