package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBulkImportsExportBatchStatusStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBulkImportsExportBatchStatusStatus.values())
                .filter(constant -> constant != GitLabBulkImportsExportBatchStatusStatus.UNRECOGNIZED)
                .map(GitLabBulkImportsExportBatchStatusStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("started", "finished", "failed");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabBulkImportsExportBatchStatusStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabBulkImportsExportBatchStatusStatus constant) {
        final GitLabBulkImportsExportBatchStatusStatus decoded =
                GitLabBulkImportsExportBatchStatusStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBulkImportsExportBatchStatusStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabBulkImportsExportBatchStatusStatus decoded =
                GitLabBulkImportsExportBatchStatusStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabBulkImportsExportBatchStatusStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabBulkImportsExportBatchStatusStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabBulkImportsExportBatchStatusStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
