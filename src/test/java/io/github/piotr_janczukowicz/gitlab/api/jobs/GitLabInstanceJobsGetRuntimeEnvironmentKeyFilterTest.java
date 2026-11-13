package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder builder =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder(
                                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                                        .token("token")
                                        .build())
                        .token(null);

        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter value =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();

        assertThat(value.token()).isEqualTo("token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter original =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();

        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter rebuilt =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter value =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter empty =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter filter =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("token", "token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter filter =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("token", "token"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceJobsGetRuntimeEnvironmentKeyFilter filter =
                GitLabInstanceJobsGetRuntimeEnvironmentKeyFilterBuilder.builder()
                        .token("token")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
