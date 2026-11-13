package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsExternalWikiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalWikiUrlIsNullable() {
        final GitLabProjectIntegrationsExternalWikiPayloadBuilder builder =
                GitLabProjectIntegrationsExternalWikiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload())
                        .externalWikiUrl(null);

        final GitLabProjectIntegrationsExternalWikiPayload built = builder.build();

        assertThat(built.externalWikiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsExternalWikiPayloadBuilder builder =
                GitLabProjectIntegrationsExternalWikiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsExternalWikiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsExternalWikiPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.externalWikiUrl()).isEqualTo("external_wiki_url");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsExternalWikiPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsExternalWikiPayload();

        final GitLabProjectIntegrationsExternalWikiPayload rebuilt =
                GitLabProjectIntegrationsExternalWikiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsExternalWikiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externalWikiUrl", "useInheritedSettings");
    }
}
