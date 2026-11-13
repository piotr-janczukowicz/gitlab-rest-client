package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetApprovalSettingsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectProjectsGetApprovalSettingsFilterBuilder builder =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder(
                                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                                        .targetBranch("target_branch")
                                        .build())
                        .targetBranch(null);

        final GitLabProjectProjectsGetApprovalSettingsFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetApprovalSettingsFilter value =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                        .targetBranch("target_branch")
                        .build();

        assertThat(value.targetBranch()).isEqualTo("target_branch");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetApprovalSettingsFilter original =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                        .targetBranch("target_branch")
                        .build();

        final GitLabProjectProjectsGetApprovalSettingsFilter rebuilt =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsGetApprovalSettingsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetBranch");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetApprovalSettingsFilter empty =
                GitLabProjectProjectsGetApprovalSettingsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetApprovalSettingsFilter filter =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                        .targetBranch("target_branch")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("target_branch", "target_branch"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetApprovalSettingsFilter filter =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                        .targetBranch("target_branch")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("target_branch", "target_branch"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetApprovalSettingsFilter filter =
                GitLabProjectProjectsGetApprovalSettingsFilterBuilder.builder()
                        .targetBranch("target_branch")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
