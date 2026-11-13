package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupLevelProtectedEnvironmentsGetNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupLevelProtectedEnvironmentsGetName.values())
                .map(GitLabGroupGroupLevelProtectedEnvironmentsGetName::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("production", "staging", "testing", "development", "other");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupLevelProtectedEnvironmentsGetName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupLevelProtectedEnvironmentsGetName constant) {
        final GitLabGroupGroupLevelProtectedEnvironmentsGetName decoded =
                GitLabGroupGroupLevelProtectedEnvironmentsGetName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupLevelProtectedEnvironmentsGetName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupLevelProtectedEnvironmentsGetName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
