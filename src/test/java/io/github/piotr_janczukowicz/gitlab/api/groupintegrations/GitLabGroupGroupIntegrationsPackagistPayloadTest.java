package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPackagistPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .server(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.server()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPackagistPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPackagistPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPackagistPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.server()).isEqualTo("server");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsPackagistPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload();

        final GitLabGroupGroupIntegrationsPackagistPayload rebuilt =
                GitLabGroupGroupIntegrationsPackagistPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsPackagistPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPackagistPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsPackagistPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "username",
                        "token",
                        "server",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
