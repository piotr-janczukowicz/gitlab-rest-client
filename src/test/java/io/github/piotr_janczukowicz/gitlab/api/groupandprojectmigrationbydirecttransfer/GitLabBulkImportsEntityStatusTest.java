package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBulkImportsEntityStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBulkImportsEntityStatus.values())
                .filter(constant -> constant != GitLabBulkImportsEntityStatus.UNRECOGNIZED)
                .map(GitLabBulkImportsEntityStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created", "started", "finished", "timeout", "failed");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBulkImportsEntityStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabBulkImportsEntityStatus constant) {
        final GitLabBulkImportsEntityStatus decoded = GitLabBulkImportsEntityStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBulkImportsEntityStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabBulkImportsEntityStatus decoded = GitLabBulkImportsEntityStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabBulkImportsEntityStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabBulkImportsEntityStatus.values())
                .filter(constant -> constant.wireValue().equals(GitLabBulkImportsEntityStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
