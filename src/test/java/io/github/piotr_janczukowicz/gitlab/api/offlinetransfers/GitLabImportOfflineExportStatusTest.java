package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabImportOfflineExportStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabImportOfflineExportStatus.values())
                .filter(constant -> constant != GitLabImportOfflineExportStatus.UNRECOGNIZED)
                .map(GitLabImportOfflineExportStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created", "started", "finished", "failed");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabImportOfflineExportStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabImportOfflineExportStatus constant) {
        final GitLabImportOfflineExportStatus decoded = GitLabImportOfflineExportStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabImportOfflineExportStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabImportOfflineExportStatus decoded = GitLabImportOfflineExportStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabImportOfflineExportStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabImportOfflineExportStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabImportOfflineExportStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
