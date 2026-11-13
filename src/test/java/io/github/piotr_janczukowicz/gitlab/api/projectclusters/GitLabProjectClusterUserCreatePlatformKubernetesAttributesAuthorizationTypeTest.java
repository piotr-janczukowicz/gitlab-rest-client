package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(
                        GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType.values())
                .map(GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("unknown_authorization", "rbac", "abac");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType constant) {
        final GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType decoded =
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire(
                        constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() ->
                GitLabProjectClusterUserCreatePlatformKubernetesAttributesAuthorizationType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
