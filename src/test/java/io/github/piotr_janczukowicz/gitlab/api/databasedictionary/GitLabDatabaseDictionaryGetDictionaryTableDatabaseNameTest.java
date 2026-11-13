package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDatabaseDictionaryGetDictionaryTableDatabaseNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.values())
                .map(GitLabDatabaseDictionaryGetDictionaryTableDatabaseName::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("main", "ci");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDatabaseDictionaryGetDictionaryTableDatabaseName constant) {
        final GitLabDatabaseDictionaryGetDictionaryTableDatabaseName decoded =
                GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
