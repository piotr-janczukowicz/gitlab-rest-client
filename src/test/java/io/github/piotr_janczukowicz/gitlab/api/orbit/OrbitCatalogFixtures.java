package io.github.piotr_janczukowicz.gitlab.api.orbit;

import java.util.List;
import java.util.Map;

public final class OrbitCatalogFixtures {

    private OrbitCatalogFixtures() {}

    public static GitLabOrbitContext orbitContext() {
        return GitLabOrbitContextBuilder.builder()
                .version("1.3.0")
                .entities(List.of(OrbitCatalogFixtures.orbitContextEntity()))
                .build();
    }

    public static GitLabOrbitContextEntity orbitContextEntity() {
        return GitLabOrbitContextEntityBuilder.builder()
                .token("MergeRequest[123]")
                .resolvedToken("MergeRequest[123]")
                .type("MergeRequest")
                .id("123")
                .found(true)
                .summary(Map.of("key", "value"))
                .error(Map.of("key", "value"))
                .expansion(Map.of("key", "value"))
                .build();
    }

    public static GitLabOrbitContextPayload orbitContextPayload() {
        return GitLabOrbitContextPayloadBuilder.builder()
                .tokens(List.of("tokens"))
                .expand(true)
                .responseFormat(GitLabOrbitContextResponseFormat.RAW)
                .build();
    }

    public static GitLabOrbitSkill orbitSkill() {
        return GitLabOrbitSkillBuilder.builder()
                .name("orbit")
                .version("0.29.0")
                .compatibility("Orbit CLI")
                .serverVersion("0.31.0")
                .files(List.of(OrbitCatalogFixtures.orbitSkillFile()))
                .build();
    }

    public static GitLabOrbitSkillCollection orbitSkillCollection() {
        return GitLabOrbitSkillCollectionBuilder.builder()
                .skills(List.of(OrbitCatalogFixtures.orbitSkillSummary()))
                .serverVersion("0.31.0")
                .build();
    }

    public static GitLabOrbitSkillFile orbitSkillFile() {
        return GitLabOrbitSkillFileBuilder.builder()
                .path("SKILL.md")
                .sha256("abc123")
                .content("# Orbit skill")
                .build();
    }

    public static GitLabOrbitSkillSummary orbitSkillSummary() {
        return GitLabOrbitSkillSummaryBuilder.builder()
                .name("orbit")
                .version("0.29.0")
                .compatibility("Orbit CLI")
                .description("Use the glab orbit CLI.")
                .build();
    }
}
