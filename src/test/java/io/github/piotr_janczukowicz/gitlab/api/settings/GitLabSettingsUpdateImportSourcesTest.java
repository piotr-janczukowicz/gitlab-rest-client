package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateImportSourcesTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabSettingsUpdateImportSources.values())
                .map(GitLabSettingsUpdateImportSources::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "github",
                        "bitbucket",
                        "bitbucket_server",
                        "fogbugz",
                        "git",
                        "gitlab_project",
                        "gitea",
                        "manifest");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateImportSources.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabSettingsUpdateImportSources constant) {
        final GitLabSettingsUpdateImportSources decoded =
                GitLabSettingsUpdateImportSources.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateImportSources.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateImportSources.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
