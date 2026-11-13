package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabErrorTrackingClientKeyTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabErrorTrackingClientKeyBuilder builder = GitLabErrorTrackingClientKeyBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingClientKey())
                .id(null);

        final GitLabErrorTrackingClientKey built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabErrorTrackingClientKeyBuilder builder = GitLabErrorTrackingClientKeyBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingClientKey())
                .active(null);

        final GitLabErrorTrackingClientKey built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicKeyIsNullable() {
        final GitLabErrorTrackingClientKeyBuilder builder = GitLabErrorTrackingClientKeyBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingClientKey())
                .publicKey(null);

        final GitLabErrorTrackingClientKey built = builder.build();

        assertThat(built.publicKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSentryDsnIsNullable() {
        final GitLabErrorTrackingClientKeyBuilder builder = GitLabErrorTrackingClientKeyBuilder.builder(
                        ErrortrackingCatalogFixtures.errorTrackingClientKey())
                .sentryDsn(null);

        final GitLabErrorTrackingClientKey built = builder.build();

        assertThat(built.sentryDsn()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabErrorTrackingClientKey value = ErrortrackingCatalogFixtures.errorTrackingClientKey();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.publicKey()).isEqualTo("glet_aa77551d849c083f76d0bc545ed053a3");
            softly.assertThat(value.sentryDsn())
                    .isEqualTo(
                            "https://glet_aa77551d849c083f76d0bc545ed053a3@example.com/errortracking/api/v1/projects/5");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabErrorTrackingClientKey original = ErrortrackingCatalogFixtures.errorTrackingClientKey();

        final GitLabErrorTrackingClientKey rebuilt =
                GitLabErrorTrackingClientKeyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabErrorTrackingClientKey.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "active", "publicKey", "sentryDsn");
    }
}
