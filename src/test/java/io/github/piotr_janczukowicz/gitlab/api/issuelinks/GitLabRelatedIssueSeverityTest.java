package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabRelatedIssueSeverityTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabRelatedIssueSeverity.values())
                .filter(constant -> constant != GitLabRelatedIssueSeverity.UNRECOGNIZED)
                .map(GitLabRelatedIssueSeverity::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("UNKNOWN", "LOW", "MEDIUM", "HIGH", "CRITICAL");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabRelatedIssueSeverity.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabRelatedIssueSeverity constant) {
        final GitLabRelatedIssueSeverity decoded = GitLabRelatedIssueSeverity.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabRelatedIssueSeverity.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabRelatedIssueSeverity decoded = GitLabRelatedIssueSeverity.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabRelatedIssueSeverity.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabRelatedIssueSeverity.values())
                .filter(constant -> constant.wireValue().equals(GitLabRelatedIssueSeverity.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
