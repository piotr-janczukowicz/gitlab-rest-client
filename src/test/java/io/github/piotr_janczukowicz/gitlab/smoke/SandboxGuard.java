package io.github.piotr_janczukowicz.gitlab.smoke;

import java.util.Locale;

final class SandboxGuard {

    private SandboxGuard() {
        throw new UnsupportedOperationException("Utility class");
    }

    static void requireSandbox(final SmokeEnvironment env) {
        final String project = env.project();
        final boolean isPath = project.contains("/");
        if (!isPath || !project.toLowerCase(Locale.ROOT).contains("smoke")) {
            throw new IllegalStateException(SmokeEnvironment.PROJECT_VARIABLE
                    + " must be the path of a sandbox project (group/name) whose path contains \"smoke\", but was: "
                    + project);
        }
    }
}
