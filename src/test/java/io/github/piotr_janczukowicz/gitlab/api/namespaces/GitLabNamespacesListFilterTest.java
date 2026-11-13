package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabNamespacesListFilterBuilder builder = GitLabNamespacesListFilterBuilder.builder(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build())
                .search(null);

        final GitLabNamespacesListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnedOnlyIsNullable() {
        final GitLabNamespacesListFilterBuilder builder = GitLabNamespacesListFilterBuilder.builder(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build())
                .ownedOnly(null);

        final GitLabNamespacesListFilter built = builder.build();

        assertThat(built.ownedOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopLevelOnlyIsNullable() {
        final GitLabNamespacesListFilterBuilder builder = GitLabNamespacesListFilterBuilder.builder(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build())
                .topLevelOnly(null);

        final GitLabNamespacesListFilter built = builder.build();

        assertThat(built.topLevelOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathSearchIsNullable() {
        final GitLabNamespacesListFilterBuilder builder = GitLabNamespacesListFilterBuilder.builder(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build())
                .fullPathSearch(null);

        final GitLabNamespacesListFilter built = builder.build();

        assertThat(built.fullPathSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestedHostedPlanIsNullable() {
        final GitLabNamespacesListFilterBuilder builder = GitLabNamespacesListFilterBuilder.builder(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build())
                .requestedHostedPlan(null);

        final GitLabNamespacesListFilter built = builder.build();

        assertThat(built.requestedHostedPlan()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespacesListFilter value = GitLabNamespacesListFilterBuilder.builder()
                .search("search")
                .ownedOnly(true)
                .topLevelOnly(true)
                .fullPathSearch(true)
                .requestedHostedPlan("requested_hosted_plan")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.ownedOnly()).isEqualTo(true);
            softly.assertThat(value.topLevelOnly()).isEqualTo(true);
            softly.assertThat(value.fullPathSearch()).isEqualTo(true);
            softly.assertThat(value.requestedHostedPlan()).isEqualTo("requested_hosted_plan");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespacesListFilter original = GitLabNamespacesListFilterBuilder.builder()
                .search("search")
                .ownedOnly(true)
                .topLevelOnly(true)
                .fullPathSearch(true)
                .requestedHostedPlan("requested_hosted_plan")
                .build();

        final GitLabNamespacesListFilter rebuilt =
                GitLabNamespacesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespacesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("search", "ownedOnly", "topLevelOnly", "fullPathSearch", "requestedHostedPlan");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabNamespacesListFilter empty = GitLabNamespacesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabNamespacesListFilter filter = GitLabNamespacesListFilterBuilder.builder()
                .search("search")
                .ownedOnly(true)
                .topLevelOnly(true)
                .fullPathSearch(true)
                .requestedHostedPlan("requested_hosted_plan")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("search", "search"),
                        Map.entry("owned_only", "true"),
                        Map.entry("top_level_only", "true"),
                        Map.entry("full_path_search", "true"),
                        Map.entry("requested_hosted_plan", "requested_hosted_plan"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabNamespacesListFilter filter =
                GitLabNamespacesListFilterBuilder.builder().search("search").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabNamespacesListFilter filter = GitLabNamespacesListFilterBuilder.builder()
                .search("search")
                .ownedOnly(true)
                .topLevelOnly(true)
                .fullPathSearch(true)
                .requestedHostedPlan("requested_hosted_plan")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
