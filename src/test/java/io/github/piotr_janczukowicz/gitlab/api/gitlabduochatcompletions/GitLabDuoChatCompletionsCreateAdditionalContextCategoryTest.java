package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoChatCompletionsCreateAdditionalContextCategoryTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoChatCompletionsCreateAdditionalContextCategory.values())
                .map(GitLabDuoChatCompletionsCreateAdditionalContextCategory::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "file",
                        "snippet",
                        "merge_request",
                        "issue",
                        "dependency",
                        "local_git",
                        "terminal",
                        "user_rule",
                        "repository",
                        "directory",
                        "agent_user_environment",
                        "attachments");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoChatCompletionsCreateAdditionalContextCategory.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoChatCompletionsCreateAdditionalContextCategory constant) {
        final GitLabDuoChatCompletionsCreateAdditionalContextCategory decoded =
                GitLabDuoChatCompletionsCreateAdditionalContextCategory.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoChatCompletionsCreateAdditionalContextCategory.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoChatCompletionsCreateAdditionalContextCategory.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
