package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesGetPackageFilesDownloadFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder builder =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder(
                                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                                        .build())
                        .downloadMode(null);

        final GitLabProjectPackagesGetPackageFilesDownloadFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter value =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                        .build();

        assertThat(value.downloadMode()).isEqualTo(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter original =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                        .build();

        final GitLabProjectPackagesGetPackageFilesDownloadFilter rebuilt =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectPackagesGetPackageFilesDownloadFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter empty =
                GitLabProjectPackagesGetPackageFilesDownloadFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter filter =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter filter =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesGetPackageFilesDownloadFilter filter =
                GitLabProjectPackagesGetPackageFilesDownloadFilterBuilder.builder()
                        .downloadMode(GitLabProjectPackagesGetPackageFilesDownloadMode.PROXY)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
