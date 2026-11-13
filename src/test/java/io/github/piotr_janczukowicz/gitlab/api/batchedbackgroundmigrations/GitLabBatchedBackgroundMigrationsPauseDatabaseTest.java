package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBatchedBackgroundMigrationsPauseDatabaseTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBatchedBackgroundMigrationsPauseDatabase.values())
                .map(GitLabBatchedBackgroundMigrationsPauseDatabase::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("main", "ci", "sec", "mr_diff", "embedding", "geo");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBatchedBackgroundMigrationsPauseDatabase.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabBatchedBackgroundMigrationsPauseDatabase constant) {
        final GitLabBatchedBackgroundMigrationsPauseDatabase decoded =
                GitLabBatchedBackgroundMigrationsPauseDatabase.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBatchedBackgroundMigrationsPauseDatabase.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabBatchedBackgroundMigrationsPauseDatabase.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
