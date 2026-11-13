package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabWorkItemsStatusIconNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabWorkItemsStatusIconName.values())
                .filter(constant -> constant != GitLabWorkItemsStatusIconName.UNRECOGNIZED)
                .map(GitLabWorkItemsStatusIconName::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "status-neutral", "status-waiting", "status-running", "status-success", "status-cancelled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabWorkItemsStatusIconName.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabWorkItemsStatusIconName constant) {
        final GitLabWorkItemsStatusIconName decoded = GitLabWorkItemsStatusIconName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabWorkItemsStatusIconName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabWorkItemsStatusIconName decoded = GitLabWorkItemsStatusIconName.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabWorkItemsStatusIconName.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabWorkItemsStatusIconName.values())
                .filter(constant -> constant.wireValue().equals(GitLabWorkItemsStatusIconName.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
