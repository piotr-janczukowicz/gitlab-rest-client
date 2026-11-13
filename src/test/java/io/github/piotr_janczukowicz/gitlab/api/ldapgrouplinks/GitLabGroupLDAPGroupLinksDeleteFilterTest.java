package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupLDAPGroupLinksDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCnIsNullable() {
        final GitLabGroupLDAPGroupLinksDeleteFilterBuilder builder =
                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder(
                                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                                        .cn("cn")
                                        .filter("filter")
                                        .build())
                        .cn(null);

        final GitLabGroupLDAPGroupLinksDeleteFilter built = builder.build();

        assertThat(built.cn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabGroupLDAPGroupLinksDeleteFilterBuilder builder =
                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder(
                                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                                        .cn("cn")
                                        .filter("filter")
                                        .build())
                        .filter(null);

        final GitLabGroupLDAPGroupLinksDeleteFilter built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupLDAPGroupLinksDeleteFilter value = GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                .cn("cn")
                .filter("filter")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.cn()).isEqualTo("cn");
            softly.assertThat(value.filter()).isEqualTo("filter");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupLDAPGroupLinksDeleteFilter original = GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                .cn("cn")
                .filter("filter")
                .build();

        final GitLabGroupLDAPGroupLinksDeleteFilter rebuilt =
                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupLDAPGroupLinksDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cn", "filter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupLDAPGroupLinksDeleteFilter empty = GitLabGroupLDAPGroupLinksDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupLDAPGroupLinksDeleteFilter filter = GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                .cn("cn")
                .filter("filter")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("cn", "cn"), Map.entry("filter", "filter"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupLDAPGroupLinksDeleteFilter filter =
                GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder().cn("cn").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("cn", "cn"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupLDAPGroupLinksDeleteFilter filter = GitLabGroupLDAPGroupLinksDeleteFilterBuilder.builder()
                .cn("cn")
                .filter("filter")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
