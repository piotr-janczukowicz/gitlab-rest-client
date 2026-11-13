package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEmailTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEmailBuilder builder =
                GitLabEmailBuilder.builder(CommonCatalogFixtures.email()).id(null);

        final GitLabEmail built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabEmailBuilder builder =
                GitLabEmailBuilder.builder(CommonCatalogFixtures.email()).email(null);

        final GitLabEmail built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfirmedAtIsNullable() {
        final GitLabEmailBuilder builder =
                GitLabEmailBuilder.builder(CommonCatalogFixtures.email()).confirmedAt(null);

        final GitLabEmail built = builder.build();

        assertThat(built.confirmedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEmail value = CommonCatalogFixtures.email();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.email()).isEqualTo("user@example.com");
            softly.assertThat(value.confirmedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEmail original = CommonCatalogFixtures.email();

        final GitLabEmail rebuilt = GitLabEmailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEmail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "email", "confirmedAt");
    }
}
