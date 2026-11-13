package io.github.piotr_janczukowicz.gitlab.api.unleash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUnleashCallFeaturesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenInstanceIdIsNullable() {
        final GitLabUnleashCallFeaturesFilterBuilder builder = GitLabUnleashCallFeaturesFilterBuilder.builder(
                        GitLabUnleashCallFeaturesFilterBuilder.builder()
                                .instanceId("instance_id")
                                .appName("app_name")
                                .build())
                .instanceId(null);

        final GitLabUnleashCallFeaturesFilter built = builder.build();

        assertThat(built.instanceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppNameIsNullable() {
        final GitLabUnleashCallFeaturesFilterBuilder builder = GitLabUnleashCallFeaturesFilterBuilder.builder(
                        GitLabUnleashCallFeaturesFilterBuilder.builder()
                                .instanceId("instance_id")
                                .appName("app_name")
                                .build())
                .appName(null);

        final GitLabUnleashCallFeaturesFilter built = builder.build();

        assertThat(built.appName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUnleashCallFeaturesFilter value = GitLabUnleashCallFeaturesFilterBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.instanceId()).isEqualTo("instance_id");
            softly.assertThat(value.appName()).isEqualTo("app_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUnleashCallFeaturesFilter original = GitLabUnleashCallFeaturesFilterBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();

        final GitLabUnleashCallFeaturesFilter rebuilt =
                GitLabUnleashCallFeaturesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUnleashCallFeaturesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("instanceId", "appName");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabUnleashCallFeaturesFilter empty = GitLabUnleashCallFeaturesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabUnleashCallFeaturesFilter filter = GitLabUnleashCallFeaturesFilterBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("instance_id", "instance_id"), Map.entry("app_name", "app_name"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabUnleashCallFeaturesFilter filter = GitLabUnleashCallFeaturesFilterBuilder.builder()
                .instanceId("instance_id")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("instance_id", "instance_id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabUnleashCallFeaturesFilter filter = GitLabUnleashCallFeaturesFilterBuilder.builder()
                .instanceId("instance_id")
                .appName("app_name")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
