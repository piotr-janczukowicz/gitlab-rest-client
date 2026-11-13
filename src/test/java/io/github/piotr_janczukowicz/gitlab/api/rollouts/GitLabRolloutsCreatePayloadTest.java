package io.github.piotr_janczukowicz.gitlab.api.rollouts;

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
class GitLabRolloutsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTopicIsNullable() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .topic(null);

        final GitLabRolloutsCreatePayload built = builder.build();

        assertThat(built.topic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .type(null);

        final GitLabRolloutsCreatePayload built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenTypeIsTooLong() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .type("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenTypeHasTheMaximumLength() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .type("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .data(null);

        final GitLabRolloutsCreatePayload built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .value(null);

        final GitLabRolloutsCreatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChannelTokensIsNullable() {
        final GitLabRolloutsCreatePayloadBuilder builder = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .channelTokens(null);

        final GitLabRolloutsCreatePayload built = builder.build();

        assertThat(built.channelTokens()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRolloutsCreatePayload value = RolloutsCatalogFixtures.rolloutsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.topic()).isEqualTo("topic");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.data()).isEqualTo(RolloutsCatalogFixtures.rolloutsCreateData());
            softly.assertThat(value.value()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.channelTokens())
                    .isEqualTo(List.of(RolloutsCatalogFixtures.rolloutsCreateChannelToken()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRolloutsCreatePayload original = RolloutsCatalogFixtures.rolloutsCreatePayload();

        final GitLabRolloutsCreatePayload rebuilt =
                GitLabRolloutsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenValueSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabRolloutsCreatePayload built = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .value(source)
                .build();
        source.clear();

        assertThat(built.value()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheList_whenChannelTokensSourceChangesLater() {
        final List<GitLabRolloutsCreateChannelToken> source =
                new ArrayList<>(List.of(RolloutsCatalogFixtures.rolloutsCreateChannelToken()));
        final GitLabRolloutsCreatePayload built = GitLabRolloutsCreatePayloadBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreatePayload())
                .channelTokens(source)
                .build();
        source.clear();

        assertThat(built.channelTokens()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenChannelTokensIsRead() {
        final GitLabRolloutsCreatePayload built = RolloutsCatalogFixtures.rolloutsCreatePayload();
        final List<GitLabRolloutsCreateChannelToken> values = built.channelTokens();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRolloutsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("topic", "type", "data", "value", "channelTokens");
    }
}
