package io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOpenSourceLicenseTemplatesGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabOpenSourceLicenseTemplatesGetFilterBuilder builder =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder(
                                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                                        .project("project")
                                        .fullname("fullname")
                                        .build())
                        .project(null);

        final GitLabOpenSourceLicenseTemplatesGetFilter built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullnameIsNullable() {
        final GitLabOpenSourceLicenseTemplatesGetFilterBuilder builder =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder(
                                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                                        .project("project")
                                        .fullname("fullname")
                                        .build())
                        .fullname(null);

        final GitLabOpenSourceLicenseTemplatesGetFilter built = builder.build();

        assertThat(built.fullname()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOpenSourceLicenseTemplatesGetFilter value =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                        .project("project")
                        .fullname("fullname")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.project()).isEqualTo("project");
            softly.assertThat(value.fullname()).isEqualTo("fullname");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOpenSourceLicenseTemplatesGetFilter original =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                        .project("project")
                        .fullname("fullname")
                        .build();

        final GitLabOpenSourceLicenseTemplatesGetFilter rebuilt =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOpenSourceLicenseTemplatesGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("project", "fullname");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabOpenSourceLicenseTemplatesGetFilter empty = GitLabOpenSourceLicenseTemplatesGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabOpenSourceLicenseTemplatesGetFilter filter =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                        .project("project")
                        .fullname("fullname")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("project", "project"), Map.entry("fullname", "fullname"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabOpenSourceLicenseTemplatesGetFilter filter =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                        .project("project")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("project", "project"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabOpenSourceLicenseTemplatesGetFilter filter =
                GitLabOpenSourceLicenseTemplatesGetFilterBuilder.builder()
                        .project("project")
                        .fullname("fullname")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
