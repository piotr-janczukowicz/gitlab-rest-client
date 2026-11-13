package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .url(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .name(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .description(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .token(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .signingToken(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .pushEvents(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .tagPushEvents(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .mergeRequestsEvents(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUpdateEventsIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .repositoryUpdateEvents(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.repositoryUpdateEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .enableSslVerification(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .pushEventsBranchFilter(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .branchFilterStrategy(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .customWebhookTemplate(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .urlVariables(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabSystemHooksUpdatePayloadBuilder builder = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .customHeaders(null);

        final GitLabSystemHooksUpdatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksUpdatePayload value = SystemhooksCatalogFixtures.systemHooksUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.signingToken()).isEqualTo("signing_token");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.repositoryUpdateEvents()).isEqualTo(true);
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.pushEventsBranchFilter()).isEqualTo("push_events_branch_filter");
            softly.assertThat(value.branchFilterStrategy())
                    .isEqualTo(GitLabSystemHooksUpdateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("custom_webhook_template");
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksUpdatePayload original = SystemhooksCatalogFixtures.systemHooksUpdatePayload();

        final GitLabSystemHooksUpdatePayload rebuilt =
                GitLabSystemHooksUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabSystemHooksUpdateUrlVariable> source =
                new ArrayList<>(List.of(SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable()));
        final GitLabSystemHooksUpdatePayload built = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .urlVariables(source)
                .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabSystemHooksUpdatePayload built = SystemhooksCatalogFixtures.systemHooksUpdatePayload();
        final List<GitLabSystemHooksUpdateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabSystemHooksUpdateCustomHeader> source =
                new ArrayList<>(List.of(SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader()));
        final GitLabSystemHooksUpdatePayload built = GitLabSystemHooksUpdatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdatePayload())
                .customHeaders(source)
                .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabSystemHooksUpdatePayload built = SystemhooksCatalogFixtures.systemHooksUpdatePayload();
        final List<GitLabSystemHooksUpdateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabSystemHooksUpdatePayload value = SystemhooksCatalogFixtures.systemHooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabSystemHooksUpdatePayload value = SystemhooksCatalogFixtures.systemHooksUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "url",
                        "name",
                        "description",
                        "token",
                        "signingToken",
                        "pushEvents",
                        "tagPushEvents",
                        "mergeRequestsEvents",
                        "repositoryUpdateEvents",
                        "enableSslVerification",
                        "pushEventsBranchFilter",
                        "branchFilterStrategy",
                        "customWebhookTemplate",
                        "urlVariables",
                        "customHeaders");
    }
}
