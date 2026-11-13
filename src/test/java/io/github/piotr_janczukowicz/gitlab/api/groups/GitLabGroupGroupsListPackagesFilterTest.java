package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListPackagesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenExcludeSubgroupsIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .excludeSubgroups(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.excludeSubgroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .orderBy(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .sort(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageTypeIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .packageType(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.packageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageNameIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .packageName(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.packageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageVersionIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .packageVersion(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.packageVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeVersionlessIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .includeVersionless(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.includeVersionless()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGroupGroupsListPackagesFilterBuilder builder = GitLabGroupGroupsListPackagesFilterBuilder.builder(
                        GitLabGroupGroupsListPackagesFilterBuilder.builder()
                                .excludeSubgroups(true)
                                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                                .packageName("package_name")
                                .packageVersion("package_version")
                                .includeVersionless(true)
                                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                                .build())
                .status(null);

        final GitLabGroupGroupsListPackagesFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListPackagesFilter value = GitLabGroupGroupsListPackagesFilterBuilder.builder()
                .excludeSubgroups(true)
                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.excludeSubgroups()).isEqualTo(true);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT);
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupsListPackagesSort.ASC);
            softly.assertThat(value.packageType()).isEqualTo(GitLabGroupGroupsListPackagesPackageType.MAVEN);
            softly.assertThat(value.packageName()).isEqualTo("package_name");
            softly.assertThat(value.packageVersion()).isEqualTo("package_version");
            softly.assertThat(value.includeVersionless()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabGroupGroupsListPackagesStatus.DEFAULT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListPackagesFilter original = GitLabGroupGroupsListPackagesFilterBuilder.builder()
                .excludeSubgroups(true)
                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                .build();

        final GitLabGroupGroupsListPackagesFilter rebuilt =
                GitLabGroupGroupsListPackagesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListPackagesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "excludeSubgroups",
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
        final GitLabGroupGroupsListPackagesFilter empty = GitLabGroupGroupsListPackagesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListPackagesFilter filter = GitLabGroupGroupsListPackagesFilterBuilder.builder()
                .excludeSubgroups(true)
                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("exclude_subgroups", "true"),
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
        final GitLabGroupGroupsListPackagesFilter filter = GitLabGroupGroupsListPackagesFilterBuilder.builder()
                .excludeSubgroups(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("exclude_subgroups", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListPackagesFilter filter = GitLabGroupGroupsListPackagesFilterBuilder.builder()
                .excludeSubgroups(true)
                .orderBy(GitLabGroupGroupsListPackagesOrderBy.CREATED_AT)
                .sort(GitLabGroupGroupsListPackagesSort.ASC)
                .packageType(GitLabGroupGroupsListPackagesPackageType.MAVEN)
                .packageName("package_name")
                .packageVersion("package_version")
                .includeVersionless(true)
                .status(GitLabGroupGroupsListPackagesStatus.DEFAULT)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
