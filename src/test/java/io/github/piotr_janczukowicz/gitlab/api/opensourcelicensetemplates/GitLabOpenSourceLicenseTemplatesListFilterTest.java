package io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOpenSourceLicenseTemplatesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPopularIsNullable() {
        final GitLabOpenSourceLicenseTemplatesListFilterBuilder builder =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder(
                                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                                        .popular(true)
                                        .build())
                        .popular(null);

        final GitLabOpenSourceLicenseTemplatesListFilter built = builder.build();

        assertThat(built.popular()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOpenSourceLicenseTemplatesListFilter value =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                        .popular(true)
                        .build();

        assertThat(value.popular()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOpenSourceLicenseTemplatesListFilter original =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                        .popular(true)
                        .build();

        final GitLabOpenSourceLicenseTemplatesListFilter rebuilt =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOpenSourceLicenseTemplatesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("popular");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabOpenSourceLicenseTemplatesListFilter empty = GitLabOpenSourceLicenseTemplatesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabOpenSourceLicenseTemplatesListFilter filter =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                        .popular(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("popular", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabOpenSourceLicenseTemplatesListFilter filter =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                        .popular(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("popular", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabOpenSourceLicenseTemplatesListFilter filter =
                GitLabOpenSourceLicenseTemplatesListFilterBuilder.builder()
                        .popular(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
