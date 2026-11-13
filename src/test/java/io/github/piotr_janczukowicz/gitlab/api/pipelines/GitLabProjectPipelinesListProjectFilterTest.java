package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesListProjectFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .scope(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .status(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .ref(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .sha(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenYamlErrorsIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .yamlErrors(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.yamlErrors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .username(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .updatedBefore(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .updatedAfter(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .createdBefore(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .createdAfter(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .orderBy(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .sort(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .source(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectPipelinesListProjectFilterBuilder builder =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(
                                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                                        .ref("ref")
                                        .sha("sha")
                                        .yamlErrors(true)
                                        .username("username")
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                                        .name("name")
                                        .build())
                        .name(null);

        final GitLabProjectPipelinesListProjectFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesListProjectFilter value = GitLabProjectPipelinesListProjectFilterBuilder.builder()
                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                .ref("ref")
                .sha("sha")
                .yamlErrors(true)
                .username("username")
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                .sort(GitLabProjectPipelinesListProjectSort.ASC)
                .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                .name("name")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectPipelinesListProjectScope.RUNNING);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectPipelinesListProjectStatus.CREATED);
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.yamlErrors()).isEqualTo(true);
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectPipelinesListProjectOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectPipelinesListProjectSort.ASC);
            softly.assertThat(value.source()).isEqualTo(GitLabProjectPipelinesListProjectSource.UNKNOWN);
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesListProjectFilter original =
                GitLabProjectPipelinesListProjectFilterBuilder.builder()
                        .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                        .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                        .ref("ref")
                        .sha("sha")
                        .yamlErrors(true)
                        .username("username")
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                        .sort(GitLabProjectPipelinesListProjectSort.ASC)
                        .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                        .name("name")
                        .build();

        final GitLabProjectPipelinesListProjectFilter rebuilt =
                GitLabProjectPipelinesListProjectFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesListProjectFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "scope",
                        "status",
                        "ref",
                        "sha",
                        "yamlErrors",
                        "username",
                        "updatedBefore",
                        "updatedAfter",
                        "createdBefore",
                        "createdAfter",
                        "orderBy",
                        "sort",
                        "source",
                        "name");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelinesListProjectFilter empty = GitLabProjectPipelinesListProjectFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelinesListProjectFilter filter = GitLabProjectPipelinesListProjectFilterBuilder.builder()
                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                .ref("ref")
                .sha("sha")
                .yamlErrors(true)
                .username("username")
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                .sort(GitLabProjectPipelinesListProjectSort.ASC)
                .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                .name("name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("scope", "running"),
                        Map.entry("status", "created"),
                        Map.entry("ref", "ref"),
                        Map.entry("sha", "sha"),
                        Map.entry("yaml_errors", "true"),
                        Map.entry("username", "username"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"),
                        Map.entry("source", "unknown"),
                        Map.entry("name", "name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelinesListProjectFilter filter = GitLabProjectPipelinesListProjectFilterBuilder.builder()
                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "running"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelinesListProjectFilter filter = GitLabProjectPipelinesListProjectFilterBuilder.builder()
                .scope(GitLabProjectPipelinesListProjectScope.RUNNING)
                .status(GitLabProjectPipelinesListProjectStatus.CREATED)
                .ref("ref")
                .sha("sha")
                .yamlErrors(true)
                .username("username")
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .orderBy(GitLabProjectPipelinesListProjectOrderBy.ID)
                .sort(GitLabProjectPipelinesListProjectSort.ASC)
                .source(GitLabProjectPipelinesListProjectSource.UNKNOWN)
                .name("name")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
