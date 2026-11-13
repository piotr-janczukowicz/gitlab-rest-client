package io.github.piotr_janczukowicz.gitlab.api.todos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabToDosListTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabToDosListType.values())
                .map(GitLabToDosListType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "Commit",
                        "Issue",
                        "WorkItem",
                        "MergeRequest",
                        "DesignManagement::Design",
                        "AlertManagement::Alert",
                        "Namespace",
                        "Project",
                        "Key",
                        "WikiPage::Meta",
                        "Epic",
                        "Vulnerability",
                        "User",
                        "ComplianceManagement::Projects::ComplianceViolation",
                        "Ai::DuoWorkflows::Workflow");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabToDosListType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabToDosListType constant) {
        final GitLabToDosListType decoded = GitLabToDosListType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabToDosListType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabToDosListType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
