package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SmokeEnvironmentTest {

    @Test
    void configured_shouldBeFalse_whenTheTokenOrTheProjectIsMissing() {
        final SmokeEnvironment noToken = SmokeEnvironment.of(Map.of(SmokeEnvironment.PROJECT_VARIABLE, "a/smoke"));
        final SmokeEnvironment noProject = SmokeEnvironment.of(Map.of(SmokeEnvironment.TOKEN_VARIABLE, "t"));

        assertSoftly(softly -> {
            softly.assertThat(noToken.configured()).isFalse();
            softly.assertThat(noProject.configured()).isFalse();
        });
    }

    @Test
    void configured_shouldBeTrue_whenBothAreSetAndBlanksAreStripped() {
        final SmokeEnvironment env = SmokeEnvironment.of(
                Map.of(SmokeEnvironment.TOKEN_VARIABLE, " t \n", SmokeEnvironment.PROJECT_VARIABLE, " a/smoke "));

        assertSoftly(softly -> {
            softly.assertThat(env.configured()).isTrue();
            softly.assertThat(env.project()).isEqualTo("a/smoke");
        });
    }

    @Test
    void name_shouldStartWithTheSmokePrefixAndTheRunId_whenASuffixIsGiven() {
        final SmokeEnvironment env = SmokeEnvironment.of(Map.of());

        final String name = env.name("label");

        assertThat(name).isEqualTo("smoke-" + env.runId() + "-label");
    }

    @Test
    void toString_shouldNotShowTheToken_whenPrinted() {
        final SmokeEnvironment env = SmokeEnvironment.of(
                Map.of(SmokeEnvironment.TOKEN_VARIABLE, "secret-token", SmokeEnvironment.PROJECT_VARIABLE, "a/smoke"));

        final String text = env.toString();

        assertThat(text).doesNotContain("secret-token").contains("a/smoke");
    }
}
