package io.github.piotr_janczukowicz.gitlab.api.metadata;

public final class MetadataCatalogFixtures {

    private MetadataCatalogFixtures() {}

    public static GitLabMetadata metadata() {
        return GitLabMetadataBuilder.builder()
                .version("15.2-pre")
                .revision("c401a659d0c")
                .kas(MetadataCatalogFixtures.metadataKas())
                .enterprise(true)
                .plan("ultimate")
                .build();
    }

    public static GitLabMetadataKas metadataKas() {
        return GitLabMetadataKasBuilder.builder()
                .enabled(true)
                .externalUrl("grpc://gitlab.example.com:8150")
                .externalK8sProxyUrl("https://gitlab.example.com:8150/k8s-proxy")
                .version("15.0.0")
                .build();
    }
}
