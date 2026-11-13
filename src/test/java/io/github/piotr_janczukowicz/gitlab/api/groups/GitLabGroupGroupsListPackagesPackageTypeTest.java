package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListPackagesPackageTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsListPackagesPackageType.values())
                .map(GitLabGroupGroupsListPackagesPackageType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "maven",
                        "npm",
                        "conan",
                        "nuget",
                        "pypi",
                        "composer",
                        "generic",
                        "golang",
                        "debian",
                        "rubygems",
                        "helm",
                        "terraform_module",
                        "rpm",
                        "ml_model",
                        "cargo",
                        "swift");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListPackagesPackageType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsListPackagesPackageType constant) {
        final GitLabGroupGroupsListPackagesPackageType decoded =
                GitLabGroupGroupsListPackagesPackageType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListPackagesPackageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsListPackagesPackageType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
