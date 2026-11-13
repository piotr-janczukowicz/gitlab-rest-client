package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabEpicIssueSeverityTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabEpicIssueSeverity.values())
                .filter(constant -> constant != GitLabEpicIssueSeverity.UNRECOGNIZED)
                .map(GitLabEpicIssueSeverity::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("UNKNOWN", "LOW", "MEDIUM", "HIGH", "CRITICAL");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabEpicIssueSeverity.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabEpicIssueSeverity constant) {
        final GitLabEpicIssueSeverity decoded = GitLabEpicIssueSeverity.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabEpicIssueSeverity.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabEpicIssueSeverity decoded = GitLabEpicIssueSeverity.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabEpicIssueSeverity.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabEpicIssueSeverity.values())
                .filter(constant -> constant.wireValue().equals(GitLabEpicIssueSeverity.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
