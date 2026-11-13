package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDatabaseMigrationsCreateDatabaseTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDatabaseMigrationsCreateDatabase.values())
                .map(GitLabDatabaseMigrationsCreateDatabase::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("main", "ci", "sec", "mr_diff", "embedding", "geo");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDatabaseMigrationsCreateDatabase.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDatabaseMigrationsCreateDatabase constant) {
        final GitLabDatabaseMigrationsCreateDatabase decoded =
                GitLabDatabaseMigrationsCreateDatabase.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabDatabaseMigrationsCreateDatabase.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabDatabaseMigrationsCreateDatabase.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
