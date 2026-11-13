package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectPackagesAuthorizeGenericByPathStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectPackagesAuthorizeGenericByPathStatus.values())
                .map(GitLabProjectPackagesAuthorizeGenericByPathStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("default", "hidden");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectPackagesAuthorizeGenericByPathStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectPackagesAuthorizeGenericByPathStatus constant) {
        final GitLabProjectPackagesAuthorizeGenericByPathStatus decoded =
                GitLabProjectPackagesAuthorizeGenericByPathStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectPackagesAuthorizeGenericByPathStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectPackagesAuthorizeGenericByPathStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
