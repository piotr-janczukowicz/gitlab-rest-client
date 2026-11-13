package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

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
class GitLabDuoChatCompletionsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .content(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenContentIsTooLong() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .content("x".repeat(1001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenContentHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .content("x".repeat(1000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .resourceType(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .resourceId(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefererUrlIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .refererUrl(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.refererUrl()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenRefererUrlIsTooLong() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .refererUrl("x".repeat(1001));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenRefererUrlHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .refererUrl("x".repeat(1000));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientSubscriptionIdIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .clientSubscriptionId(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.clientSubscriptionId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenClientSubscriptionIdIsTooLong() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .clientSubscriptionId("x".repeat(501));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenClientSubscriptionIdHasTheMaximumLength() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .clientSubscriptionId("x".repeat(500));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCleanHistoryIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .withCleanHistory(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.withCleanHistory()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .projectId(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentFileIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .currentFile(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.currentFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdditionalContextIsNullable() {
        final GitLabDuoChatCompletionsCreatePayloadBuilder builder =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                        .additionalContext(null);

        final GitLabDuoChatCompletionsCreatePayload built = builder.build();

        assertThat(built.additionalContext()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoChatCompletionsCreatePayload value =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.resourceType()).isEqualTo(GitLabDuoChatCompletionsCreateResourceType.ISSUE);
            softly.assertThat(value.resourceId()).isEqualTo("text");
            softly.assertThat(value.refererUrl()).isEqualTo("referer_url");
            softly.assertThat(value.clientSubscriptionId()).isEqualTo("client_subscription_id");
            softly.assertThat(value.withCleanHistory()).isEqualTo(true);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.currentFile())
                    .isEqualTo(GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile());
            softly.assertThat(value.additionalContext())
                    .isEqualTo(List.of(
                            GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoChatCompletionsCreatePayload original =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload();

        final GitLabDuoChatCompletionsCreatePayload rebuilt =
                GitLabDuoChatCompletionsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAdditionalContextSourceChangesLater() {
        final List<GitLabDuoChatCompletionsCreateAdditionalContext> source = new ArrayList<>(
                List.of(GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext()));
        final GitLabDuoChatCompletionsCreatePayload built = GitLabDuoChatCompletionsCreatePayloadBuilder.builder(
                        GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload())
                .additionalContext(source)
                .build();
        source.clear();

        assertThat(built.additionalContext()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAdditionalContextIsRead() {
        final GitLabDuoChatCompletionsCreatePayload built =
                GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreatePayload();
        final List<GitLabDuoChatCompletionsCreateAdditionalContext> values = built.additionalContext();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoChatCompletionsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "content",
                        "resourceType",
                        "resourceId",
                        "refererUrl",
                        "clientSubscriptionId",
                        "withCleanHistory",
                        "projectId",
                        "currentFile",
                        "additionalContext");
    }
}
