package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSidekiqUpdateConcurrencyLimitPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLimitIsNullable() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .limit(null);

        final GitLabSidekiqUpdateConcurrencyLimitPayload built = builder.build();

        assertThat(built.limit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTtlIsNullable() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .ttl(null);

        final GitLabSidekiqUpdateConcurrencyLimitPayload built = builder.build();

        assertThat(built.ttl()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenTtlIsBelowTheMinimum() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .ttl(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenTtlIsTheMinimum() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .ttl(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenTtlIsAboveTheMaximum() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .ttl(86_401);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenTtlIsTheMaximum() {
        final GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder builder =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(
                                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload())
                        .ttl(86_400);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSidekiqUpdateConcurrencyLimitPayload value =
                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.limit()).isEqualTo(1);
            softly.assertThat(value.ttl()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSidekiqUpdateConcurrencyLimitPayload original =
                SidekiqCatalogFixtures.sidekiqUpdateConcurrencyLimitPayload();

        final GitLabSidekiqUpdateConcurrencyLimitPayload rebuilt =
                GitLabSidekiqUpdateConcurrencyLimitPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSidekiqUpdateConcurrencyLimitPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("limit", "ttl");
    }
}
