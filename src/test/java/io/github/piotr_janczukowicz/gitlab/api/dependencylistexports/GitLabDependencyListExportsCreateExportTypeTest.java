package io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDependencyListExportsCreateExportTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDependencyListExportsCreateExportType.values())
                .map(GitLabDependencyListExportsCreateExportType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("sbom");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDependencyListExportsCreateExportType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDependencyListExportsCreateExportType constant) {
        final GitLabDependencyListExportsCreateExportType decoded =
                GitLabDependencyListExportsCreateExportType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabDependencyListExportsCreateExportType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDependencyListExportsCreateExportType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
