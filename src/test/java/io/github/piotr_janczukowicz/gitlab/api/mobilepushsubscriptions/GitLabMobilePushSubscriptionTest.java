package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMobilePushSubscriptionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMobilePushSubscriptionBuilder builder = GitLabMobilePushSubscriptionBuilder.builder(
                        MobilepushsubscriptionsCatalogFixtures.mobilePushSubscription())
                .id(null);

        final GitLabMobilePushSubscription built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMobilePushSubscriptionBuilder builder = GitLabMobilePushSubscriptionBuilder.builder(
                        MobilepushsubscriptionsCatalogFixtures.mobilePushSubscription())
                .createdAt(null);

        final GitLabMobilePushSubscription built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMobilePushSubscription value = MobilepushsubscriptionsCatalogFixtures.mobilePushSubscription();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMobilePushSubscription original = MobilepushsubscriptionsCatalogFixtures.mobilePushSubscription();

        final GitLabMobilePushSubscription rebuilt =
                GitLabMobilePushSubscriptionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMobilePushSubscription.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "createdAt");
    }
}
