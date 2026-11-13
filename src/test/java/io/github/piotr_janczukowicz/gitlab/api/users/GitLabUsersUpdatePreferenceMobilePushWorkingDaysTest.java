package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersUpdatePreferenceMobilePushWorkingDaysTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersUpdatePreferenceMobilePushWorkingDays.values())
                .map(GitLabUsersUpdatePreferenceMobilePushWorkingDays::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersUpdatePreferenceMobilePushWorkingDays.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabUsersUpdatePreferenceMobilePushWorkingDays constant) {
        final GitLabUsersUpdatePreferenceMobilePushWorkingDays decoded =
                GitLabUsersUpdatePreferenceMobilePushWorkingDays.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersUpdatePreferenceMobilePushWorkingDays.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabUsersUpdatePreferenceMobilePushWorkingDays.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
