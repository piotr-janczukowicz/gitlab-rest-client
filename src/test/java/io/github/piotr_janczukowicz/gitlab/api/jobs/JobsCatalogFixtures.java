package io.github.piotr_janczukowicz.gitlab.api.jobs;

import java.util.List;
import java.util.Map;

public final class JobsCatalogFixtures {

    private JobsCatalogFixtures() {}

    public static GitLabCiJobRequestArtifacts ciJobRequestArtifacts() {
        return GitLabCiJobRequestArtifactsBuilder.builder()
                .name("name")
                .untracked(true)
                .paths(List.of("paths"))
                .exclude(List.of("exclude"))
                .when("when")
                .expireIn("expire_in")
                .artifactType("artifact_type")
                .artifactFormat("artifact_format")
                .build();
    }

    public static GitLabCiJobRequestCache ciJobRequestCache() {
        return GitLabCiJobRequestCacheBuilder.builder()
                .key("key")
                .untracked(true)
                .paths(List.of("paths"))
                .policy("policy")
                .when("when")
                .fallbackKeys(List.of("fallback_keys"))
                .build();
    }

    public static GitLabCiJobRequestCredentials ciJobRequestCredentials() {
        return GitLabCiJobRequestCredentialsBuilder.builder()
                .type("type")
                .url("url")
                .username("username")
                .password("password")
                .build();
    }

    public static GitLabCiJobRequestGitInfo ciJobRequestGitInfo() {
        return GitLabCiJobRequestGitInfoBuilder.builder()
                .repoUrl("repo_url")
                .ref("ref")
                .sha("sha")
                .beforeSha("before_sha")
                .refType("ref_type")
                .refspecs("refspecs")
                .depth("depth")
                .repoObjectFormat("repo_object_format")
                .protectedValue("protected")
                .build();
    }

    public static GitLabCiJobRequestHook ciJobRequestHook() {
        return GitLabCiJobRequestHookBuilder.builder()
                .name("name")
                .script(List.of("script"))
                .build();
    }

    public static GitLabCiJobRequestImage ciJobRequestImage() {
        return GitLabCiJobRequestImageBuilder.builder()
                .name("name")
                .entrypoint("entrypoint")
                .ports(List.of(JobsCatalogFixtures.ciJobRequestPort()))
                .executorOpts("executor_opts")
                .pullPolicy("pull_policy")
                .build();
    }

    public static GitLabCiJobRequestJobInfo ciJobRequestJobInfo() {
        return GitLabCiJobRequestJobInfoBuilder.builder()
                .id("id")
                .name("name")
                .stage("stage")
                .tagList(List.of("docker"))
                .pipelineId("pipeline_id")
                .projectId("project_id")
                .projectName("project_name")
                .projectFullPath("project_full_path")
                .namespaceId("namespace_id")
                .rootNamespaceId("root_namespace_id")
                .organizationId("organization_id")
                .instanceId("instance_id")
                .instanceUuid("instance_uuid")
                .userId("user_id")
                .scopedUserId("scoped_user_id")
                .timeInQueueSeconds("time_in_queue_seconds")
                .projectJobsRunningOnInstanceRunnersCount("project_jobs_running_on_instance_runners_count")
                .queueSize("queue_size")
                .queueDepth("queue_depth")
                .build();
    }

    public static GitLabCiJobRequestPort ciJobRequestPort() {
        return GitLabCiJobRequestPortBuilder.builder()
                .number(1)
                .protocol("protocol")
                .name("name")
                .build();
    }

    public static GitLabCiJobRequestResponse ciJobRequestResponse() {
        return GitLabCiJobRequestResponseBuilder.builder()
                .id("id")
                .token("token")
                .allowGitFetch("allow_git_fetch")
                .jobInfo(JobsCatalogFixtures.ciJobRequestJobInfo())
                .gitInfo(JobsCatalogFixtures.ciJobRequestGitInfo())
                .runnerInfo(JobsCatalogFixtures.ciJobRequestRunnerInfo())
                .inputs("inputs")
                .variables("variables")
                .steps(List.of(JobsCatalogFixtures.ciJobRequestStep()))
                .hooks(List.of(JobsCatalogFixtures.ciJobRequestHook()))
                .image(JobsCatalogFixtures.ciJobRequestImage())
                .services(List.of(JobsCatalogFixtures.ciJobRequestService()))
                .artifacts(List.of(JobsCatalogFixtures.ciJobRequestArtifacts()))
                .cache(List.of(JobsCatalogFixtures.ciJobRequestCache()))
                .credentials(List.of(JobsCatalogFixtures.ciJobRequestCredentials()))
                .features("features")
                .dependencies("dependencies")
                .run("run")
                .suspendOptions("suspend_options")
                .secrets("secrets")
                .policyOptions("policy_options")
                .build();
    }

    public static GitLabCiJobRequestRunnerInfo ciJobRequestRunnerInfo() {
        return GitLabCiJobRequestRunnerInfoBuilder.builder()
                .uuid("uuid")
                .timeout("timeout")
                .runnerSessionUrl("runner_session_url")
                .build();
    }

    public static GitLabCiJobRequestService ciJobRequestService() {
        return GitLabCiJobRequestServiceBuilder.builder()
                .name("name")
                .entrypoint("entrypoint")
                .ports(List.of(JobsCatalogFixtures.ciJobRequestPort()))
                .executorOpts("executor_opts")
                .pullPolicy("pull_policy")
                .alias("alias")
                .command("command")
                .variables("variables")
                .build();
    }

    public static GitLabCiJobRequestStep ciJobRequestStep() {
        return GitLabCiJobRequestStepBuilder.builder()
                .name("name")
                .script(List.of("script"))
                .timeout(1)
                .when("when")
                .allowFailure(true)
                .build();
    }

    public static GitLabCiRuntimeEnvironmentKey ciRuntimeEnvironmentKey() {
        return GitLabCiRuntimeEnvironmentKeyBuilder.builder()
                .runtimeEnvironmentKey("42/s_machineid/data")
                .build();
    }

    public static GitLabInstanceJobsAuthorizeArtifactPayload instanceJobsAuthorizeArtifactPayload() {
        return GitLabInstanceJobsAuthorizeArtifactPayloadBuilder.builder()
                .token("token")
                .filesize(1)
                .artifactType(GitLabInstanceJobsAuthorizeArtifactType.ARCHIVE)
                .build();
    }

    public static GitLabInstanceJobsRequestInfo instanceJobsRequestInfo() {
        return GitLabInstanceJobsRequestInfoBuilder.builder()
                .name("name")
                .version("version")
                .revision("revision")
                .platform("platform")
                .architecture("architecture")
                .executor("executor")
                .features(Map.of("key", "value"))
                .config(JobsCatalogFixtures.instanceJobsRequestInfoConfig())
                .labels(Map.of("key", "value"))
                .build();
    }

    public static GitLabInstanceJobsRequestInfoConfig instanceJobsRequestInfoConfig() {
        return GitLabInstanceJobsRequestInfoConfigBuilder.builder().gpus("gpus").build();
    }

    public static GitLabInstanceJobsRequestPayload instanceJobsRequestPayload() {
        return GitLabInstanceJobsRequestPayloadBuilder.builder()
                .token("token")
                .systemId("system_id")
                .lastUpdate("last_update")
                .info(JobsCatalogFixtures.instanceJobsRequestInfo())
                .session(JobsCatalogFixtures.instanceJobsRequestSession())
                .build();
    }

    public static GitLabInstanceJobsRequestSession instanceJobsRequestSession() {
        return GitLabInstanceJobsRequestSessionBuilder.builder()
                .url("url")
                .certificate("certificate")
                .authorization("authorization")
                .build();
    }

    public static GitLabInstanceJobsTracePayload instanceJobsTracePayload() {
        return GitLabInstanceJobsTracePayloadBuilder.builder()
                .token("token")
                .debugTrace(true)
                .build();
    }

    public static GitLabInstanceJobsUpdateOutput instanceJobsUpdateOutput() {
        return GitLabInstanceJobsUpdateOutputBuilder.builder()
                .checksum("checksum")
                .bytesize(1)
                .build();
    }

    public static GitLabInstanceJobsUpdatePayload instanceJobsUpdatePayload() {
        return GitLabInstanceJobsUpdatePayloadBuilder.builder()
                .token("token")
                .state("state")
                .checksum("checksum")
                .failureReason("failure_reason")
                .output(JobsCatalogFixtures.instanceJobsUpdateOutput())
                .exitCode(1)
                .runtimeEnvironmentKey("runtime_environment_key")
                .build();
    }

    public static GitLabProjectJobsCancelPayload projectJobsCancelPayload() {
        return GitLabProjectJobsCancelPayloadBuilder.builder().force(true).build();
    }

    public static GitLabProjectJobsPlayJobVariablesAttribute projectJobsPlayJobVariablesAttribute() {
        return GitLabProjectJobsPlayJobVariablesAttributeBuilder.builder()
                .key("foo")
                .value("bar")
                .build();
    }

    public static GitLabProjectJobsPlayPayload projectJobsPlayPayload() {
        return GitLabProjectJobsPlayPayloadBuilder.builder()
                .jobVariablesAttributes(List.of(JobsCatalogFixtures.projectJobsPlayJobVariablesAttribute()))
                .jobInputs(Map.of("key", "value"))
                .build();
    }

    public static GitLabProjectJobsRetryPayload projectJobsRetryPayload() {
        return GitLabProjectJobsRetryPayloadBuilder.builder()
                .inputs(Map.of("key", "value"))
                .build();
    }
}
