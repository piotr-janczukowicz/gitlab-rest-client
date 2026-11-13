package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesGetChangelogFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFromValueIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .fromValue(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.fromValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .to(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.to()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDateIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .date(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.date()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTrailerIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .trailer(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.trailer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigFileIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .configFile(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.configFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigFileRefIsNullable() {
        final GitLabProjectRepositoriesGetChangelogFilterBuilder builder =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(
                                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                                        .fromValue("from")
                                        .to("to")
                                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                                        .trailer("trailer")
                                        .configFile("config_file")
                                        .configFileRef("config_file_ref")
                                        .build())
                        .configFileRef(null);

        final GitLabProjectRepositoriesGetChangelogFilter built = builder.build();

        assertThat(built.configFileRef()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesGetChangelogFilter value =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                        .fromValue("from")
                        .to("to")
                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                        .trailer("trailer")
                        .configFile("config_file")
                        .configFileRef("config_file_ref")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.fromValue()).isEqualTo("from");
            softly.assertThat(value.to()).isEqualTo("to");
            softly.assertThat(value.date()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.trailer()).isEqualTo("trailer");
            softly.assertThat(value.configFile()).isEqualTo("config_file");
            softly.assertThat(value.configFileRef()).isEqualTo("config_file_ref");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesGetChangelogFilter original =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                        .fromValue("from")
                        .to("to")
                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                        .trailer("trailer")
                        .configFile("config_file")
                        .configFileRef("config_file_ref")
                        .build();

        final GitLabProjectRepositoriesGetChangelogFilter rebuilt =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesGetChangelogFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fromValue", "to", "date", "trailer", "configFile", "configFileRef");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesGetChangelogFilter empty = GitLabProjectRepositoriesGetChangelogFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesGetChangelogFilter filter =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                        .fromValue("from")
                        .to("to")
                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                        .trailer("trailer")
                        .configFile("config_file")
                        .configFileRef("config_file_ref")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("from", "from"),
                        Map.entry("to", "to"),
                        Map.entry("date", "2026-01-01T00:00:00Z"),
                        Map.entry("trailer", "trailer"),
                        Map.entry("config_file", "config_file"),
                        Map.entry("config_file_ref", "config_file_ref"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesGetChangelogFilter filter =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                        .fromValue("from")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("from", "from"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesGetChangelogFilter filter =
                GitLabProjectRepositoriesGetChangelogFilterBuilder.builder()
                        .fromValue("from")
                        .to("to")
                        .date(Instant.parse("2026-01-01T00:00:00Z"))
                        .trailer("trailer")
                        .configFile("config_file")
                        .configFileRef("config_file_ref")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
