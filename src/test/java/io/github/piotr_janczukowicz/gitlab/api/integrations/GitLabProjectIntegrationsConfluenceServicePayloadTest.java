package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsConfluenceServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenConfluenceUrlIsNullable() {
        final GitLabProjectIntegrationsConfluenceServicePayloadBuilder builder =
                GitLabProjectIntegrationsConfluenceServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload())
                        .confluenceUrl(null);

        final GitLabProjectIntegrationsConfluenceServicePayload built = builder.build();

        assertThat(built.confluenceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsConfluenceServicePayloadBuilder builder =
                GitLabProjectIntegrationsConfluenceServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsConfluenceServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsConfluenceServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.confluenceUrl()).isEqualTo("confluence_url");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsConfluenceServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsConfluenceServicePayload();

        final GitLabProjectIntegrationsConfluenceServicePayload rebuilt =
                GitLabProjectIntegrationsConfluenceServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsConfluenceServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("confluenceUrl", "useInheritedSettings");
    }
}
