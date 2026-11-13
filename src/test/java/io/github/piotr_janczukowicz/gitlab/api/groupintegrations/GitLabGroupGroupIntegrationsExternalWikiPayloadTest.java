package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsExternalWikiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalWikiUrlIsNullable() {
        final GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload())
                        .externalWikiUrl(null);

        final GitLabGroupGroupIntegrationsExternalWikiPayload built = builder.build();

        assertThat(built.externalWikiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsExternalWikiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsExternalWikiPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.externalWikiUrl()).isEqualTo("external_wiki_url");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsExternalWikiPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsExternalWikiPayload();

        final GitLabGroupGroupIntegrationsExternalWikiPayload rebuilt =
                GitLabGroupGroupIntegrationsExternalWikiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsExternalWikiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externalWikiUrl", "useInheritedSettings");
    }
}
