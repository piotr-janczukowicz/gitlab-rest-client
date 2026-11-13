package io.github.piotr_janczukowicz.gitlab.api.codesearch;

public final class CodesearchCatalogFixtures {

    private CodesearchCatalogFixtures() {}

    public static GitLabCodeSearchUpdateNamespacePayload codeSearchUpdateNamespacePayload() {
        return GitLabCodeSearchUpdateNamespacePayloadBuilder.builder()
                .numberOfReplicasOverride(1)
                .build();
    }

    public static GitLabCodeSearchUpdateShardsIndexedNamespacePayload codeSearchUpdateShardsIndexedNamespacePayload() {
        return GitLabCodeSearchUpdateShardsIndexedNamespacePayloadBuilder.builder()
                .search(true)
                .build();
    }

    public static GitLabSearchZoektIndexedNamespace searchZoektIndexedNamespace() {
        return GitLabSearchZoektIndexedNamespaceBuilder.builder()
                .id(1L)
                .zoektShardId(1L)
                .zoektNodeId(1L)
                .namespaceId(1L)
                .numberOfReplicasOverride(1)
                .build();
    }

    public static GitLabSearchZoektNode searchZoektNode() {
        return GitLabSearchZoektNodeBuilder.builder()
                .id(1L)
                .indexBaseUrl("http://127.0.0.1:6060/")
                .searchBaseUrl("http://127.0.0.1:6070/")
                .build();
    }

    public static GitLabSearchZoektProjectIndexSuccess searchZoektProjectIndexSuccess() {
        return GitLabSearchZoektProjectIndexSuccessBuilder.builder()
                .jobId("job_id")
                .build();
    }
}
