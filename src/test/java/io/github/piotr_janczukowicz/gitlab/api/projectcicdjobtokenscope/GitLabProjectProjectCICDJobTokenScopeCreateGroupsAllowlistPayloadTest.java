package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetGroupIdIsNullable() {
        final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayloadBuilder builder =
                GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayloadBuilder.builder(
                                ProjectcicdjobtokenscopeCatalogFixtures
                                        .projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload())
                        .targetGroupId(null);

        final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload built = builder.build();

        assertThat(built.targetGroupId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload value =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload();

        assertThat(value.targetGroupId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload original =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload();

        final GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload rebuilt =
                GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetGroupId");
    }
}
