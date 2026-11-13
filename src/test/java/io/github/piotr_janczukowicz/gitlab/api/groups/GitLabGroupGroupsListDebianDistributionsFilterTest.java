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
class GitLabGroupGroupsListDebianDistributionsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCodenameIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
                                        .suite("suite")
                                        .origin("origin")
                                        .label("label")
                                        .version("1.0-1")
                                        .description("description")
                                        .validTimeDurationSeconds(1)
                                        .components(List.of("components"))
                                        .architectures(List.of("architectures"))
                                        .build())
                        .codename(null);

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.codename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.suite()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOriginIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.origin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidTimeDurationSecondsIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.validTimeDurationSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentsIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.components()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitecturesIsNullable() {
        final GitLabGroupGroupsListDebianDistributionsFilterBuilder builder =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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

        final GitLabGroupGroupsListDebianDistributionsFilter built = builder.build();

        assertThat(built.architectures()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListDebianDistributionsFilter value =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
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
            softly.assertThat(value.codename()).isEqualTo("codename");
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
        final GitLabGroupGroupsListDebianDistributionsFilter original =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
                        .suite("suite")
                        .origin("origin")
                        .label("label")
                        .version("1.0-1")
                        .description("description")
                        .validTimeDurationSeconds(1)
                        .components(List.of("components"))
                        .architectures(List.of("architectures"))
                        .build();

        final GitLabGroupGroupsListDebianDistributionsFilter rebuilt =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenComponentsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("components"));
        final GitLabGroupGroupsListDebianDistributionsFilter built =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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
        final GitLabGroupGroupsListDebianDistributionsFilter built =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
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
        final GitLabGroupGroupsListDebianDistributionsFilter built =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder(
                                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                                        .codename("codename")
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
        final GitLabGroupGroupsListDebianDistributionsFilter built =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
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
        final String[] names = Arrays.stream(GitLabGroupGroupsListDebianDistributionsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "codename",
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
        final GitLabGroupGroupsListDebianDistributionsFilter empty =
                GitLabGroupGroupsListDebianDistributionsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListDebianDistributionsFilter filter =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
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
                        Map.entry("codename", "codename"),
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
        final GitLabGroupGroupsListDebianDistributionsFilter filter =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("codename", "codename"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListDebianDistributionsFilter filter =
                GitLabGroupGroupsListDebianDistributionsFilterBuilder.builder()
                        .codename("codename")
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
