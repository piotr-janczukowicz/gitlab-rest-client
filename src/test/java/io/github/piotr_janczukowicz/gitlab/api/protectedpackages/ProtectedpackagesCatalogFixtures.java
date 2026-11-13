package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

public final class ProtectedpackagesCatalogFixtures {

    private ProtectedpackagesCatalogFixtures() {}

    public static GitLabProjectPackagesProtectionRule projectPackagesProtectionRule() {
        return GitLabProjectPackagesProtectionRuleBuilder.builder()
                .id(1L)
                .projectId(1L)
                .packageNamePattern("flightjs/flight")
                .packageType("npm")
                .minimumAccessLevelForDelete("owner")
                .minimumAccessLevelForPush("maintainer")
                .build();
    }

    public static GitLabProjectProtectedPackagesCreatePayload projectProtectedPackagesCreatePayload() {
        return GitLabProjectProtectedPackagesCreatePayloadBuilder.builder()
                .packageNamePattern("package_name_pattern")
                .packageType(GitLabProjectProtectedPackagesCreatePackageType.CARGO)
                .minimumAccessLevelForDelete(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.OWNER)
                .minimumAccessLevelForPush(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForPush.MAINTAINER)
                .build();
    }

    public static GitLabProjectProtectedPackagesUpdatePayload projectProtectedPackagesUpdatePayload() {
        return GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder()
                .packageNamePattern("package_name_pattern")
                .packageType(GitLabProjectProtectedPackagesUpdatePackageType.CARGO)
                .minimumAccessLevelForDelete(GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete.OWNER)
                .minimumAccessLevelForPush(GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForPush.MAINTAINER)
                .build();
    }
}
