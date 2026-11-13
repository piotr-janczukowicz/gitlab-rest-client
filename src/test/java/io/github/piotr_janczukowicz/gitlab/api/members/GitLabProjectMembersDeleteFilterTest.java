package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMembersDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSkipSubresourcesIsNullable() {
        final GitLabProjectMembersDeleteFilterBuilder builder = GitLabProjectMembersDeleteFilterBuilder.builder(
                        GitLabProjectMembersDeleteFilterBuilder.builder()
                                .skipSubresources(true)
                                .unassignIssuables(true)
                                .build())
                .skipSubresources(null);

        final GitLabProjectMembersDeleteFilter built = builder.build();

        assertThat(built.skipSubresources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnassignIssuablesIsNullable() {
        final GitLabProjectMembersDeleteFilterBuilder builder = GitLabProjectMembersDeleteFilterBuilder.builder(
                        GitLabProjectMembersDeleteFilterBuilder.builder()
                                .skipSubresources(true)
                                .unassignIssuables(true)
                                .build())
                .unassignIssuables(null);

        final GitLabProjectMembersDeleteFilter built = builder.build();

        assertThat(built.unassignIssuables()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMembersDeleteFilter value = GitLabProjectMembersDeleteFilterBuilder.builder()
                .skipSubresources(true)
                .unassignIssuables(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.skipSubresources()).isEqualTo(true);
            softly.assertThat(value.unassignIssuables()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMembersDeleteFilter original = GitLabProjectMembersDeleteFilterBuilder.builder()
                .skipSubresources(true)
                .unassignIssuables(true)
                .build();

        final GitLabProjectMembersDeleteFilter rebuilt =
                GitLabProjectMembersDeleteFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMembersDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("skipSubresources", "unassignIssuables");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMembersDeleteFilter empty = GitLabProjectMembersDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMembersDeleteFilter filter = GitLabProjectMembersDeleteFilterBuilder.builder()
                .skipSubresources(true)
                .unassignIssuables(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("skip_subresources", "true"), Map.entry("unassign_issuables", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMembersDeleteFilter filter = GitLabProjectMembersDeleteFilterBuilder.builder()
                .skipSubresources(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("skip_subresources", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMembersDeleteFilter filter = GitLabProjectMembersDeleteFilterBuilder.builder()
                .skipSubresources(true)
                .unassignIssuables(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
