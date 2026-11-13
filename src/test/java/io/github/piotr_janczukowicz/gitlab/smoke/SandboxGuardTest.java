package io.github.piotr_janczukowicz.gitlab.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SandboxGuardTest {

    private static SmokeEnvironment environment(final String project) {
        return SmokeEnvironment.of(Map.of(SmokeEnvironment.PROJECT_VARIABLE, project));
    }

    @Test
    void requireSandbox_shouldPass_whenProjectPathContainsSmoke() {
        final SmokeEnvironment env = environment("acme/My-SMOKE-box");

        final Throwable thrown = catchThrowable(() -> SandboxGuard.requireSandbox(env));

        assertThat(thrown).isNull();
    }

    @Test
    void requireSandbox_shouldThrow_whenProjectLooksLikeAProductionProject() {
        final SmokeEnvironment env = environment("acme/gitlab-api");

        final Throwable thrown = catchThrowable(() -> SandboxGuard.requireSandbox(env));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("acme/gitlab-api");
    }

    @Test
    void requireSandbox_shouldThrow_whenProjectIsANumericId() {
        final SmokeEnvironment env = environment("12345");

        final Throwable thrown = catchThrowable(() -> SandboxGuard.requireSandbox(env));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("12345");
    }

    @Test
    void constructor_shouldBeUnsupported() throws ReflectiveOperationException {
        final Constructor<SandboxGuard> constructor = SandboxGuard.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        final Throwable thrown = catchThrowable(constructor::newInstance);

        assertThat(thrown).hasCauseInstanceOf(UnsupportedOperationException.class);
    }
}
