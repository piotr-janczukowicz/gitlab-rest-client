package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(
                        GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.values())
                .map(GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName::wireValue)
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
    @EnumSource(value = GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName constant) {
        final GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName decoded =
                GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectConanV2DistributionsAuthorizeV2ConansRevisionsFileName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
