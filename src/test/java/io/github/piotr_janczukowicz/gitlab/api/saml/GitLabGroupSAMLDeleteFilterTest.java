package io.github.piotr_janczukowicz.gitlab.api.saml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSAMLDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabGroupSAMLDeleteFilterBuilder builder = GitLabGroupSAMLDeleteFilterBuilder.builder(
                        GitLabGroupSAMLDeleteFilterBuilder.builder()
                                .provider("provider")
                                .build())
                .provider(null);

        final GitLabGroupSAMLDeleteFilter built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupSAMLDeleteFilter value = GitLabGroupSAMLDeleteFilterBuilder.builder()
                .provider("provider")
                .build();

        assertThat(value.provider()).isEqualTo("provider");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupSAMLDeleteFilter original = GitLabGroupSAMLDeleteFilterBuilder.builder()
                .provider("provider")
                .build();

        final GitLabGroupSAMLDeleteFilter rebuilt =
                GitLabGroupSAMLDeleteFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupSAMLDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("provider");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupSAMLDeleteFilter empty = GitLabGroupSAMLDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupSAMLDeleteFilter filter = GitLabGroupSAMLDeleteFilterBuilder.builder()
                .provider("provider")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("provider", "provider"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupSAMLDeleteFilter filter = GitLabGroupSAMLDeleteFilterBuilder.builder()
                .provider("provider")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("provider", "provider"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupSAMLDeleteFilter filter = GitLabGroupSAMLDeleteFilterBuilder.builder()
                .provider("provider")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
