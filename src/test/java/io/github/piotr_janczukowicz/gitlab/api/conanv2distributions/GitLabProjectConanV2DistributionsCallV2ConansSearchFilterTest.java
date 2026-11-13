package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectConanV2DistributionsCallV2ConansSearchFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIgnorecaseIsNullable() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder builder =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder(
                                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                                        .ignorecase(true)
                                        .build())
                        .ignorecase(null);

        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter built = builder.build();

        assertThat(built.ignorecase()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter value =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        assertThat(value.ignorecase()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter original =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter rebuilt =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectConanV2DistributionsCallV2ConansSearchFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ignorecase");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter empty =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter filter =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ignorecase", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter filter =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ignorecase", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectConanV2DistributionsCallV2ConansSearchFilter filter =
                GitLabProjectConanV2DistributionsCallV2ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
