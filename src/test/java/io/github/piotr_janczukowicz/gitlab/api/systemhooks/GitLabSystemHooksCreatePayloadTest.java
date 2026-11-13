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
class GitLabSystemHooksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .url(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .name(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .description(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .token(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .signingToken(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.signingToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .pushEvents(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .tagPushEvents(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .mergeRequestsEvents(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUpdateEventsIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .repositoryUpdateEvents(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.repositoryUpdateEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .enableSslVerification(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .pushEventsBranchFilter(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .branchFilterStrategy(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .customWebhookTemplate(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .urlVariables(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabSystemHooksCreatePayloadBuilder builder = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .customHeaders(null);

        final GitLabSystemHooksCreatePayload built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksCreatePayload value = SystemhooksCatalogFixtures.systemHooksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("http://example.com/hook");
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
                    .isEqualTo(GitLabSystemHooksCreateBranchFilterStrategy.WILDCARD);
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("custom_webhook_template");
            softly.assertThat(value.urlVariables())
                    .isEqualTo(List.of(SystemhooksCatalogFixtures.systemHooksCreateUrlVariable()));
            softly.assertThat(value.customHeaders())
                    .isEqualTo(List.of(SystemhooksCatalogFixtures.systemHooksCreateCustomHeader()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksCreatePayload original = SystemhooksCatalogFixtures.systemHooksCreatePayload();

        final GitLabSystemHooksCreatePayload rebuilt =
                GitLabSystemHooksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUrlVariablesSourceChangesLater() {
        final List<GitLabSystemHooksCreateUrlVariable> source =
                new ArrayList<>(List.of(SystemhooksCatalogFixtures.systemHooksCreateUrlVariable()));
        final GitLabSystemHooksCreatePayload built = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .urlVariables(source)
                .build();
        source.clear();

        assertThat(built.urlVariables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUrlVariablesIsRead() {
        final GitLabSystemHooksCreatePayload built = SystemhooksCatalogFixtures.systemHooksCreatePayload();
        final List<GitLabSystemHooksCreateUrlVariable> values = built.urlVariables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCustomHeadersSourceChangesLater() {
        final List<GitLabSystemHooksCreateCustomHeader> source =
                new ArrayList<>(List.of(SystemhooksCatalogFixtures.systemHooksCreateCustomHeader()));
        final GitLabSystemHooksCreatePayload built = GitLabSystemHooksCreatePayloadBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreatePayload())
                .customHeaders(source)
                .build();
        source.clear();

        assertThat(built.customHeaders()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCustomHeadersIsRead() {
        final GitLabSystemHooksCreatePayload built = SystemhooksCatalogFixtures.systemHooksCreatePayload();
        final List<GitLabSystemHooksCreateCustomHeader> values = built.customHeaders();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabSystemHooksCreatePayload value = SystemhooksCatalogFixtures.systemHooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSigningTokenIsACredential() {
        final GitLabSystemHooksCreatePayload value = SystemhooksCatalogFixtures.systemHooksCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksCreatePayload.class.getRecordComponents())
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
