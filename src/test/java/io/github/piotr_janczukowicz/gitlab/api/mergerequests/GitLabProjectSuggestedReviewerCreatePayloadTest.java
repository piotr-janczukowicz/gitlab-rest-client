package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectSuggestedReviewerCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSuggestionsIsNullable() {
        final GitLabProjectSuggestedReviewerCreatePayloadBuilder builder =
                GitLabProjectSuggestedReviewerCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload())
                        .suggestions(null);

        final GitLabProjectSuggestedReviewerCreatePayload built = builder.build();

        assertThat(built.suggestions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectSuggestedReviewerCreatePayload value =
                MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload();

        assertThat(value.suggestions())
                .isEqualTo(List.of(MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion()));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectSuggestedReviewerCreatePayload original =
                MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload();

        final GitLabProjectSuggestedReviewerCreatePayload rebuilt =
                GitLabProjectSuggestedReviewerCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSuggestionsSourceChangesLater() {
        final List<GitLabProjectSuggestedReviewerCreateSuggestion> source =
                new ArrayList<>(List.of(MergerequestsCatalogFixtures.projectSuggestedReviewerCreateSuggestion()));
        final GitLabProjectSuggestedReviewerCreatePayload built =
                GitLabProjectSuggestedReviewerCreatePayloadBuilder.builder(
                                MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload())
                        .suggestions(source)
                        .build();
        source.clear();

        assertThat(built.suggestions()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSuggestionsIsRead() {
        final GitLabProjectSuggestedReviewerCreatePayload built =
                MergerequestsCatalogFixtures.projectSuggestedReviewerCreatePayload();
        final List<GitLabProjectSuggestedReviewerCreateSuggestion> values = built.suggestions();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectSuggestedReviewerCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("suggestions");
    }
}
