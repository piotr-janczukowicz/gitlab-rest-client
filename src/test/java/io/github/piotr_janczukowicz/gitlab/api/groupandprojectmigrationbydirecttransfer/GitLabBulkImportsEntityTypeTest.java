package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabBulkImportsEntityTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabBulkImportsEntityType.values())
                .filter(constant -> constant != GitLabBulkImportsEntityType.UNRECOGNIZED)
                .map(GitLabBulkImportsEntityType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("group", "project");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabBulkImportsEntityType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabBulkImportsEntityType constant) {
        final GitLabBulkImportsEntityType decoded = GitLabBulkImportsEntityType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabBulkImportsEntityType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabBulkImportsEntityType decoded = GitLabBulkImportsEntityType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabBulkImportsEntityType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabBulkImportsEntityType.values())
                .filter(constant -> constant.wireValue().equals(GitLabBulkImportsEntityType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
