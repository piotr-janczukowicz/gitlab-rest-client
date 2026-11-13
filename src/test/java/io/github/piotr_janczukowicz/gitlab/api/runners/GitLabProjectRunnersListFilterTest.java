package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRunnersListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .scope(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .type(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .paused(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .status(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .tagList(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionPrefixIsNullable() {
        final GitLabProjectRunnersListFilterBuilder builder = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .versionPrefix(null);

        final GitLabProjectRunnersListFilter built = builder.build();

        assertThat(built.versionPrefix()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRunnersListFilter value = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabProjectRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectRunnersListScope.SPECIFIC);
            softly.assertThat(value.type()).isEqualTo(GitLabProjectRunnersListType.INSTANCE_TYPE);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectRunnersListStatus.ACTIVE);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.versionPrefix()).isEqualTo("1.2");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRunnersListFilter original = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabProjectRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        final GitLabProjectRunnersListFilter rebuilt =
                GitLabProjectRunnersListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabProjectRunnersListFilter built = GitLabProjectRunnersListFilterBuilder.builder(
                        GitLabProjectRunnersListFilterBuilder.builder()
                                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabProjectRunnersListStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .tagList(source)
                .build();
        source.clear();

        assertThat(built.tagList()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTagListIsRead() {
        final GitLabProjectRunnersListFilter built = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabProjectRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRunnersListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "type", "paused", "status", "tagList", "versionPrefix");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRunnersListFilter empty = GitLabProjectRunnersListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRunnersListFilter filter = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabProjectRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("scope", "specific"),
                        Map.entry("type", "instance_type"),
                        Map.entry("paused", "true"),
                        Map.entry("status", "active"),
                        Map.entry("tag_list", "tag_list"),
                        Map.entry("version_prefix", "1.2"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRunnersListFilter filter = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "specific"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRunnersListFilter filter = GitLabProjectRunnersListFilterBuilder.builder()
                .scope(GitLabProjectRunnersListScope.SPECIFIC)
                .type(GitLabProjectRunnersListType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabProjectRunnersListStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
