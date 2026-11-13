package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.values())
                .map(GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("merge_request_rule", "project_rule");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType constant) {
        final GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType decoded =
                GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
