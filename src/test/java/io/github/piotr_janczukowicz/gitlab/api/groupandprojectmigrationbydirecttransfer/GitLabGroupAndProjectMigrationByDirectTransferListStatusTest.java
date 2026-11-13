package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferListStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupAndProjectMigrationByDirectTransferListStatus.values())
                .map(GitLabGroupAndProjectMigrationByDirectTransferListStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created", "started", "finished", "timeout", "failed", "canceled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupAndProjectMigrationByDirectTransferListStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupAndProjectMigrationByDirectTransferListStatus constant) {
        final GitLabGroupAndProjectMigrationByDirectTransferListStatus decoded =
                GitLabGroupAndProjectMigrationByDirectTransferListStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupAndProjectMigrationByDirectTransferListStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabGroupAndProjectMigrationByDirectTransferListStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
