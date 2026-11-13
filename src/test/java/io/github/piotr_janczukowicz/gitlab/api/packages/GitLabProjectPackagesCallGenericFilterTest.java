package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesCallGenericFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabProjectPackagesCallGenericFilterBuilder builder =
                GitLabProjectPackagesCallGenericFilterBuilder.builder(
                                GitLabProjectPackagesCallGenericFilterBuilder.builder()
                                        .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                                        .build())
                        .downloadMode(null);

        final GitLabProjectPackagesCallGenericFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesCallGenericFilter value = GitLabProjectPackagesCallGenericFilterBuilder.builder()
                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                .build();

        assertThat(value.downloadMode()).isEqualTo(GitLabProjectPackagesCallGenericDownloadMode.PROXY);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesCallGenericFilter original = GitLabProjectPackagesCallGenericFilterBuilder.builder()
                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                .build();

        final GitLabProjectPackagesCallGenericFilter rebuilt =
                GitLabProjectPackagesCallGenericFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesCallGenericFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesCallGenericFilter empty = GitLabProjectPackagesCallGenericFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesCallGenericFilter filter = GitLabProjectPackagesCallGenericFilterBuilder.builder()
                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesCallGenericFilter filter = GitLabProjectPackagesCallGenericFilterBuilder.builder()
                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesCallGenericFilter filter = GitLabProjectPackagesCallGenericFilterBuilder.builder()
                .downloadMode(GitLabProjectPackagesCallGenericDownloadMode.PROXY)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
