package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsCreateSlackEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .token(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTeamIdIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .teamId(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.teamId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApiAppIdIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .apiAppId(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.apiAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .event(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.event()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .type(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventIdIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .eventId(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.eventId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventTimeIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .eventTime(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.eventTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthedUsersIsNullable() {
        final GitLabProjectIntegrationsCreateSlackEventPayloadBuilder builder =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .authedUsers(null);

        final GitLabProjectIntegrationsCreateSlackEventPayload built = builder.build();

        assertThat(built.authedUsers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsCreateSlackEventPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.teamId()).isEqualTo("team_id");
            softly.assertThat(value.apiAppId()).isEqualTo("api_app_id");
            softly.assertThat(value.event()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.eventId()).isEqualTo("event_id");
            softly.assertThat(value.eventTime()).isEqualTo(1);
            softly.assertThat(value.authedUsers()).isEqualTo(List.of("authed_users"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsCreateSlackEventPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload();

        final GitLabProjectIntegrationsCreateSlackEventPayload rebuilt =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenEventSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectIntegrationsCreateSlackEventPayload built =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .event(source)
                        .build();
        source.clear();

        assertThat(built.event()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenAuthedUsersSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("authed_users"));
        final GitLabProjectIntegrationsCreateSlackEventPayload built =
                GitLabProjectIntegrationsCreateSlackEventPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload())
                        .authedUsers(source)
                        .build();
        source.clear();

        assertThat(built.authedUsers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAuthedUsersIsRead() {
        final GitLabProjectIntegrationsCreateSlackEventPayload built =
                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload();
        final List<String> values = built.authedUsers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsCreateSlackEventPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsCreateSlackEventPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsCreateSlackEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("token", "teamId", "apiAppId", "event", "type", "eventId", "eventTime", "authedUsers");
    }
}
