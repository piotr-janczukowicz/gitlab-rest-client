package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupAccessTokensCreateScopesTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupAccessTokensCreateScopes.values())
                .map(GitLabGroupAccessTokensCreateScopes::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "api",
                        "read_api",
                        "create_runner",
                        "manage_runner",
                        "k8s_proxy",
                        "self_rotate",
                        "mcp",
                        "mcp_orbit",
                        "granular",
                        "read_repository",
                        "write_repository",
                        "read_registry",
                        "write_registry",
                        "read_virtual_registry",
                        "write_virtual_registry",
                        "read_observability",
                        "write_observability",
                        "ai_features");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupAccessTokensCreateScopes.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupAccessTokensCreateScopes constant) {
        final GitLabGroupAccessTokensCreateScopes decoded =
                GitLabGroupAccessTokensCreateScopes.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupAccessTokensCreateScopes.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupAccessTokensCreateScopes.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
