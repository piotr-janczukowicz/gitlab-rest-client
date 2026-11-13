package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabIssueSeverityTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabIssueSeverity.values())
                .filter(constant -> constant != GitLabIssueSeverity.UNRECOGNIZED)
                .map(GitLabIssueSeverity::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("UNKNOWN", "LOW", "MEDIUM", "HIGH", "CRITICAL");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabIssueSeverity.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabIssueSeverity constant) {
        final GitLabIssueSeverity decoded = GitLabIssueSeverity.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabIssueSeverity.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabIssueSeverity decoded = GitLabIssueSeverity.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabIssueSeverity.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabIssueSeverity.values())
                .filter(constant -> constant.wireValue().equals(GitLabIssueSeverity.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
