package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(
                        GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.values())
                .map(GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("unknown_authorization", "rbac", "abac");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType constant) {
        final GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType decoded =
                GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(
                () -> GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabInstanceClustersAddPlatformKubernetesAttributesAuthorizationType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
