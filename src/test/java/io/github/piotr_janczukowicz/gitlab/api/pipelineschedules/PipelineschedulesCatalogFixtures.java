package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class PipelineschedulesCatalogFixtures {

    private PipelineschedulesCatalogFixtures() {}

    public static GitLabCiInput ciInput() {
        return GitLabCiInputBuilder.builder().name("name").value("value").build();
    }

    public static GitLabCiPipelineSchedule ciPipelineSchedule() {
        return GitLabCiPipelineScheduleBuilder.builder()
                .id(1L)
                .description("Test schedule pipeline")
                .ref("develop")
                .cron("* * * * *")
                .cronTimezone("Asia/Tokyo")
                .nextRunAt(Instant.parse("2026-01-01T00:00:00Z"))
                .active(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .owner(CommonCatalogFixtures.userBasic())
                .inputs(List.of(PipelineschedulesCatalogFixtures.ciInput()))
                .build();
    }

    public static GitLabCiPipelineScheduleDetails ciPipelineScheduleDetails() {
        return GitLabCiPipelineScheduleDetailsBuilder.builder()
                .id(1L)
                .description("Test schedule pipeline")
                .ref("develop")
                .cron("* * * * *")
                .cronTimezone("Asia/Tokyo")
                .nextRunAt(Instant.parse("2026-01-01T00:00:00Z"))
                .active(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .owner(CommonCatalogFixtures.userBasic())
                .inputs(List.of(PipelineschedulesCatalogFixtures.ciInput()))
                .lastPipeline(CommonCatalogFixtures.ciPipelineBasic())
                .variables(List.of(CommonCatalogFixtures.ciVariable()))
                .build();
    }

    public static GitLabProjectPipelineSchedulesCreateInput projectPipelineSchedulesCreateInput() {
        return GitLabProjectPipelineSchedulesCreateInputBuilder.builder()
                .name("deploy_strategy")
                .value(List.of("value"))
                .build();
    }

    public static GitLabProjectPipelineSchedulesCreatePayload projectPipelineSchedulesCreatePayload() {
        return GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder()
                .description("Test schedule pipeline")
                .ref("develop")
                .cron("* * * * *")
                .cronTimezone("Asia/Tokyo")
                .active(true)
                .inputs(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput()))
                .build();
    }

    public static GitLabProjectPipelineSchedulesCreateVariablePayload projectPipelineSchedulesCreateVariablePayload() {
        return GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder.builder()
                .key("NEW_VARIABLE")
                .value("new value")
                .variableType(GitLabProjectPipelineSchedulesCreateVariableType.ENV_VAR)
                .build();
    }

    public static GitLabProjectPipelineSchedulesUpdateInput projectPipelineSchedulesUpdateInput() {
        return GitLabProjectPipelineSchedulesUpdateInputBuilder.builder()
                .name("deploy_strategy")
                .destroy(true)
                .value(List.of("value"))
                .build();
    }

    public static GitLabProjectPipelineSchedulesUpdatePayload projectPipelineSchedulesUpdatePayload() {
        return GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder()
                .description("Test schedule pipeline")
                .ref("develop")
                .cron("* * * * *")
                .cronTimezone("Asia/Tokyo")
                .active(true)
                .inputs(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput()))
                .build();
    }

    public static GitLabProjectPipelineSchedulesUpdateVariablePayload projectPipelineSchedulesUpdateVariablePayload() {
        return GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder.builder()
                .value("new value")
                .variableType(GitLabProjectPipelineSchedulesUpdateVariableType.ENV_VAR)
                .build();
    }
}
