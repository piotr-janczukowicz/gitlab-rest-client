package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRolloutsCreateChannelTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenChannelNameIsNullable() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .channelName(null);

        final GitLabRolloutsCreateChannelToken built = builder.build();

        assertThat(built.channelName()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenChannelNameIsTooLong() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .channelName("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenChannelNameHasTheMaximumLength() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .channelName("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .token(null);

        final GitLabRolloutsCreateChannelToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenTokenIsTooLong() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .token("x".repeat(4097));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenTokenHasTheMaximumLength() {
        final GitLabRolloutsCreateChannelTokenBuilder builder = GitLabRolloutsCreateChannelTokenBuilder.builder(
                        RolloutsCatalogFixtures.rolloutsCreateChannelToken())
                .token("x".repeat(4096));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRolloutsCreateChannelToken value = RolloutsCatalogFixtures.rolloutsCreateChannelToken();

        assertSoftly(softly -> {
            softly.assertThat(value.channelName()).isEqualTo("channel_name");
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRolloutsCreateChannelToken original = RolloutsCatalogFixtures.rolloutsCreateChannelToken();

        final GitLabRolloutsCreateChannelToken rebuilt =
                GitLabRolloutsCreateChannelTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabRolloutsCreateChannelToken value = RolloutsCatalogFixtures.rolloutsCreateChannelToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRolloutsCreateChannelToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("channelName", "token");
    }
}
