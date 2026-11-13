package io.github.piotr_janczukowicz.gitlab.api.unleash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUnleashRegisterClientPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenInstanceIdIsNullable() {
        final GitLabUnleashRegisterClientPayloadBuilder builder = GitLabUnleashRegisterClientPayloadBuilder.builder(
                        UnleashCatalogFixtures.unleashRegisterClientPayload())
                .instanceId(null);

        final GitLabUnleashRegisterClientPayload built = builder.build();

        assertThat(built.instanceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAppNameIsNullable() {
        final GitLabUnleashRegisterClientPayloadBuilder builder = GitLabUnleashRegisterClientPayloadBuilder.builder(
                        UnleashCatalogFixtures.unleashRegisterClientPayload())
                .appName(null);

        final GitLabUnleashRegisterClientPayload built = builder.build();

        assertThat(built.appName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUnleashRegisterClientPayload value = UnleashCatalogFixtures.unleashRegisterClientPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.instanceId()).isEqualTo("instance_id");
            softly.assertThat(value.appName()).isEqualTo("app_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUnleashRegisterClientPayload original = UnleashCatalogFixtures.unleashRegisterClientPayload();

        final GitLabUnleashRegisterClientPayload rebuilt =
                GitLabUnleashRegisterClientPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUnleashRegisterClientPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("instanceId", "appName");
    }
}
