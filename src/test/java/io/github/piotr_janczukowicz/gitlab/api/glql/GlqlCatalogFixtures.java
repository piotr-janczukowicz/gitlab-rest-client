package io.github.piotr_janczukowicz.gitlab.api.glql;

import java.util.List;
import java.util.Map;

public final class GlqlCatalogFixtures {

    private GlqlCatalogFixtures() {}

    public static GitLabGLQLCreatePayload glqlcreatePayload() {
        return GitLabGLQLCreatePayloadBuilder.builder()
                .glqlYaml("glql_yaml")
                .after("after")
                .build();
    }

    public static GitLabGlqlData glqlData() {
        return GitLabGlqlDataBuilder.builder()
                .count(1)
                .pageInfo(GlqlCatalogFixtures.glqlPageInfo())
                .build();
    }

    public static GitLabGlqlField glqlField() {
        return GitLabGlqlFieldBuilder.builder()
                .key("title")
                .label("Title")
                .name("title")
                .field("title")
                .type("dimension")
                .parameters(Map.of("key", "value"))
                .build();
    }

    public static GitLabGlqlPageInfo glqlPageInfo() {
        return GitLabGlqlPageInfoBuilder.builder()
                .endCursor("eyJpZCI6IjE3In0")
                .hasNextPage(true)
                .hasPreviousPage(true)
                .startCursor("eyJpZCI6IjE3In0")
                .build();
    }

    public static GitLabGlqlResult glqlResult() {
        return GitLabGlqlResultBuilder.builder()
                .data(GlqlCatalogFixtures.glqlData())
                .error("error")
                .fields(List.of(GlqlCatalogFixtures.glqlField()))
                .success(true)
                .build();
    }
}
