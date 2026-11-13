package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDependenciesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageManagerIsNullable() {
        final GitLabProjectDependenciesListFilterBuilder builder = GitLabProjectDependenciesListFilterBuilder.builder(
                        GitLabProjectDependenciesListFilterBuilder.builder()
                                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                                .build())
                .packageManager(null);

        final GitLabProjectDependenciesListFilter built = builder.build();

        assertThat(built.packageManager()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDependenciesListFilter value = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();

        assertThat(value.packageManager()).isEqualTo(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDependenciesListFilter original = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();

        final GitLabProjectDependenciesListFilter rebuilt =
                GitLabProjectDependenciesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenPackageManagerSourceChangesLater() {
        final List<GitLabProjectDependenciesListPackageManager> source =
                new ArrayList<>(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER));
        final GitLabProjectDependenciesListFilter built = GitLabProjectDependenciesListFilterBuilder.builder(
                        GitLabProjectDependenciesListFilterBuilder.builder()
                                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                                .build())
                .packageManager(source)
                .build();
        source.clear();

        assertThat(built.packageManager()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenPackageManagerIsRead() {
        final GitLabProjectDependenciesListFilter built = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();
        final List<GitLabProjectDependenciesListPackageManager> values = built.packageManager();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDependenciesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("packageManager");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectDependenciesListFilter empty = GitLabProjectDependenciesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectDependenciesListFilter filter = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("package_manager", "bundler"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectDependenciesListFilter filter = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("package_manager", "bundler"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectDependenciesListFilter filter = GitLabProjectDependenciesListFilterBuilder.builder()
                .packageManager(List.of(GitLabProjectDependenciesListPackageManager.BUNDLER))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
