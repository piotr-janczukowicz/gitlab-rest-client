package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabPersonalAccessTokenCreateScopesTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabPersonalAccessTokenCreateScopes.values())
                .map(GitLabPersonalAccessTokenCreateScopes::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("k8s_proxy", "self_rotate");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabPersonalAccessTokenCreateScopes.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabPersonalAccessTokenCreateScopes constant) {
        final GitLabPersonalAccessTokenCreateScopes decoded =
                GitLabPersonalAccessTokenCreateScopes.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabPersonalAccessTokenCreateScopes.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabPersonalAccessTokenCreateScopes.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
