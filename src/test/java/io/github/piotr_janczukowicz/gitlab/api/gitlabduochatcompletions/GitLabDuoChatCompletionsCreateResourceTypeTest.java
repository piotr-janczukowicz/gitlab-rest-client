package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoChatCompletionsCreateResourceTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoChatCompletionsCreateResourceType.values())
                .map(GitLabDuoChatCompletionsCreateResourceType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("issue", "epic", "group", "project", "merge_request", "commit", "build", "work_item");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoChatCompletionsCreateResourceType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoChatCompletionsCreateResourceType constant) {
        final GitLabDuoChatCompletionsCreateResourceType decoded =
                GitLabDuoChatCompletionsCreateResourceType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabDuoChatCompletionsCreateResourceType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoChatCompletionsCreateResourceType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
