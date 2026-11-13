package io.github.piotr_janczukowicz.gitlab.smoke;

import io.github.piotr_janczukowicz.gitlab.api.GitLab;
import io.github.piotr_janczukowicz.gitlab.api.branches.GitLabBranch;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabIssue;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabel;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsDeleteFilterBuilder;
import java.io.IOException;

final class SmokeCleanup {

    private static final String PREFIX = "smoke-";

    private SmokeCleanup() {
        throw new UnsupportedOperationException("Utility class");
    }

    static void sweep(final SmokeEnvironment env) throws IOException {
        SandboxGuard.requireSandbox(env);
        final GitLab gitLab = env.gitLab();
        final String project = env.project();
        final String current = env.name("");
        for (final GitLabProjectLabel label : gitLab.labels().list(project).all()) {
            if (isLeftover(label.name(), current)) {
                gitLab.labels()
                        .delete(
                                project,
                                GitLabProjectLabelsDeleteFilterBuilder.builder()
                                        .name(label.name())
                                        .build());
            }
        }
        for (final GitLabBranch branch : gitLab.branches().list(project).all()) {
            if (isLeftover(branch.name(), current)) {
                gitLab.branches().delete(project, branch.name());
            }
        }
        for (final GitLabIssue issue : gitLab.issues().project().list(project).all()) {
            if (isLeftover(issue.title(), current)) {
                gitLab.issues().project().delete(project, issue.iid());
            }
        }
    }

    private static boolean isLeftover(final String name, final String current) {
        return name != null && name.startsWith(PREFIX) && !name.startsWith(current);
    }
}
