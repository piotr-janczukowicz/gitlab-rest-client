package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabDevOpsResearchAndAssessmentDORAMetricsApi {

    private final LazyValue<GitLabGroupDevOpsResearchAndAssessmentDORAMetricsApi> group;
    private final LazyValue<GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDevOpsResearchAndAssessmentDORAMetricsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupDevOpsResearchAndAssessmentDORAMetricsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupDevOpsResearchAndAssessmentDORAMetricsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectDevOpsResearchAndAssessmentDORAMetricsApi project() {
        return project.get();
    }
}
