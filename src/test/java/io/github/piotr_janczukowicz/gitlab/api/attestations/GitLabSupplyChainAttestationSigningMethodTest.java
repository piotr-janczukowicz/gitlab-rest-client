package io.github.piotr_janczukowicz.gitlab.api.attestations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSupplyChainAttestationSigningMethodTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabSupplyChainAttestationSigningMethod.values())
                .filter(constant -> constant != GitLabSupplyChainAttestationSigningMethod.UNRECOGNIZED)
                .map(GitLabSupplyChainAttestationSigningMethod::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("sigstore", "local_ca");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabSupplyChainAttestationSigningMethod.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSupplyChainAttestationSigningMethod constant) {
        final GitLabSupplyChainAttestationSigningMethod decoded =
                GitLabSupplyChainAttestationSigningMethod.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabSupplyChainAttestationSigningMethod.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabSupplyChainAttestationSigningMethod decoded =
                GitLabSupplyChainAttestationSigningMethod.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabSupplyChainAttestationSigningMethod.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabSupplyChainAttestationSigningMethod.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabSupplyChainAttestationSigningMethod.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
