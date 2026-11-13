package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDeployTokensCreateScopesTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDeployTokensCreateScopes.values())
                .map(GitLabProjectDeployTokensCreateScopes::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "read_repository",
                        "read_registry",
                        "write_registry",
                        "read_package_registry",
                        "write_package_registry",
                        "read_virtual_registry",
                        "write_virtual_registry");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDeployTokensCreateScopes.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDeployTokensCreateScopes constant) {
        final GitLabProjectDeployTokensCreateScopes decoded =
                GitLabProjectDeployTokensCreateScopes.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeployTokensCreateScopes.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeployTokensCreateScopes.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
