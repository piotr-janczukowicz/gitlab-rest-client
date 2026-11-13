package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsListInvitedGroupsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabProjectProjectsListInvitedGroupsFilterBuilder builder =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .relation(null);

        final GitLabProjectProjectsListInvitedGroupsFilter built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectProjectsListInvitedGroupsFilterBuilder builder =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .search(null);

        final GitLabProjectProjectsListInvitedGroupsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinAccessLevelIsNullable() {
        final GitLabProjectProjectsListInvitedGroupsFilterBuilder builder =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .minAccessLevel(null);

        final GitLabProjectProjectsListInvitedGroupsFilter built = builder.build();

        assertThat(built.minAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabProjectProjectsListInvitedGroupsFilterBuilder builder =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .withCustomAttributes(null);

        final GitLabProjectProjectsListInvitedGroupsFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectProjectsListInvitedGroupsFilterBuilder builder =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .customAttributes(null);

        final GitLabProjectProjectsListInvitedGroupsFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsListInvitedGroupsFilter value =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .search("search")
                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.relation())
                    .isEqualTo(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT));
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.minAccessLevel())
                    .isEqualTo(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsListInvitedGroupsFilter original =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .search("search")
                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final GitLabProjectProjectsListInvitedGroupsFilter rebuilt =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenRelationSourceChangesLater() {
        final List<GitLabProjectProjectsListInvitedGroupsRelation> source =
                new ArrayList<>(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT));
        final GitLabProjectProjectsListInvitedGroupsFilter built =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .relation(source)
                        .build();
        source.clear();

        assertThat(built.relation()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRelationIsRead() {
        final GitLabProjectProjectsListInvitedGroupsFilter built =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .search("search")
                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();
        final List<GitLabProjectProjectsListInvitedGroupsRelation> values = built.relation();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsListInvitedGroupsFilter built =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                                        .search("search")
                                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                                        .withCustomAttributes(true)
                                        .customAttributes(Map.of("key", "value"))
                                        .build())
                        .customAttributes(source)
                        .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsListInvitedGroupsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("relation", "search", "minAccessLevel", "withCustomAttributes", "customAttributes");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsListInvitedGroupsFilter empty = GitLabProjectProjectsListInvitedGroupsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsListInvitedGroupsFilter filter =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .search("search")
                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("relation", "direct"),
                        Map.entry("search", "search"),
                        Map.entry("min_access_level", "10"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsListInvitedGroupsFilter filter =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("relation", "direct"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsListInvitedGroupsFilter filter =
                GitLabProjectProjectsListInvitedGroupsFilterBuilder.builder()
                        .relation(List.of(GitLabProjectProjectsListInvitedGroupsRelation.DIRECT))
                        .search("search")
                        .minAccessLevel(GitLabProjectProjectsListInvitedGroupsMinAccessLevel.GUEST)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
