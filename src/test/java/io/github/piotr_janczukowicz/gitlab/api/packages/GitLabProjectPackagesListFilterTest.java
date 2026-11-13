package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .orderBy(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .sort(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageTypeIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .packageType(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.packageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageNameIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .packageName(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.packageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageVersionIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .packageVersion(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.packageVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeVersionlessIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .includeVersionless(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.includeVersionless()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectPackagesListFilterBuilder builder = GitLabProjectPackagesListFilterBuilder.builder(
                        GitLabProjectPackagesListFilterBuilder.builder()
                                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                                .sort(GitLabProjectPackagesListSort.ASC)
                                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabProjectPackagesListStatus.DEFAULT)
                                .build())
                .status(null);

        final GitLabProjectPackagesListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesListFilter value = GitLabProjectPackagesListFilterBuilder.builder()
                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPackagesListSort.ASC)
                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabProjectPackagesListStatus.DEFAULT)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectPackagesListOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectPackagesListSort.ASC);
            softly.assertThat(value.packageType()).isEqualTo(GitLabProjectPackagesListPackageType.MAVEN);
            softly.assertThat(value.packageName()).isEqualTo("package_name");
            softly.assertThat(value.packageVersion()).isEqualTo("package_version");
            softly.assertThat(value.includeVersionless()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectPackagesListStatus.DEFAULT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesListFilter original = GitLabProjectPackagesListFilterBuilder.builder()
                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPackagesListSort.ASC)
                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabProjectPackagesListStatus.DEFAULT)
                .build();

        final GitLabProjectPackagesListFilter rebuilt =
                GitLabProjectPackagesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "orderBy",
                        "sort",
                        "packageType",
                        "packageName",
                        "packageVersion",
                        "includeVersionless",
                        "status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesListFilter empty = GitLabProjectPackagesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesListFilter filter = GitLabProjectPackagesListFilterBuilder.builder()
                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPackagesListSort.ASC)
                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabProjectPackagesListStatus.DEFAULT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "created_at"),
                        Map.entry("sort", "asc"),
                        Map.entry("package_type", "maven"),
                        Map.entry("package_name", "package_name"),
                        Map.entry("package_version", "package_version"),
                        Map.entry("include_versionless", "true"),
                        Map.entry("status", "default"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesListFilter filter = GitLabProjectPackagesListFilterBuilder.builder()
                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "created_at"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesListFilter filter = GitLabProjectPackagesListFilterBuilder.builder()
                .orderBy(GitLabProjectPackagesListOrderBy.CREATED_AT)
                .sort(GitLabProjectPackagesListSort.ASC)
                .packageType(GitLabProjectPackagesListPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabProjectPackagesListStatus.DEFAULT)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
