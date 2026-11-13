package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectImportExportCreateProjectUploadHttpMethodTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.values())
                .map(GitLabProjectProjectImportExportCreateProjectUploadHttpMethod::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("PUT", "POST");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectImportExportCreateProjectUploadHttpMethod constant) {
        final GitLabProjectProjectImportExportCreateProjectUploadHttpMethod decoded =
                GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectProjectImportExportCreateProjectUploadHttpMethod.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
