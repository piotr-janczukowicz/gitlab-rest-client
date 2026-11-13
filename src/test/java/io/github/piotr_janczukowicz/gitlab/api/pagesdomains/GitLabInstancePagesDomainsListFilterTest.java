package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstancePagesDomainsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabInstancePagesDomainsListFilterBuilder builder = GitLabInstancePagesDomainsListFilterBuilder.builder(
                        GitLabInstancePagesDomainsListFilterBuilder.builder()
                                .domain("domain")
                                .build())
                .domain(null);

        final GitLabInstancePagesDomainsListFilter built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstancePagesDomainsListFilter value = GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build();

        assertThat(value.domain()).isEqualTo("domain");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstancePagesDomainsListFilter original = GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build();

        final GitLabInstancePagesDomainsListFilter rebuilt =
                GitLabInstancePagesDomainsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstancePagesDomainsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("domain");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstancePagesDomainsListFilter empty = GitLabInstancePagesDomainsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstancePagesDomainsListFilter filter = GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("domain", "domain"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstancePagesDomainsListFilter filter = GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("domain", "domain"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstancePagesDomainsListFilter filter = GitLabInstancePagesDomainsListFilterBuilder.builder()
                .domain("domain")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
