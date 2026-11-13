package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.values())
                .map(GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created", "started", "finished", "timeout", "failed", "canceled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus constant) {
        final GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus decoded =
                GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
