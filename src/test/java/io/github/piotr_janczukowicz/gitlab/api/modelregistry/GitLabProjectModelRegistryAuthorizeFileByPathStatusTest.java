package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectModelRegistryAuthorizeFileByPathStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectModelRegistryAuthorizeFileByPathStatus.values())
                .map(GitLabProjectModelRegistryAuthorizeFileByPathStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("default", "hidden");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectModelRegistryAuthorizeFileByPathStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectModelRegistryAuthorizeFileByPathStatus constant) {
        final GitLabProjectModelRegistryAuthorizeFileByPathStatus decoded =
                GitLabProjectModelRegistryAuthorizeFileByPathStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectModelRegistryAuthorizeFileByPathStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectModelRegistryAuthorizeFileByPathStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
