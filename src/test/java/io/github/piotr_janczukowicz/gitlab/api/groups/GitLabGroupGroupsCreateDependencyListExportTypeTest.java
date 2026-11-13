package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsCreateDependencyListExportTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsCreateDependencyListExportType.values())
                .map(GitLabGroupGroupsCreateDependencyListExportType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("json_array", "csv");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsCreateDependencyListExportType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsCreateDependencyListExportType constant) {
        final GitLabGroupGroupsCreateDependencyListExportType decoded =
                GitLabGroupGroupsCreateDependencyListExportType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsCreateDependencyListExportType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsCreateDependencyListExportType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
