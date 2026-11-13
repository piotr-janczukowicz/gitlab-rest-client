package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectEnvironmentsUpdateTierTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectEnvironmentsUpdateTier.values())
                .map(GitLabProjectEnvironmentsUpdateTier::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("production", "staging", "testing", "development", "other");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectEnvironmentsUpdateTier.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectEnvironmentsUpdateTier constant) {
        final GitLabProjectEnvironmentsUpdateTier decoded =
                GitLabProjectEnvironmentsUpdateTier.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsUpdateTier.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsUpdateTier.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
