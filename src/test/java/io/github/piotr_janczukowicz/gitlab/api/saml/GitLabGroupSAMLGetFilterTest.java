package io.github.piotr_janczukowicz.gitlab.api.saml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSAMLGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabGroupSAMLGetFilterBuilder builder = GitLabGroupSAMLGetFilterBuilder.builder(
                        GitLabGroupSAMLGetFilterBuilder.builder()
                                .provider("provider")
                                .build())
                .provider(null);

        final GitLabGroupSAMLGetFilter built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupSAMLGetFilter value =
                GitLabGroupSAMLGetFilterBuilder.builder().provider("provider").build();

        assertThat(value.provider()).isEqualTo("provider");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupSAMLGetFilter original =
                GitLabGroupSAMLGetFilterBuilder.builder().provider("provider").build();

        final GitLabGroupSAMLGetFilter rebuilt =
                GitLabGroupSAMLGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupSAMLGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("provider");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupSAMLGetFilter empty = GitLabGroupSAMLGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupSAMLGetFilter filter =
                GitLabGroupSAMLGetFilterBuilder.builder().provider("provider").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("provider", "provider"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupSAMLGetFilter filter =
                GitLabGroupSAMLGetFilterBuilder.builder().provider("provider").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("provider", "provider"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupSAMLGetFilter filter =
                GitLabGroupSAMLGetFilterBuilder.builder().provider("provider").build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
