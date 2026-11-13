package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(
                        GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.values())
                .map(GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("unknown_authorization", "rbac", "abac");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType constant) {
        final GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType decoded =
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire(
                        constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(
                () -> GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() ->
                GitLabGroupClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
