package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedPackagesUpdatePackageTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProtectedPackagesUpdatePackageType.values())
                .map(GitLabProjectProtectedPackagesUpdatePackageType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "cargo",
                        "conan",
                        "generic",
                        "helm",
                        "maven",
                        "npm",
                        "nuget",
                        "pypi",
                        "rubygems",
                        "terraform_module");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedPackagesUpdatePackageType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedPackagesUpdatePackageType constant) {
        final GitLabProjectProtectedPackagesUpdatePackageType decoded =
                GitLabProjectProtectedPackagesUpdatePackageType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProtectedPackagesUpdatePackageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedPackagesUpdatePackageType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
