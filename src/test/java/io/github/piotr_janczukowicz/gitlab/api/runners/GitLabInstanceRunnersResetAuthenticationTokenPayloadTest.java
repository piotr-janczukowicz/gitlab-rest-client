package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersResetAuthenticationTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceRunnersResetAuthenticationTokenPayloadBuilder builder =
                GitLabInstanceRunnersResetAuthenticationTokenPayloadBuilder.builder(
                                RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload())
                        .token(null);

        final GitLabInstanceRunnersResetAuthenticationTokenPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersResetAuthenticationTokenPayload value =
                RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload();

        assertThat(value.token()).isEqualTo("token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersResetAuthenticationTokenPayload original =
                RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload();

        final GitLabInstanceRunnersResetAuthenticationTokenPayload rebuilt =
                GitLabInstanceRunnersResetAuthenticationTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceRunnersResetAuthenticationTokenPayload value =
                RunnersCatalogFixtures.instanceRunnersResetAuthenticationTokenPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabInstanceRunnersResetAuthenticationTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token");
    }
}
