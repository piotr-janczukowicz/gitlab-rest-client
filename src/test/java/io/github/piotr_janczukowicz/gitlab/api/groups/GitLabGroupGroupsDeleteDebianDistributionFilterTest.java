package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsDeleteDebianDistributionFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .suite(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .origin(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .label(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .version(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .description(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .validTimeDurationSeconds(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .components(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabGroupGroupsDeleteDebianDistributionFilterBuilder builder =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .architectures(null);

        final GitLabGroupGroupsDeleteDebianDistributionFilter built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter value =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.suite()).isEqualTo("suite");
            softly.assertThat(value.origin()).isEqualTo("origin");
            softly.assertThat(value.label()).isEqualTo("label");
            softly.assertThat(value.version()).isEqualTo("1.0-1");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.validTimeDurationSeconds()).isEqualTo(1);
            softly.assertThat(value.components()).isEqualTo(List.of("components"));
            softly.assertThat(value.architectures()).isEqualTo(List.of("architectures"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter original =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();

        final GitLabGroupGroupsDeleteDebianDistributionFilter rebuilt =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabGroupGroupsDeleteDebianDistributionFilter built =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .components(source)
                        .build();
        source.clear();

        assertThat(built.components()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenComponentsIsRead() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter built =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();
        final List<String> values = built.components();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenArchitecturesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("architectures"));
        final GitLabGroupGroupsDeleteDebianDistributionFilter built =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder(
                                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .architectures(source)
                        .build();
        source.clear();

        assertThat(built.architectures()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenArchitecturesIsRead() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter built =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();
        final List<String> values = built.architectures();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsDeleteDebianDistributionFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "suite",
                        "origin",
                        "label",
                        "version",
                        "description",
                        "validTimeDurationSeconds",
                        "components",
                        "architectures");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter empty =
                GitLabGroupGroupsDeleteDebianDistributionFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter filter =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("suite", "suite"),
                        Map.entry("origin", "origin"),
                        Map.entry("label", "label"),
                        Map.entry("version", "1.0-1"),
                        Map.entry("description", "description"),
                        Map.entry("valid_time_duration_seconds", "1"),
                        Map.entry("components", "components"),
                        Map.entry("architectures", "architectures"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter filter =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("suite", "suite"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsDeleteDebianDistributionFilter filter =
                GitLabGroupGroupsDeleteDebianDistributionFilterBuilder.builder()
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
