package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupEnterpriseUsersDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenHardDeleteIsNullable() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                                        .hardDelete(true)
                                        .build())
                        .hardDelete(null);

        final GitLabGroupGroupEnterpriseUsersDeleteFilter built = builder.build();

        assertThat(built.hardDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter value =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        assertThat(value.hardDelete()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter original =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final GitLabGroupGroupEnterpriseUsersDeleteFilter rebuilt =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupEnterpriseUsersDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("hardDelete");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter empty = GitLabGroupGroupEnterpriseUsersDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter filter =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("hard_delete", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter filter =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("hard_delete", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupEnterpriseUsersDeleteFilter filter =
                GitLabGroupGroupEnterpriseUsersDeleteFilterBuilder.builder()
                        .hardDelete(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
