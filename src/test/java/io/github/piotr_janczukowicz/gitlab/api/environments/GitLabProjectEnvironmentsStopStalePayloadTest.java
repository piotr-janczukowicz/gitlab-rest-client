package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEnvironmentsStopStalePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBeforeIsNullable() {
        final GitLabProjectEnvironmentsStopStalePayloadBuilder builder =
                GitLabProjectEnvironmentsStopStalePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsStopStalePayload())
                        .before(null);

        final GitLabProjectEnvironmentsStopStalePayload built = builder.build();

        assertThat(built.before()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsStopStalePayload value =
                EnvironmentsCatalogFixtures.projectEnvironmentsStopStalePayload();

        assertThat(value.before()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsStopStalePayload original =
                EnvironmentsCatalogFixtures.projectEnvironmentsStopStalePayload();

        final GitLabProjectEnvironmentsStopStalePayload rebuilt =
                GitLabProjectEnvironmentsStopStalePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsStopStalePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("before");
    }
}
