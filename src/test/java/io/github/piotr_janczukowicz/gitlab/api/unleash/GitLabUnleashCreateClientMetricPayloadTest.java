package io.github.piotr_janczukowicz.gitlab.api.unleash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUnleashCreateClientMetricPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenInstanceIdIsNullable() {
        final GitLabUnleashCreateClientMetricPayloadBuilder builder =
                GitLabUnleashCreateClientMetricPayloadBuilder.builder(
                                UnleashCatalogFixtures.unleashCreateClientMetricPayload())
                        .instanceId(null);

        final GitLabUnleashCreateClientMetricPayload built = builder.build();

        assertThat(built.instanceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppNameIsNullable() {
        final GitLabUnleashCreateClientMetricPayloadBuilder builder =
                GitLabUnleashCreateClientMetricPayloadBuilder.builder(
                                UnleashCatalogFixtures.unleashCreateClientMetricPayload())
                        .appName(null);

        final GitLabUnleashCreateClientMetricPayload built = builder.build();

        assertThat(built.appName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUnleashCreateClientMetricPayload value = UnleashCatalogFixtures.unleashCreateClientMetricPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.instanceId()).isEqualTo("instance_id");
            softly.assertThat(value.appName()).isEqualTo("app_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUnleashCreateClientMetricPayload original =
                UnleashCatalogFixtures.unleashCreateClientMetricPayload();

        final GitLabUnleashCreateClientMetricPayload rebuilt =
                GitLabUnleashCreateClientMetricPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUnleashCreateClientMetricPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("instanceId", "appName");
    }
}
