package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsCreateApprovalRuleReportTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsCreateApprovalRuleReportType.values())
                .map(GitLabProjectProjectsCreateApprovalRuleReportType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("code_coverage");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsCreateApprovalRuleReportType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsCreateApprovalRuleReportType constant) {
        final GitLabProjectProjectsCreateApprovalRuleReportType decoded =
                GitLabProjectProjectsCreateApprovalRuleReportType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectsCreateApprovalRuleReportType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsCreateApprovalRuleReportType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
