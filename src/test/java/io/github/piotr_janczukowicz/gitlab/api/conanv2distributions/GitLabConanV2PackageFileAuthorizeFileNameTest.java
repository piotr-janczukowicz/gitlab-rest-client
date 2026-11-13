package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabConanV2PackageFileAuthorizeFileNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabConanV2PackageFileAuthorizeFileName.values())
                .map(GitLabConanV2PackageFileAuthorizeFileName::wireValue)
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
    @EnumSource(value = GitLabConanV2PackageFileAuthorizeFileName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabConanV2PackageFileAuthorizeFileName constant) {
        final GitLabConanV2PackageFileAuthorizeFileName decoded =
                GitLabConanV2PackageFileAuthorizeFileName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabConanV2PackageFileAuthorizeFileName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabConanV2PackageFileAuthorizeFileName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
