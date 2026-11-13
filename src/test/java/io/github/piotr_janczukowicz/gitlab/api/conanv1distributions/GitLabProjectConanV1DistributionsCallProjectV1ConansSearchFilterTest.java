package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenIgnorecaseIsNullable() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder builder =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder(
                                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                                        .ignorecase(true)
                                        .build())
                        .ignorecase(null);

        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter built = builder.build();

        assertThat(built.ignorecase()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter value =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        assertThat(value.ignorecase()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter original =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter rebuilt =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ignorecase");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter empty =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter filter =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ignorecase", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter filter =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ignorecase", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilter filter =
                GitLabProjectConanV1DistributionsCallProjectV1ConansSearchFilterBuilder.builder()
                        .ignorecase(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
