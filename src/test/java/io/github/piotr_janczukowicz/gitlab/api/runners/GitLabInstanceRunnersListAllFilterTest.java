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
class GitLabInstanceRunnersListAllFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .scope(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .type(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .paused(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .status(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .tagList(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionPrefixIsNullable() {
        final GitLabInstanceRunnersListAllFilterBuilder builder = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .versionPrefix(null);

        final GitLabInstanceRunnersListAllFilter built = builder.build();

        assertThat(built.versionPrefix()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersListAllFilter value = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabInstanceRunnersListAllScope.SPECIFIC);
            softly.assertThat(value.type()).isEqualTo(GitLabInstanceRunnersListAllType.INSTANCE_TYPE);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabInstanceRunnersListAllStatus.ACTIVE);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.versionPrefix()).isEqualTo("1.2");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersListAllFilter original = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        final GitLabInstanceRunnersListAllFilter rebuilt =
                GitLabInstanceRunnersListAllFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabInstanceRunnersListAllFilter built = GitLabInstanceRunnersListAllFilterBuilder.builder(
                        GitLabInstanceRunnersListAllFilterBuilder.builder()
                                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
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
        final GitLabInstanceRunnersListAllFilter built = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersListAllFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "type", "paused", "status", "tagList", "versionPrefix");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceRunnersListAllFilter empty = GitLabInstanceRunnersListAllFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceRunnersListAllFilter filter = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
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
        final GitLabInstanceRunnersListAllFilter filter = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "specific"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceRunnersListAllFilter filter = GitLabInstanceRunnersListAllFilterBuilder.builder()
                .scope(GitLabInstanceRunnersListAllScope.SPECIFIC)
                .type(GitLabInstanceRunnersListAllType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabInstanceRunnersListAllStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
