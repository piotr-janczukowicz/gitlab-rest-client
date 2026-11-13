package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersVerifyPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceRunnersVerifyPayloadBuilder builder = GitLabInstanceRunnersVerifyPayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersVerifyPayload())
                .token(null);

        final GitLabInstanceRunnersVerifyPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemIdIsNullable() {
        final GitLabInstanceRunnersVerifyPayloadBuilder builder = GitLabInstanceRunnersVerifyPayloadBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersVerifyPayload())
                .systemId(null);

        final GitLabInstanceRunnersVerifyPayload built = builder.build();

        assertThat(built.systemId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersVerifyPayload value = RunnersCatalogFixtures.instanceRunnersVerifyPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.systemId()).isEqualTo("system_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersVerifyPayload original = RunnersCatalogFixtures.instanceRunnersVerifyPayload();

        final GitLabInstanceRunnersVerifyPayload rebuilt =
                GitLabInstanceRunnersVerifyPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceRunnersVerifyPayload value = RunnersCatalogFixtures.instanceRunnersVerifyPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersVerifyPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "systemId");
    }
}
