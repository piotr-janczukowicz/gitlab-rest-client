package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBulkImportsExportStatusStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBulkImportsExportStatusStatus.values())
                .filter(constant -> constant != GitLabBulkImportsExportStatusStatus.UNRECOGNIZED)
                .map(GitLabBulkImportsExportStatusStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("pending", "started", "finished", "failed");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabBulkImportsExportStatusStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabBulkImportsExportStatusStatus constant) {
        final GitLabBulkImportsExportStatusStatus decoded =
                GitLabBulkImportsExportStatusStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBulkImportsExportStatusStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabBulkImportsExportStatusStatus decoded =
                GitLabBulkImportsExportStatusStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabBulkImportsExportStatusStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabBulkImportsExportStatusStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabBulkImportsExportStatusStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
