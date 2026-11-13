package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsSquashTmPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupIntegrationsSquashTmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload())
                        .url(null);

        final GitLabGroupGroupIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsSquashTmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSquashTmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload())
                        .issuesEvents(null);

        final GitLabGroupGroupIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.issuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIssuesEventsIsNullable() {
        final GitLabGroupGroupIntegrationsSquashTmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload())
                        .confidentialIssuesEvents(null);

        final GitLabGroupGroupIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.confidentialIssuesEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsSquashTmPayloadBuilder builder =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsSquashTmPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsSquashTmPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.issuesEvents()).isEqualTo(true);
            softly.assertThat(value.confidentialIssuesEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsSquashTmPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload();

        final GitLabGroupGroupIntegrationsSquashTmPayload rebuilt =
                GitLabGroupGroupIntegrationsSquashTmPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsSquashTmPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsSquashTmPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsSquashTmPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("url", "token", "issuesEvents", "confidentialIssuesEvents", "useInheritedSettings");
    }
}
