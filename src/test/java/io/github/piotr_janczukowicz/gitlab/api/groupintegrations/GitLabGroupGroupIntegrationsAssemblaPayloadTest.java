package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsAssemblaPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsAssemblaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubdomainIsNullable() {
        final GitLabGroupGroupIntegrationsAssemblaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload())
                        .subdomain(null);

        final GitLabGroupGroupIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.subdomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsAssemblaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsAssemblaPayloadBuilder builder =
                GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsAssemblaPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsAssemblaPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.subdomain()).isEqualTo("subdomain");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsAssemblaPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload();

        final GitLabGroupGroupIntegrationsAssemblaPayload rebuilt =
                GitLabGroupGroupIntegrationsAssemblaPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsAssemblaPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsAssemblaPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsAssemblaPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "subdomain", "pushEvents", "useInheritedSettings");
    }
}
