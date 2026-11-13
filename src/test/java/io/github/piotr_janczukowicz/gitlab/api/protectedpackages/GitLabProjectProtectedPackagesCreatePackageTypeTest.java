package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedPackagesCreatePackageTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProtectedPackagesCreatePackageType.values())
                .map(GitLabProjectProtectedPackagesCreatePackageType::wireValue)
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
    @EnumSource(value = GitLabProjectProtectedPackagesCreatePackageType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedPackagesCreatePackageType constant) {
        final GitLabProjectProtectedPackagesCreatePackageType decoded =
                GitLabProjectProtectedPackagesCreatePackageType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProtectedPackagesCreatePackageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedPackagesCreatePackageType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
