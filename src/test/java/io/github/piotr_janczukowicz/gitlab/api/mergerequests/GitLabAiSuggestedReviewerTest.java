package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiSuggestedReviewerTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabAiSuggestedReviewerBuilder builder = GitLabAiSuggestedReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.aiSuggestedReviewer())
                .user(null);

        final GitLabAiSuggestedReviewer built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReasonIsNullable() {
        final GitLabAiSuggestedReviewerBuilder builder = GitLabAiSuggestedReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.aiSuggestedReviewer())
                .reason(null);

        final GitLabAiSuggestedReviewer built = builder.build();

        assertThat(built.reason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalRuleIsNullable() {
        final GitLabAiSuggestedReviewerBuilder builder = GitLabAiSuggestedReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.aiSuggestedReviewer())
                .approvalRule(null);

        final GitLabAiSuggestedReviewer built = builder.build();

        assertThat(built.approvalRule()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiSuggestedReviewerBuilder builder = GitLabAiSuggestedReviewerBuilder.builder(
                        MergerequestsCatalogFixtures.aiSuggestedReviewer())
                .createdAt(null);

        final GitLabAiSuggestedReviewer built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiSuggestedReviewer value = MergerequestsCatalogFixtures.aiSuggestedReviewer();

        assertSoftly(softly -> {
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.reason()).isEqualTo("Authored most of the changed files.");
            softly.assertThat(value.approvalRule()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiSuggestedReviewer original = MergerequestsCatalogFixtures.aiSuggestedReviewer();

        final GitLabAiSuggestedReviewer rebuilt =
                GitLabAiSuggestedReviewerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiSuggestedReviewer.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("user", "reason", "approvalRule", "createdAt");
    }
}
