package io.github.piotr_janczukowicz.gitlab.api.errortracking;

public final class ErrortrackingCatalogFixtures {

    private ErrortrackingCatalogFixtures() {}

    public static GitLabErrorTrackingClientKey errorTrackingClientKey() {
        return GitLabErrorTrackingClientKeyBuilder.builder()
                .id(1L)
                .active(true)
                .publicKey("glet_aa77551d849c083f76d0bc545ed053a3")
                .sentryDsn("https://glet_aa77551d849c083f76d0bc545ed053a3@example.com/errortracking/api/v1/projects/5")
                .build();
    }

    public static GitLabErrorTrackingProjectSetting errorTrackingProjectSetting() {
        return GitLabErrorTrackingProjectSettingBuilder.builder()
                .active(true)
                .projectName("sample sentry project")
                .sentryExternalUrl("https://sentry.io/myawesomeproject/project")
                .apiUrl("https://sentry.io/api/0/projects/myawesomeproject/project")
                .integrated(true)
                .build();
    }

    public static GitLabProjectErrorTrackingPatchPayload projectErrorTrackingPatchPayload() {
        return GitLabProjectErrorTrackingPatchPayloadBuilder.builder()
                .active(true)
                .integrated(true)
                .build();
    }

    public static GitLabProjectErrorTrackingUpdatePayload projectErrorTrackingUpdatePayload() {
        return GitLabProjectErrorTrackingUpdatePayloadBuilder.builder()
                .active(true)
                .integrated(true)
                .build();
    }
}
