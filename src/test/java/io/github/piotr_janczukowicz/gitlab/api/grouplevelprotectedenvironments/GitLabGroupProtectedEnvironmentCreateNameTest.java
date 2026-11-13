package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupProtectedEnvironmentCreateNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupProtectedEnvironmentCreateName.values())
                .map(GitLabGroupProtectedEnvironmentCreateName::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("production", "staging", "testing", "development", "other");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupProtectedEnvironmentCreateName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupProtectedEnvironmentCreateName constant) {
        final GitLabGroupProtectedEnvironmentCreateName decoded =
                GitLabGroupProtectedEnvironmentCreateName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupProtectedEnvironmentCreateName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupProtectedEnvironmentCreateName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
