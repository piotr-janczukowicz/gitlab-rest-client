package io.github.piotr_janczukowicz.gitlab.api.groups;

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
class GitLabGroupGroupsListRunnersFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabGroupGroupsListRunnersFilterBuilder builder = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .type(null);

        final GitLabGroupGroupsListRunnersFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPausedIsNullable() {
        final GitLabGroupGroupsListRunnersFilterBuilder builder = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .paused(null);

        final GitLabGroupGroupsListRunnersFilter built = builder.build();

        assertThat(built.paused()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabGroupGroupsListRunnersFilterBuilder builder = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .status(null);

        final GitLabGroupGroupsListRunnersFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabGroupGroupsListRunnersFilterBuilder builder = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .tagList(null);

        final GitLabGroupGroupsListRunnersFilter built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionPrefixIsNullable() {
        final GitLabGroupGroupsListRunnersFilterBuilder builder = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                                .tagList(List.of("tag_list"))
                                .versionPrefix("1.2")
                                .build())
                .versionPrefix(null);

        final GitLabGroupGroupsListRunnersFilter built = builder.build();

        assertThat(built.versionPrefix()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListRunnersFilter value = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.type()).isEqualTo(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE);
            softly.assertThat(value.paused()).isEqualTo(true);
            softly.assertThat(value.status()).isEqualTo(GitLabGroupGroupsListRunnersStatus.ACTIVE);
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag_list"));
            softly.assertThat(value.versionPrefix()).isEqualTo("1.2");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListRunnersFilter original = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        final GitLabGroupGroupsListRunnersFilter rebuilt =
                GitLabGroupGroupsListRunnersFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTagListSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tag_list"));
        final GitLabGroupGroupsListRunnersFilter built = GitLabGroupGroupsListRunnersFilterBuilder.builder(
                        GitLabGroupGroupsListRunnersFilterBuilder.builder()
                                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                                .paused(true)
                                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
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
        final GitLabGroupGroupsListRunnersFilter built = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final List<String> values = built.tagList();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListRunnersFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type", "paused", "status", "tagList", "versionPrefix");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListRunnersFilter empty = GitLabGroupGroupsListRunnersFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListRunnersFilter filter = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("type", "instance_type"),
                        Map.entry("paused", "true"),
                        Map.entry("status", "active"),
                        Map.entry("tag_list", "tag_list"),
                        Map.entry("version_prefix", "1.2"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListRunnersFilter filter = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("type", "instance_type"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListRunnersFilter filter = GitLabGroupGroupsListRunnersFilterBuilder.builder()
                .type(GitLabGroupGroupsListRunnersType.INSTANCE_TYPE)
                .paused(true)
                .status(GitLabGroupGroupsListRunnersStatus.ACTIVE)
                .tagList(List.of("tag_list"))
                .versionPrefix("1.2")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
