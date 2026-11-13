package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabMergeTrainsCarStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabMergeTrainsCarStatus.values())
                .filter(constant -> constant != GitLabMergeTrainsCarStatus.UNRECOGNIZED)
                .map(GitLabMergeTrainsCarStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("idle", "stale", "fresh", "merging", "merged", "skip_merged");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabMergeTrainsCarStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabMergeTrainsCarStatus constant) {
        final GitLabMergeTrainsCarStatus decoded = GitLabMergeTrainsCarStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabMergeTrainsCarStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabMergeTrainsCarStatus decoded = GitLabMergeTrainsCarStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabMergeTrainsCarStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabMergeTrainsCarStatus.values())
                .filter(constant -> constant.wireValue().equals(GitLabMergeTrainsCarStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
