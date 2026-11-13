package io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraForgeUserDelegationUserDelegationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccountIdIsNullable() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .accountId(null);

        final GitLabJiraForgeUserDelegationUserDelegationPayload built = builder.build();

        assertThat(built.accountId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenAccountIdIsTooLong() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .accountId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenAccountIdHasTheMaximumLength() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .accountId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCloudIdIsNullable() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .cloudId(null);

        final GitLabJiraForgeUserDelegationUserDelegationPayload built = builder.build();

        assertThat(built.cloudId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenCloudIdIsTooLong() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .cloudId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenCloudIdHasTheMaximumLength() {
        final GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder builder =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(
                                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload())
                        .cloudId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraForgeUserDelegationUserDelegationPayload value =
                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accountId()).isEqualTo("account_id");
            softly.assertThat(value.cloudId()).isEqualTo("cloud_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraForgeUserDelegationUserDelegationPayload original =
                JiraforgeuserdelegationCatalogFixtures.jiraForgeUserDelegationUserDelegationPayload();

        final GitLabJiraForgeUserDelegationUserDelegationPayload rebuilt =
                GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabJiraForgeUserDelegationUserDelegationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accountId", "cloudId");
    }
}
