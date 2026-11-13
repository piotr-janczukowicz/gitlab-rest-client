package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabHookTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).id(null);

        final GitLabHook built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).url(null);

        final GitLabHook built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).name(null);

        final GitLabHook built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).description(null);

        final GitLabHook built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).createdAt(null);

        final GitLabHook built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).pushEvents(null);

        final GitLabHook built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).tagPushEvents(null);

        final GitLabHook built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).mergeRequestsEvents(null);

        final GitLabHook built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUpdateEventsIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).repositoryUpdateEvents(null);

        final GitLabHook built = builder.build();

        assertThat(built.repositoryUpdateEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).enableSslVerification(null);

        final GitLabHook built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).organizationId(null);

        final GitLabHook built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAlertStatusIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).alertStatus(null);

        final GitLabHook built = builder.build();

        assertThat(built.alertStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisabledUntilIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).disabledUntil(null);

        final GitLabHook built = builder.build();

        assertThat(built.disabledUntil()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlVariablesIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).urlVariables(null);

        final GitLabHook built = builder.build();

        assertThat(built.urlVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsBranchFilterIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).pushEventsBranchFilter(null);

        final GitLabHook built = builder.build();

        assertThat(built.pushEventsBranchFilter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchFilterStrategyIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).branchFilterStrategy(null);

        final GitLabHook built = builder.build();

        assertThat(built.branchFilterStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomWebhookTemplateIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).customWebhookTemplate(null);

        final GitLabHook built = builder.build();

        assertThat(built.customWebhookTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHeadersIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).customHeaders(null);

        final GitLabHook built = builder.build();

        assertThat(built.customHeaders()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenPresentIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).tokenPresent(null);

        final GitLabHook built = builder.build();

        assertThat(built.tokenPresent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigningTokenPresentIsNullable() {
        final GitLabHookBuilder builder =
                GitLabHookBuilder.builder(SystemhooksCatalogFixtures.hook()).signingTokenPresent(null);

        final GitLabHook built = builder.build();

        assertThat(built.signingTokenPresent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabHook value = SystemhooksCatalogFixtures.hook();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.url()).isEqualTo("https://webhook.site");
            softly.assertThat(value.name()).isEqualTo("Hook name");
            softly.assertThat(value.description()).isEqualTo("Hook description");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.repositoryUpdateEvents()).isEqualTo(true);
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.organizationId()).isEqualTo(1L);
            softly.assertThat(value.alertStatus()).isEqualTo("executable");
            softly.assertThat(value.disabledUntil()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.urlVariables()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.pushEventsBranchFilter()).isEqualTo("my-branch-*");
            softly.assertThat(value.branchFilterStrategy()).isEqualTo("wildcard");
            softly.assertThat(value.customWebhookTemplate()).isEqualTo("{\"event\":\"{{object_kind}}\"}");
            softly.assertThat(value.customHeaders()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.tokenPresent()).isEqualTo(true);
            softly.assertThat(value.signingTokenPresent()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabHook original = SystemhooksCatalogFixtures.hook();

        final GitLabHook rebuilt = GitLabHookBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabHook.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "url",
                        "name",
                        "description",
                        "createdAt",
                        "pushEvents",
                        "tagPushEvents",
                        "mergeRequestsEvents",
                        "repositoryUpdateEvents",
                        "enableSslVerification",
                        "organizationId",
                        "alertStatus",
                        "disabledUntil",
                        "urlVariables",
                        "pushEventsBranchFilter",
                        "branchFilterStrategy",
                        "customWebhookTemplate",
                        "customHeaders",
                        "tokenPresent",
                        "signingTokenPresent");
    }
}
