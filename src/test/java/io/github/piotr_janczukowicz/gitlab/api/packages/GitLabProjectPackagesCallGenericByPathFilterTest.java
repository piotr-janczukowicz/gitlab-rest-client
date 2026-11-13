package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesCallGenericByPathFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabProjectPackagesCallGenericByPathFilterBuilder builder =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder(
                                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                                        .build())
                        .downloadMode(null);

        final GitLabProjectPackagesCallGenericByPathFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesCallGenericByPathFilter value =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                        .build();

        assertThat(value.downloadMode()).isEqualTo(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesCallGenericByPathFilter original =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                        .build();

        final GitLabProjectPackagesCallGenericByPathFilter rebuilt =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesCallGenericByPathFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesCallGenericByPathFilter empty = GitLabProjectPackagesCallGenericByPathFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesCallGenericByPathFilter filter =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesCallGenericByPathFilter filter =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesCallGenericByPathFilter filter =
                GitLabProjectPackagesCallGenericByPathFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesCallGenericByPathDownloadMode.PROXY)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
