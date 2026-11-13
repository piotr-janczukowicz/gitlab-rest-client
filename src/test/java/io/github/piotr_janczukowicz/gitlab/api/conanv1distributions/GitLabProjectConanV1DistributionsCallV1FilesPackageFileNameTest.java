package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectConanV1DistributionsCallV1FilesPackageFileNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.values())
                .map(GitLabProjectConanV1DistributionsCallV1FilesPackageFileName::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "conanfile.py",
                        "conanmanifest.txt",
                        "conan_sources.tgz",
                        "conan_export.tgz",
                        "conaninfo.txt",
                        "conan_package.tgz");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectConanV1DistributionsCallV1FilesPackageFileName constant) {
        final GitLabProjectConanV1DistributionsCallV1FilesPackageFileName decoded =
                GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectConanV1DistributionsCallV1FilesPackageFileName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
