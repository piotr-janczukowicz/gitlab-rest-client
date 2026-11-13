package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBulkImportStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBulkImportStatus.values())
                .filter(constant -> constant != GitLabBulkImportStatus.UNRECOGNIZED)
                .map(GitLabBulkImportStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created", "started", "finished", "timeout", "failed");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBulkImportStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabBulkImportStatus constant) {
        final GitLabBulkImportStatus decoded = GitLabBulkImportStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBulkImportStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabBulkImportStatus decoded = GitLabBulkImportStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabBulkImportStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabBulkImportStatus.values())
                .filter(constant -> constant.wireValue().equals(GitLabBulkImportStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
