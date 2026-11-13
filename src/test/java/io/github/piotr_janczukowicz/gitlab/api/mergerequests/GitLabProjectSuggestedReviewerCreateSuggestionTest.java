package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectSuggestedReviewerCreateSuggestionTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .userId(null);

        final GitLabProjectSuggestedReviewerCreateSuggestion built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReasonIsNullable() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .reason(null);

        final GitLabProjectSuggestedReviewerCreateSuggestion built = builder.build();

        assertThat(built.reason()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenReasonIsTooLong() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .reason("x".repeat(2049));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenReasonHasTheMaximumLength() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .reason("x".repeat(2048));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRuleIdIsNullable() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .approvalRuleId(null);

        final GitLabProjectSuggestedReviewerCreateSuggestion built = builder.build();

        assertThat(built.approvalRuleId()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenApprovalRuleTypeIsNull() {
        final GitLabProjectSuggestedReviewerCreateSuggestionBuilder builder =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion())
                        .approvalRuleType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("approvalRuleType");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectSuggestedReviewerCreateSuggestion value =
                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.reason()).isEqualTo("reason");
            softly.assertThat(value.approvalRuleId()).isEqualTo(1L);
            softly.assertThat(value.approvalRuleType())
                    .isEqualTo(GitLabProjectSuggestedReviewerCreateSuggestionApprovalRuleType.MERGE_REQUEST_RULE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectSuggestedReviewerCreateSuggestion original =
                MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion();

        final GitLabProjectSuggestedReviewerCreateSuggestion rebuilt =
                GitLabProjectSuggestedReviewerCreateSuggestionBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectSuggestedReviewerCreateSuggestion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "reason", "approvalRuleId", "approvalRuleType");
    }
}
