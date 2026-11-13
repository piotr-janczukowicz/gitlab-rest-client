package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsEmailsOnPushPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSendFromCommitterEmailIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .sendFromCommitterEmail(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.sendFromCommitterEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisableDiffsIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .disableDiffs(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.disableDiffs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesToBeNotifiedIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .branchesToBeNotified(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.branchesToBeNotified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .recipients(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder builder =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sendFromCommitterEmail()).isEqualTo(true);
            softly.assertThat(value.disableDiffs()).isEqualTo(true);
            softly.assertThat(value.branchesToBeNotified()).isEqualTo("branches_to_be_notified");
            softly.assertThat(value.recipients()).isEqualTo("recipients");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsEmailsOnPushPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsEmailsOnPushPayload();

        final GitLabGroupGroupIntegrationsEmailsOnPushPayload rebuilt =
                GitLabGroupGroupIntegrationsEmailsOnPushPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsEmailsOnPushPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "sendFromCommitterEmail",
                        "disableDiffs",
                        "branchesToBeNotified",
                        "recipients",
                        "pushEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
