package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import java.util.List;

public final class DebiandistributionsCatalogFixtures {

    private DebiandistributionsCatalogFixtures() {}

    public static GitLabProjectDebianDistributionsCreatePayload projectDebianDistributionsCreatePayload() {
        return GitLabProjectDebianDistributionsCreatePayloadBuilder.builder()
                .codename("sid")
                .suite("unstable")
                .origin("Grep")
                .label("grep.be")
                .description("My description")
                .validTimeDurationSeconds(1)
                .components(List.of("components"))
                .architectures(List.of("architectures"))
                .build();
    }

    public static GitLabProjectDebianDistributionsUpdatePayload projectDebianDistributionsUpdatePayload() {
        return GitLabProjectDebianDistributionsUpdatePayloadBuilder.builder()
                .suite("unstable")
                .origin("Grep")
                .label("grep.be")
                .description("My description")
                .validTimeDurationSeconds(1)
                .components(List.of("components"))
                .architectures(List.of("architectures"))
                .build();
    }
}
